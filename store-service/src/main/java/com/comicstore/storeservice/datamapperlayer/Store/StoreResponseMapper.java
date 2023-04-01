package com.comicstore.storeservice.datamapperlayer.Store;

import com.comicstore.storeservice.datalayer.Store.Store;
import com.comicstore.storeservice.presentationlayer.Store.StoreResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreResponseMapper {
    @Mapping(expression = "java(store.getStoreIdentifier().getStoreId())",  target = "storeId")
    @Mapping(expression = "java(store.getDateOpened())",  target = "dateOpened")
    @Mapping(expression = "java(store.getAddress().getStreetAddress())", target = "streetAddress" )
    @Mapping(expression = "java(store.getAddress().getCity())", target = "city" )
    @Mapping(expression = "java(store.getAddress().getProvince())", target = "province" )
    @Mapping(expression = "java(store.getAddress().getPostalCode())", target = "postalCode" )
    @Mapping(expression = "java(store.getContact().getEmail())", target = "email" )
    @Mapping(expression = "java(store.getContact().getPhoneNumber())", target = "phoneNumber" )
    StoreResponseModel entityToResponseModel(Store store);



    List<StoreResponseModel> entitiesToResponseModel(List<Store> stores);


}
