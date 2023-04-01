package com.comicstore.cardgameservice.datalayer;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "card_game_sets")
@Data
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private CardIdentifier cardIdentifier;
    private String name;

    private Date releaseDate;

    private int numberOfCards;
}
