package com.comicstore.storeservice.presentationlayer.Inventory;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.sql.Date;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class InventoryResponseModel {
    private String inventoryId;

    private String storeId;

    private Date lastUpdated;

    private String type;
}
