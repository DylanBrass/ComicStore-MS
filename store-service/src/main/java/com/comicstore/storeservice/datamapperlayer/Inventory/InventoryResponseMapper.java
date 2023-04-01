package com.comicstore.storeservice.datamapperlayer.Inventory;

import com.comicstore.storeservice.datalayer.Inventory.Inventory;
import com.comicstore.storeservice.presentationlayer.Inventory.InventoryResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InventoryResponseMapper {
    @Mapping(expression = "java(inventory.getStoreIdentifier().getStoreId())",  target = "storeId")
    @Mapping(expression = "java(inventory.getInventoryIdentifier().getInventoryId())",  target = "inventoryId")
    InventoryResponseModel entityToResponseModel(Inventory inventory);

    @Mapping(expression = "java(inventory.getStoreIdentifier().getStoreId())",  target = "storeId")
    @Mapping(expression = "java(inventory.getInventoryIdentifier().getInventoryId())",  target = "inventoryId")
    List<InventoryResponseModel> entitiesToResponseModel(List<Inventory> inventories);
}
