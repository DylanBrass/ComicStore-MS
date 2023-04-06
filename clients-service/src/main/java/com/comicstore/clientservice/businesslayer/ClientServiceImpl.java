package com.comicstore.clientservice.businesslayer;

import com.comicstore.clientservice.Utils.Exceptions.DuplicateFullNameException;
import com.comicstore.clientservice.Utils.Exceptions.NoEmailAndPhoneException;
import com.comicstore.clientservice.Utils.Exceptions.NotFoundException;
import com.comicstore.clientservice.datalayer.Client;
import com.comicstore.clientservice.datalayer.ClientIdentifier;
import com.comicstore.clientservice.datalayer.ClientRepository;
import com.comicstore.clientservice.datalayer.StoreIdentifier;
import com.comicstore.clientservice.datamapperlayer.ClientRequestMapper;
import com.comicstore.clientservice.datamapperlayer.ClientResponseMapper;
import com.comicstore.clientservice.presentationlayer.ClientRequestModel;
import com.comicstore.clientservice.presentationlayer.ClientResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    //private final TournamentRepository tournamentRepository;
    private final ClientResponseMapper clientResponseMapper;


    public ClientServiceImpl(ClientRepository clientRepository, /*TournamentRepository tournamentRepository, */ ClientResponseMapper clientResponseMapper) {
        this.clientRepository = clientRepository;
        //this.tournamentRepository = tournamentRepository;
        this.clientResponseMapper = clientResponseMapper;
    }

    @Override
    public List<ClientResponseModel> getStoreClients(String storeId) {
        /*
        Store store = storeRepository.findByStoreIdentifier_StoreId(storeId);
        if(store == null){
            return null;
        }
        */
        return clientResponseMapper.entityListToResponseModelList(clientRepository.findClientByStoreIdentifier_StoreId(storeId));



    }
    @Override
    public List<ClientResponseModel> getClients() {
        return clientResponseMapper.entityListToResponseModelList(clientRepository.findAll());
    }

    @Override
    public ClientResponseModel getClientById(String clientId) {
        Client client = clientRepository.findClientByClientIdentifier_ClientId(clientId);
        if(client == null){
            throw new NotFoundException("No client found with id : " + clientId);
        }
        return clientResponseMapper.entityToResponseModel(client);
    }

    @Override
    public ClientResponseModel createClient(String storeId, ClientRequestModel clientRequestModel) {

        if(clientRequestModel.getPhoneNumber() == null && clientRequestModel.getEmail() == null){
            throw new NoEmailAndPhoneException("You must enter an email or a phone number");
        }

        if( clientRepository.existsByLastName(clientRequestModel.getLastName()) && clientRepository.existsByFirstName(clientRequestModel.getFirstName())){
            throw new DuplicateFullNameException("A client with the name : " + clientRequestModel.getFirstName() +" "+ clientRequestModel.getLastName() + " already exists !");
        }

        Client client = new Client(clientRequestModel.getFirstName(),clientRequestModel.getLastName(),
                clientRequestModel.getTotalBought(),
                clientRequestModel.getEmail(),clientRequestModel.getPhoneNumber());
        client.setClientIdentifier(new ClientIdentifier());
        //need to check if store exists
        client.setStoreIdentifier(new StoreIdentifier(storeId));
        return clientResponseMapper.entityToResponseModel(clientRepository.save(client));
    }

    @Override
    public ClientResponseModel updateClient(ClientRequestModel clientRequestModel, String clientId) {

        if(clientRepository.existsByFirstName(clientRequestModel.getFirstName()) && clientRepository.existsByLastName(clientRequestModel.getLastName())){
            throw new DuplicateFullNameException("A client with the name : " + clientRequestModel.getFirstName() + clientRequestModel.getLastName() + " already exists !");
        }

        Client existingClient = clientRepository.findClientByClientIdentifier_ClientId(clientId);
        if(existingClient == null){
            throw new NotFoundException("No client found with id : " + clientId);
        }
        Client client = new Client(clientRequestModel.getFirstName(),clientRequestModel.getLastName(),
                clientRequestModel.getTotalBought(),
                clientRequestModel.getEmail(),clientRequestModel.getPhoneNumber());
        client.setClientIdentifier(existingClient.getClientIdentifier());
        client.setId(existingClient.getId());
//check if store exists
        //if(clientRequestModel.getStoreIdentifier() == null) {
        client.setStoreIdentifier(existingClient.getStoreIdentifier());
        //}
        //else {
            //client.setStoreIdentifier(new StoreIdentifier(clientRequestModel.getStoreIdentifier()));
        //}

        return clientResponseMapper.entityToResponseModel(clientRepository.save(client));
    }

    @Override
    public void deleteClient(String clientId) {
        Client client = clientRepository.findClientByClientIdentifier_ClientId(clientId);

        if(client == null)
            throw new NotFoundException("No client found with id : " + clientId);
        /*
        List<Tournament> tournaments = tournamentRepository.getTournamentsByPlayers(client.getClientIdentifier());
        if(tournaments == null)
            return;
        tournamentRepository.deleteAll();
*/
        clientRepository.delete(client);
    }


}
