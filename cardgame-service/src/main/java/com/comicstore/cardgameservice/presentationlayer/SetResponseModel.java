package com.comicstore.cardgameservice.presentationlayer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SetResponseModel {
    private Integer id;
    private String cardGame;

    private String name;

    private String releaseDate;

    private int numberOfCards;

}
