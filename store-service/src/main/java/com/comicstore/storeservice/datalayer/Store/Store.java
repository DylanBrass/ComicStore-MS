package com.comicstore.storeservice.datalayer.Store;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "stores")
@Data
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Embedded
    private StoreIdentifier storeIdentifier;
    private Date dateOpened;
    @Embedded
    private Address address;

    @Embedded
    private ContactStore contact;

    public Store() {
    this.storeIdentifier = new StoreIdentifier();
    }

    public Store(Date dateOpened,  Address address) {
        this.storeIdentifier = new StoreIdentifier();
        this.dateOpened = dateOpened;
        this.address = address;
    }
}
