package com.comicstore.storeservice.presentationlayer.Store;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.Date;
import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StoreClientsResponseModel {
    private String storeId;
    private Date dateOpened;
    private String streetAddress;
    private String city;
    private String province;
    private String postalCode;
    //private List<ClientResponseModel> clientsOfStore;
}
