package com.comicstore.clientservice.presentationlayer;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientRequestModel {

    private String storeIdentifier;
    @NotBlank(message = "First name must no be left empty !")
    private String firstName;
    private String lastName;

    private double totalBought;
    private String email;
    private String phoneNumber;
}
