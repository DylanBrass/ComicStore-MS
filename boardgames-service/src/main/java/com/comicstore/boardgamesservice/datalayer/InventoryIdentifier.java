package com.comicstore.boardgamesservice.datalayer;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;


@Embeddable
public class InventoryIdentifier {
    @Column(name = "inventory_id")
    private String inventoryId;

    public InventoryIdentifier() {
        this.inventoryId = UUID.randomUUID().toString();
    }



    public String getInventoryId() {
        return this.inventoryId;
    }

}
