package com.comicstore.cardgameservice.presentationlayer;

import com.comicstore.cardgameservice.Utils.Exceptions.InvalidInputException;
import com.comicstore.cardgameservice.businesslayer.CardGameService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/lab2/v1/cardgames")
public class CardGameController {

    private final CardGameService cardGameService;


    public CardGameController(CardGameService cardGameService) {
        this.cardGameService = cardGameService;
    }

    @GetMapping()
    public ResponseEntity<List<CardGameResponseModel>> getCardGames(){
        return ResponseEntity.status(HttpStatus.OK).body(cardGameService.getCardGames());
    }


    @GetMapping("/{cardGameId}")
    public ResponseEntity<CardGameResponseModel> getCardGame(@PathVariable String cardGameId){
        return ResponseEntity.status(HttpStatus.OK).body(cardGameService.getCardGame(cardGameId));
    }

    @PostMapping("/{cardGameId}/sets")
    public ResponseEntity<SetResponseModel> addSetToCardGame(@PathVariable String cardGameId,@Valid @RequestBody SetRequestModel setRequestModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(cardGameService.addCardGameSet(cardGameId,setRequestModel));
    }

    @GetMapping("/{cardGameId}/sets")
    public ResponseEntity<List<SetResponseModel>> getCardGameSets(@PathVariable String cardGameId){
        return  ResponseEntity.status(HttpStatus.OK).body(cardGameService.getCardGameSets(cardGameId));
    }

//
    @GetMapping("/sets")
    public ResponseEntity<List<SetResponseModel>> getSets(){

        return ResponseEntity.status(HttpStatus.OK).body(cardGameService.getAllSets());
    }

    //
    @DeleteMapping("/{cardGameId}")
    public ResponseEntity<Void> deleteCardGame(@PathVariable String cardGameId){
        cardGameService.deleteCardGame(cardGameId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //
    @PostMapping()
    public ResponseEntity<CardGameResponseModel> addCardGame(@Valid @RequestBody CardGameRequestModel cardGameRequestModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(cardGameService.addCardGame(cardGameRequestModel));
    }
//
    @DeleteMapping("/sets/{setId}")
    ResponseEntity<Void> deleteCardGameSet(@PathVariable String setId){
        cardGameService.deleteCardGameSet(setId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
//
    @PutMapping("/sets/{setId}")
    ResponseEntity<SetResponseModel> updateSet(@Valid @RequestBody SetRequestModel setRequestModel,@PathVariable String setId){

        return ResponseEntity.status(HttpStatus.OK).body(cardGameService.updateCardGameSet(setId,setRequestModel));
    }


    @PutMapping("/{cardId}")
    ResponseEntity<CardGameResponseModel> updateCardGame(@PathVariable String cardId, @Valid @RequestBody CardGameRequestModel cardGameRequestModel){

        return ResponseEntity.status(HttpStatus.OK).body(cardGameService.updateCardGame(cardId,cardGameRequestModel));
    }
}

