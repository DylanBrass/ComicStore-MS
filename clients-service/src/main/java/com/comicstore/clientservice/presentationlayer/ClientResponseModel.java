package com.comicstore.clientservice.presentationlayer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientResponseModel {
    private String storeId;
    private String clientId;
    private String firstName;
    private String lastName;
    private int rebate;
    private double totalBought;

    private String email;
    private String phoneNumber;
}
