package com.comicstore.cardgameservice.datalayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SetPersistenceTest {
    @Autowired
    private SetRepository setRepository;

    private Set presavedSet;


    @BeforeEach
    public void setup(){
        setRepository.deleteAll();
        presavedSet = setRepository.save(
                new Set());
       }
    @Test
    void getSetByCardIdentifier_CardId() {
    }

    @Test
    void getSetBySetIdentifier_SetId() {
    }
}