package com.comicstore.storeservice.businesslayer.Inventory;

import com.comicstore.storeservice.Utils.Exceptions.InvalidInputException;
import com.comicstore.storeservice.Utils.Exceptions.NotFoundException;
import com.comicstore.storeservice.datalayer.Inventory.Inventory;
import com.comicstore.storeservice.datalayer.Inventory.InventoryRepository;
import com.comicstore.storeservice.datalayer.Inventory.Type;
import com.comicstore.storeservice.datalayer.Store.Status;
import com.comicstore.storeservice.datalayer.Store.StoreIdentifier;
import com.comicstore.storeservice.datalayer.Store.StoreRepository;
import com.comicstore.storeservice.datamapperlayer.Inventory.InventoryRequestMapper;
import com.comicstore.storeservice.datamapperlayer.Inventory.InventoryResponseMapper;
import com.comicstore.storeservice.presentationlayer.Inventory.InventoryRequestModel;
import com.comicstore.storeservice.presentationlayer.Inventory.InventoryResponseModel;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.EnumUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    public InventoryResponseModel createInventory(String storeId,InventoryRequestModel inventoryRequestModel) {
        if (!findByType(inventoryRequestModel.getType())) {
            throw new InvalidInputException("Type entered is not a valid type : " + inventoryRequestModel.getType());
        }
        if (!findByStatus(inventoryRequestModel.getStatus())) {
            throw new InvalidInputException("Status entered is not a valid type : " + inventoryRequestModel.getStatus());
        }


        Inventory inventory = inventoryRequestMapper.requestModelToEntity(inventoryRequestModel, new StoreIdentifier(inventoryRequestModel.getStoreId()));
        inventory.setStoreIdentifier(new StoreIdentifier(storeId));
        inventory.setLastUpdated(LocalDate.now());


        if(!storeRepository.existsByStoreIdentifier_StoreId(inventoryRequestModel.getStoreId()))
            throw new NotFoundException("No Store with id : " + inventoryRequestModel.getStoreId() + " was found !");


        return inventoryResponseMapper.entityToResponseModel(inventoryRepository.save(inventory));
    }


    @Override
    public InventoryResponseModel updateInventory(String inventoryId, InventoryRequestModel inventoryRequestModel) {
        if (!findByType(inventoryRequestModel.getType())) {
            throw new InvalidInputException("Type entered is not a valid type : " + inventoryRequestModel.getType());
        }
        if (!findByStatus(inventoryRequestModel.getStatus())) {
            throw new InvalidInputException("Status entered is not a valid type : " + inventoryRequestModel.getStatus());
        }

        Inventory existingInventory = inventoryRepository.getInventoryByInventoryIdentifier_InventoryId(inventoryId);
        if(existingInventory == null)
            throw new NotFoundException("No Inventory with id : " + inventoryId + " was found !");



        Inventory inventory = inventoryRequestMapper.requestModelToEntity(inventoryRequestModel, new StoreIdentifier(inventoryRequestModel.getStoreId()));
        if(inventoryRequestModel.getStoreId() == null) {
            inventory.setStoreIdentifier(existingInventory.getStoreIdentifier());
        }
        else {
            inventory.setStoreIdentifier(new StoreIdentifier(inventoryRequestModel.getStoreId()));
        }
        inventory.setLastUpdated(LocalDate.now());



        inventory.setId(existingInventory.getId());
        return inventoryResponseMapper.entityToResponseModel(inventoryRepository.save(inventory));
    }

    @Override
    public List<InventoryResponseModel> getInventories() {

        return inventoryResponseMapper.entitiesToResponseModel(inventoryRepository.findAll());
    }

    @Override
    public InventoryResponseModel getInventoryById(String inventoryId) {
        if(!inventoryRepository.existsByInventoryIdentifier_InventoryId(inventoryId))
            throw new NotFoundException("No Inventory with id : " + inventoryId + " was found !");

        return inventoryResponseMapper.entityToResponseModel(inventoryRepository.getInventoryByInventoryIdentifier_InventoryId(inventoryId));
    }



    public static Boolean findByType(String typeStr) {
        boolean found = false;
        for (Type type : Type.values()) {
            if (type.name().equalsIgnoreCase(typeStr)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static Boolean findByStatus(String statusStr) {
        boolean found = false;
        for (Status status : Status.values()) {
            if (status.name().equalsIgnoreCase(statusStr)) {
                found = true;
                break;
            }
        }
        return found;
    }
}
