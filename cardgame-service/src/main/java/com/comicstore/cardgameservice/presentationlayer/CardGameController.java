package com.comicstore.cardgameservice.presentationlayer;

import com.comicstore.cardgameservice.businesslayer.CardGameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lab1/v1/cardgames")
public class CardGameController {

    private final CardGameService cardGameService;

    public CardGameController(CardGameService cardGameService) {
        this.cardGameService = cardGameService;
    }

    @GetMapping()
    public List<CardGameResponseModel> getCardGames(){
        return cardGameService.getCardGames();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{cardGameId}/sets")
    public SetResponseModel addSetToCardGame(@PathVariable String cardGameId, @RequestBody SetRequestModel setRequestModel){
        return cardGameService.addCardGameSet(cardGameId,setRequestModel);
    }

    @GetMapping("/{cardGameId}/sets")
    public List<SetResponseModel> getCardGameSets(@PathVariable String cardGameId){
        return cardGameService.getCardGameSets(cardGameId);
    }


    @GetMapping("/sets")
    public List<SetResponseModel> getCardGameSets(){
        return cardGameService.getAllSets();
    }

    @DeleteMapping("/{cardGameId}")
    public void deleteCardGame(@PathVariable String cardGameId){
        cardGameService.deleteCardGame(cardGameId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public CardGameResponseModel addCardGame(@RequestBody CardGameRequestModel cardGameRequestModel){
        return cardGameService.addCardGame(cardGameRequestModel);
    }

    @DeleteMapping("/sets/{setId}")
    void deleteCardGameSet(@PathVariable String setId){
        cardGameService.deleteCardGameSet(setId);
    }

    @PutMapping("/sets/{setId}")
    SetResponseModel updateSet(@RequestBody SetRequestModel setRequestModel,@PathVariable String setId){
        return cardGameService.updateCardGameSet(setId,setRequestModel) ;
    }
}

