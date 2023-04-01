package com.comicstore.clientservice.businesslayer;

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
    public List<ClientResponseModel> getClients() {
        return clientResponseMapper.entityListToResponseModelList(clientRepository.findAll());
    }

    @Override
    public ClientResponseModel getClientById(String clientId) {
        Client client = clientRepository.findClientByClientIdentifier_ClientId(clientId);
        if(client == null){
            return null;
        }
        return clientResponseMapper.entityToResponseModel(client);
    }

    @Override
    public ClientResponseModel createClient(String storeId, ClientRequestModel clientRequestModel) {

        Client client = new Client(clientRequestModel.getFirstName(),clientRequestModel.getLastName(),
                clientRequestModel.getTotalBought(),
                clientRequestModel.getEmail(),clientRequestModel.getPhoneNumber());
        client.setClientIdentifier(new ClientIdentifier());
        client.setStoreIdentifier(new StoreIdentifier(storeId));
        return clientResponseMapper.entityToResponseModel(clientRepository.save(client));
    }

    @Override
    public ClientResponseModel updateClient(ClientRequestModel clientRequestModel, String clientId) {

        Client existingClient = clientRepository.findClientByClientIdentifier_ClientId(clientId);
        if(existingClient == null){
            return null;
        }
        Client client = new Client(clientRequestModel.getFirstName(),clientRequestModel.getLastName(),
                clientRequestModel.getTotalBought(),
                clientRequestModel.getEmail(),clientRequestModel.getPhoneNumber());
        client.setClientIdentifier(existingClient.getClientIdentifier());
        client.setId(existingClient.getId());

        if(clientRequestModel.getStoreIdentifier() == null) {
            client.setStoreIdentifier(existingClient.getStoreIdentifier());
        }
        else {
            //client.setStoreIdentifier(new StoreIdentifier(clientRequestModel.getStoreIdentifier()));
        }

        return clientResponseMapper.entityToResponseModel(clientRepository.save(client));
    }

    @Override
    public void deleteClient(String clientId) {
        Client client = clientRepository.findClientByClientIdentifier_ClientId(clientId);
        /*
        if(client == null)
            return;
        List<Tournament> tournaments = tournamentRepository.getTournamentsByPlayers(client.getClientIdentifier());
        if(tournaments == null)
            return;
        tournamentRepository.deleteAll();
*/
        clientRepository.delete(client);
    }


}
