package com.comicstore.storeservice.businesslayer.Inventory;


import com.comicstore.storeservice.presentationlayer.Inventory.InventoryRequestModel;
import com.comicstore.storeservice.presentationlayer.Inventory.InventoryResponseModel;

import java.util.List;

public interface InventoryService {
     InventoryResponseModel createInventory(InventoryRequestModel inventoryRequestModel);
     InventoryResponseModel updateInventory(String inventoryId,InventoryRequestModel inventoryRequestModel);
     List<InventoryResponseModel> getInventories();
     InventoryResponseModel getInventoryById(String inventoryId);
}
