package com.comicstore.storeservice.datamapperlayer.Inventory;

import com.comicstore.storeservice.datalayer.Inventory.Inventory;
import com.comicstore.storeservice.presentationlayer.Inventory.InventoryController;
import com.comicstore.storeservice.presentationlayer.Inventory.InventoryResponseModel;
import com.comicstore.storeservice.presentationlayer.Store.StoreController;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface InventoryResponseMapper {
    @Mapping(expression = "java(inventory.getStoreIdentifier().getStoreId())",  target = "storeId")
    @Mapping(expression = "java(inventory.getInventoryIdentifier().getInventoryId())",  target = "inventoryId")
    InventoryResponseModel entityToResponseModel(Inventory inventory);

    @Mapping(expression = "java(inventory.getStoreIdentifier().getStoreId())",  target = "storeId")
    @Mapping(expression = "java(inventory.getInventoryIdentifier().getInventoryId())",  target = "inventoryId")
    List<InventoryResponseModel> entitiesToResponseModel(List<Inventory> inventories);



    @AfterMapping
    default void addLinks(@MappingTarget InventoryResponseModel model, Inventory inventory){
        Link selfLink = linkTo(methodOn(InventoryController.class)
                .getInventoryById(model.getInventoryId()))
                .withSelfRel();

        model.add(selfLink);

        Link inventoriesLink = linkTo(methodOn(InventoryController.class)
                .getInventories())
                .withRel("Inventories");

        model.add(inventoriesLink);


        Link storesLink = linkTo(methodOn(StoreController.class)
                .getStores())
                .withRel("Stores");

        model.add(storesLink);


        Link storeLink = linkTo(methodOn(StoreController.class)
                .getStore(model.getStoreId()))
                .withRel("Inventory Store");

        model.add(storeLink);

    }
}
