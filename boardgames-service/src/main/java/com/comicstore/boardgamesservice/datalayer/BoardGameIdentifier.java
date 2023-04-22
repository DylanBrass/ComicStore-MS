package com.comicstore.boardgamesservice.datalayer;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class BoardGameIdentifier {
    @Column(name = "board_game_id")
    private String boardGameId;

    public BoardGameIdentifier() {
        this.boardGameId = UUID.randomUUID().toString();
    }

    public BoardGameIdentifier(String boardGameId){
        this.boardGameId = boardGameId;
    }

    public String BoardGameIdentifier() {
        return this.boardGameId;
    }

    public void BoardGameIdentifier(String boardGameId) {
        this.boardGameId = boardGameId;
    }
}
