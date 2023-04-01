package com.comicstore.storeservice.businesslayer.Store;

import com.comicstore.storeservice.datalayer.Inventory.InventoryRepository;
import com.comicstore.storeservice.datalayer.Store.Address;
import com.comicstore.storeservice.datalayer.Store.ContactStore;
import com.comicstore.storeservice.datalayer.Store.Store;
import com.comicstore.storeservice.datalayer.Store.StoreRepository;
import com.comicstore.storeservice.datamapperlayer.Inventory.InventoryResponseMapper;
import com.comicstore.storeservice.datamapperlayer.Store.StoreClientsResponseMapper;
import com.comicstore.storeservice.datamapperlayer.Store.StoreRequestMapper;
import com.comicstore.storeservice.datamapperlayer.Store.StoreResponseMapper;
import com.comicstore.storeservice.presentationlayer.Inventory.InventoryResponseModel;
import com.comicstore.storeservice.presentationlayer.Store.StoreClientsResponseModel;
import com.comicstore.storeservice.presentationlayer.Store.StoreRequestModel;
import com.comicstore.storeservice.presentationlayer.Store.StoreResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StoreServiceImpl implements StoreService {
    //Repositories
    StoreRepository storeRepository;
    //ClientRepository clientRepository;
    InventoryRepository inventoryRepository;


    //Mappers
    //ClientResponseMapper clientResponseMapper;
    StoreClientsResponseMapper storeClientsResponseMapper;
    StoreResponseMapper storeResponseMapper;
    InventoryResponseMapper inventoryResponseMapper;
    StoreRequestMapper storeRequestMapper;

    public StoreServiceImpl(StoreRepository storeRepository,/* ClientRepository clientRepository, */InventoryRepository inventoryRepository, /*ClientResponseMapper clientResponseMapper,*/ StoreClientsResponseMapper storeClientsResponseMapper, StoreResponseMapper storeResponseMapper, InventoryResponseMapper inventoryResponseMapper, StoreRequestMapper storeRequestMapper) {
        this.storeRepository = storeRepository;
        //this.clientRepository = clientRepository;
        this.inventoryRepository = inventoryRepository;
        //this.clientResponseMapper = clientResponseMapper;
        this.storeClientsResponseMapper = storeClientsResponseMapper;
        this.storeResponseMapper = storeResponseMapper;
        this.inventoryResponseMapper = inventoryResponseMapper;
        this.storeRequestMapper = storeRequestMapper;
    }

    @Override
    public StoreClientsResponseModel getStoreClients(String storeId) {
        /*Store store = storeRepository.findByStoreIdentifier_StoreId(storeId);
        if(store == null){
            return null;
        }
        List<ClientResponseModel> clients = clientResponseMapper.entityListToResponseModelList(clientRepository.findByStoreIdentifier_StoreId(storeId));
        return storeClientsResponseMapper.entitiesToResponseModel(store, clients);
    */
        return null;

    }





    @Override
    public List<StoreResponseModel> getStores() {
        return storeResponseMapper.entitiesToResponseModel(storeRepository.findAll());
    }

    @Override
    public StoreResponseModel getStore(String storeId) {
        Store store = storeRepository.findByStoreIdentifier_StoreId(storeId);
        if(store == null){
           return null;
        }
        return storeResponseMapper.entityToResponseModel(store);
    }
    @Override
    public StoreResponseModel createStore(StoreRequestModel storeRequestModel) {
        Store store = storeRequestMapper.requestModelToEntity(storeRequestModel);
        store.setAddress(new Address(storeRequestModel.getStreetAddress(),storeRequestModel.getCity(),storeRequestModel.getProvince(),storeRequestModel.getPostalCode()));

        store.setContact(new ContactStore(storeRequestModel.getEmail(),storeRequestModel.getPhoneNumber()));

        return storeResponseMapper.entityToResponseModel(storeRepository.save(store));
    }

    @Override
    public List<InventoryResponseModel> getInventoryByStoreId(String storeId) {
        return inventoryResponseMapper.entitiesToResponseModel(inventoryRepository.getInventoriesByStoreIdentifier_StoreId(storeId));
    }
}
