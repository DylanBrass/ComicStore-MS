package com.comicstore.cardgameservice.datamapperlayer;

import com.comicstore.cardgameservice.datalayer.Set;
import com.comicstore.cardgameservice.presentationlayer.SetResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SetResponseMapper {


    List<SetResponseModel> entitiesToResponseModel(List<Set> sets);

    @Mapping(expression="java(set.getCardIdentifier().getCardId())", target = "cardGame")
    SetResponseModel entityToResponseModel(Set set);
}
