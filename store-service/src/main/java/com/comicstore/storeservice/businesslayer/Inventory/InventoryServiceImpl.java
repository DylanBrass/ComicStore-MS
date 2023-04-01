package com.comicstore.storeservice.businesslayer.Inventory;

import com.comicstore.storeservice.datalayer.Inventory.Inventory;
import com.comicstore.storeservice.datalayer.Inventory.InventoryRepository;
import com.comicstore.storeservice.datalayer.Inventory.Type;
import com.comicstore.storeservice.datalayer.Store.StoreIdentifier;
import com.comicstore.storeservice.datalayer.Store.StoreRepository;
import com.comicstore.storeservice.datamapperlayer.Inventory.InventoryRequestMapper;
import com.comicstore.storeservice.datamapperlayer.Inventory.InventoryResponseMapper;
import com.comicstore.storeservice.presentationlayer.Inventory.InventoryRequestModel;
import com.comicstore.storeservice.presentationlayer.Inventory.InventoryResponseModel;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class InventoryServiceImpl implements InventoryService{
    InventoryRepository inventoryRepository;

    StoreRepository storeRepository;
    InventoryResponseMapper inventoryResponseMapper;

    InventoryRequestMapper inventoryRequestMapper;


    public InventoryServiceImpl(InventoryRepository inventoryRepository, StoreRepository storeRepository, InventoryResponseMapper inventoryResponseMapper, InventoryRequestMapper inventoryRequestMapper) {
        this.inventoryRepository = inventoryRepository;
        this.storeRepository = storeRepository;
        this.inventoryResponseMapper = inventoryResponseMapper;
        this.inventoryRequestMapper = inventoryRequestMapper;
    }

    @Override
    public InventoryResponseModel createInventory(InventoryRequestModel inventoryRequestModel) {
        Inventory inventory = inventoryRequestMapper.requestModelToEntity(inventoryRequestModel, new StoreIdentifier(inventoryRequestModel.getStoreId()));
        inventory.setStoreIdentifier(new StoreIdentifier(inventoryRequestModel.getStoreId()));
        inventory.setLastUpdated(new Date());
        inventory.setType(Type.valueOf(inventoryRequestModel.getType().toUpperCase()));

        if(!storeRepository.existsByStoreIdentifier_StoreId(inventoryRequestModel.getStoreId()))
            return null;


        return inventoryResponseMapper.entityToResponseModel(inventoryRepository.save(inventory));
    }


    @Override
    public InventoryResponseModel updateInventory(String inventoryId, InventoryRequestModel inventoryRequestModel) {
        Inventory existingInventory = inventoryRepository.getInventoryByInventoryIdentifier_InventoryId(inventoryId);
        if(existingInventory == null)
            return null;



        Inventory inventory = inventoryRequestMapper.requestModelToEntity(inventoryRequestModel, new StoreIdentifier(inventoryRequestModel.getStoreId()));
        if(inventoryRequestModel.getStoreId() == null) {
            inventory.setInventoryIdentifier(existingInventory.getInventoryIdentifier());
        }
        else {
            inventory.setStoreIdentifier(new StoreIdentifier(inventoryRequestModel.getStoreId()));
        }
        inventory.setLastUpdated(new Date());
        inventory.setType(Type.valueOf(inventoryRequestModel.getType().toUpperCase()));
        inventory.setId(existingInventory.getId());
        return inventoryResponseMapper.entityToResponseModel(inventoryRepository.save(inventory));
    }

    @Override
    public List<InventoryResponseModel> getInventories() {

        return inventoryResponseMapper.entitiesToResponseModel(inventoryRepository.findAll());
    }

    @Override
    public InventoryResponseModel getInventoryById(String inventoryId) {
        return inventoryResponseMapper.entityToResponseModel(inventoryRepository.getInventoryByInventoryIdentifier_InventoryId(inventoryId));
    }
}
