package com.comicstore.boardgamesservice.datalayer;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "clients")
@Data
public class BoardGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Embedded
    private BoardGameIdentifier boardGameIdentifier;
    @Embedded
    private InventoryIdentifier inventoryIdentifier;
    private String boardGameName;
    private String genre;
    private LocalDate releaseDate;
    private int maxNumOfPlayers;
    private int minNumOfPlayers;
    private double price;

}
