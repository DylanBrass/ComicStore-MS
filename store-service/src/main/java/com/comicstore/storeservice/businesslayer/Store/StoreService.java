package com.comicstore.storeservice.businesslayer.Store;

import com.comicstore.storeservice.presentationlayer.Inventory.InventoryResponseModel;
import com.comicstore.storeservice.presentationlayer.Store.StoreClientsResponseModel;
import com.comicstore.storeservice.presentationlayer.Store.StoreRequestModel;
import com.comicstore.storeservice.presentationlayer.Store.StoreResponseModel;

import java.util.List;

public interface StoreService {
    StoreClientsResponseModel getStoreClients(String storeId);
    List<StoreResponseModel> getStores();
    StoreResponseModel getStore(String storeId);
    StoreResponseModel createStore(StoreRequestModel storeRequestModel);
    List<InventoryResponseModel> getInventoryByStoreId(String storeId);
}
