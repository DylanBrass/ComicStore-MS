package com.comicstore.cardgameservice.presentationlayer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CardGameResponseModel {
    private String cardId;

    private String cardGameName;

    private String company;

    private Date releaseDate;

    private Boolean isActive;

}
