package com.comicstore.storeservice.datalayer.Inventory;

import com.comicstore.storeservice.datalayer.Store.StoreIdentifier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;


@Entity
@Table(name = "inventories")
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private InventoryIdentifier inventoryIdentifier;

    @NotNull
    @Embedded
    private StoreIdentifier storeIdentifier;

    private Date lastUpdated;
    @Enumerated(EnumType.STRING)
    private Type type;


    public Inventory() {
        this.inventoryIdentifier = new InventoryIdentifier();
    }

    public Inventory(StoreIdentifier storeIdentifier, Date lastUpdated) {
        this.storeIdentifier = storeIdentifier;
        this.lastUpdated = lastUpdated;
    }
}
