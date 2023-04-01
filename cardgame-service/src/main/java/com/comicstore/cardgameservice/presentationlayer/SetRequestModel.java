package com.comicstore.cardgameservice.presentationlayer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SetRequestModel {
    private String cardId;

    private String name;

    private Date releaseDate;

    private int numberOfCards;
}
