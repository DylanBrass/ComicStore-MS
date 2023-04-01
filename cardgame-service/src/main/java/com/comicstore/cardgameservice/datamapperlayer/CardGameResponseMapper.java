package com.comicstore.cardgameservice.datamapperlayer;

import com.comicstore.cardgameservice.datalayer.CardGame;
import com.comicstore.cardgameservice.presentationlayer.CardGameResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CardGameResponseMapper {
    @Mapping(expression="java(cardGame.getCardIdentifier().getCardId())", target = "cardId")
    CardGameResponseModel entityToResponseModel(CardGame cardGame);

    List<CardGameResponseModel> entitiesToResponseModel(List<CardGame> cardGames);

}
