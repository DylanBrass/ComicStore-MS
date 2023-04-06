package com.comicstore.cardgameservice.presentationlayer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Sql({"/data-mysql.sql"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CardGameControllerIntegrationTest {

    @Test
    void getCardGames() {
    }

    @Test
    void getCardGame() {
    }

    @Test
    void addSetToCardGame() {
    }

    @Test
    void getCardGameSets() {
    }

    @Test
    void testGetCardGameSets() {
    }

    @Test
    void deleteCardGame() {
    }

    @Test
    void addCardGame() {
    }

    @Test
    void deleteCardGameSet() {
    }

    @Test
    void updateSet() {
    }

    @Test
    void updateCardGame() {
    }
}