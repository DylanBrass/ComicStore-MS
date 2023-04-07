package com.comicstore.cardgameservice.presentationlayer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Sql({"/data-mysql.sql"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CardGameControllerIntegrationTest {
    private final String BASE_URI_CARDGAMES = "/api/lab2/v1/cardgames";
    private final String VALID_CARDGAME_ID = "6dfc9e76-1aa7-4786-8398-f4ae25737324";
    private final String VALID_CARDGAME_NAME = "Magic The Gathering";
    private final String VALID_CARDGAME_COMPANY = "Wizards of the Coast";
    private final String VALID_CARDGAME_RELEASEDATE = "2022-08-01";
    private final Boolean VALID_CARDGAME_ISACTIVE = true;



    @Autowired
    WebTestClient webTestClient;

    @Test
    void getCardGames() {
        Integer expectedNumCardGames = 4;
        webTestClient.get()
                .uri(BASE_URI_CARDGAMES)
                .accept(MediaType.APPLICATION_JSON)
                .exchange().expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().jsonPath("$.length()").isEqualTo(expectedNumCardGames);
    }

    @Test
    void getCardGame() {


            webTestClient.get()
                    .uri(BASE_URI_CARDGAMES + "/" + VALID_CARDGAME_ID)
                    .accept(MediaType.APPLICATION_JSON)
                    .exchange().expectStatus().isOk()
                    .expectHeader().contentType(MediaType.APPLICATION_JSON)
                    .expectBody(CardGameResponseModel.class)
                    .value((dto)->{
                        assertEquals(dto.getCardId(),VALID_CARDGAME_ID);
                        assertEquals(dto.getCompany(),VALID_CARDGAME_COMPANY);
                        assertEquals(dto.getCardGameName(),VALID_CARDGAME_NAME);
                        assertEquals(dto.getIsActive(),VALID_CARDGAME_ISACTIVE);
                        assertEquals(dto.getReleaseDate(),LocalDate.parse(VALID_CARDGAME_RELEASEDATE));
                    });
        }




}