package com.comicstore.cardgameservice.businesslayer;

import com.comicstore.cardgameservice.datalayer.*;
import com.comicstore.cardgameservice.datamapperlayer.CardGameRequestMapper;
import com.comicstore.cardgameservice.datamapperlayer.CardGameResponseMapper;
import com.comicstore.cardgameservice.datamapperlayer.SetRequestMapper;
import com.comicstore.cardgameservice.datamapperlayer.SetResponseMapper;
import com.comicstore.cardgameservice.presentationlayer.CardGameRequestModel;
import com.comicstore.cardgameservice.presentationlayer.CardGameResponseModel;
import com.comicstore.cardgameservice.presentationlayer.SetRequestModel;
import com.comicstore.cardgameservice.presentationlayer.SetResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardGameServiceImpl implements CardGameService{
    private final CardGameRepository cardGameRepository;
    private final SetRepository setRepository;
    //private final TournamentRepository tournamentRepository;
    private final SetRequestMapper setRequestMapper;
    private final SetResponseMapper setResponseMapper;
    private final CardGameResponseMapper cardGameResponseMapper;
    private final CardGameRequestMapper cardGameRequestMapper;


    public CardGameServiceImpl(CardGameRepository cardGameRepository, SetRepository setRepository,/* TournamentRepository tournamentRepository,*/ SetRequestMapper setRequestMapper, SetResponseMapper setResponseMapper, CardGameResponseMapper cardGameResponseMapper, CardGameRequestMapper cardGameRequestMapper) {
        this.cardGameRepository = cardGameRepository;
        this.setRepository = setRepository;
        //this.tournamentRepository = tournamentRepository;
        this.setRequestMapper = setRequestMapper;
        this.setResponseMapper = setResponseMapper;
        this.cardGameResponseMapper = cardGameResponseMapper;
        this.cardGameRequestMapper = cardGameRequestMapper;
    }

    @Override
    public List<CardGameResponseModel> getCardGames() {
        return cardGameResponseMapper.entitiesToResponseModel(cardGameRepository.findAll());
    }

    @Override
    public SetResponseModel addCardGameSet(String cardGameId, SetRequestModel setRequestModel) {

        CardGame cardGame = cardGameRepository.getCardGameByCardIdentifier_CardId(cardGameId);

        if(cardGame == null){
         return null;
        }

        Set set = setRequestMapper.entityToResponseModel(setRequestModel, new CardIdentifier(setRequestModel.getCardId()));

        set.setCardIdentifier(cardGame.getCardIdentifier());

        return setResponseMapper.entityToResponseModel(setRepository.save(set));
    }

    @Override
    public List<SetResponseModel> getCardGameSets(String cardGameId) {
        List<Set> sets = setRepository.getSetByCardIdentifier_CardId(cardGameId);
        return setResponseMapper.entitiesToResponseModel(sets);
    }

    @Override
    public List<SetResponseModel> getAllSets() {
        return setResponseMapper.entitiesToResponseModel(setRepository.findAll());
    }

    @Override
    public void deleteCardGame(String cardId) {
        CardGame cardGame = cardGameRepository.getCardGameByCardIdentifier_CardId(cardId);

        if(cardGame == null)
            return;
        List<Set> sets = setRepository.getSetByCardIdentifier_CardId(cardId);
        if(sets == null)
            return;
        setRepository.deleteAll(sets);

        /*List<Tournament> tournaments = tournamentRepository.getTournamentsByCardGame_CardId(cardGame.getCardIdentifier().getCardId());
        if(tournaments == null)
            return;
        tournamentRepository.deleteAll(tournaments);

*/
        cardGameRepository.delete(cardGame);
    }

    @Override
    public CardGameResponseModel addCardGame(CardGameRequestModel cardGameRequestModel) {
        CardGame cardGame = cardGameRequestMapper.requestModelToEntity(cardGameRequestModel);

        return cardGameResponseMapper.entityToResponseModel(cardGameRepository.save(cardGame));
    }

    @Override
    public void deleteCardGameSet(String setId) {
        Set set = setRepository.getSetById(setId);
        if(set == null)
            return;
        setRepository.delete(set);
    }

    @Override
    public SetResponseModel updateCardGameSet(String setId, SetRequestModel setRequestModel) {
        Set existingSet =setRepository.getSetById(setId);

        if(existingSet == null){
            return null;
        }

        Set set = setRequestMapper.entityToResponseModel(setRequestModel, new CardIdentifier(setRequestModel.getCardId()));

        set.setId(existingSet.getId());
        set.setCardIdentifier(existingSet.getCardIdentifier());

        return setResponseMapper.entityToResponseModel(setRepository.save(set));    }
}
