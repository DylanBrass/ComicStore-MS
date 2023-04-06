package com.comicstore.clientservice.presentationlayer;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
public class ClientResponseModel extends RepresentationModel<ClientResponseModel> {
    private String storeId;
    private String clientId;
    private String firstName;
    private String lastName;
    private int rebate;
    private double totalBought;

    private String email;
    private String phoneNumber;
}
