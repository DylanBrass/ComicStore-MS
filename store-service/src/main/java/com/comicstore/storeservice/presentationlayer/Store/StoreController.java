package com.comicstore.storeservice.presentationlayer.Store;

import com.comicstore.storeservice.businesslayer.Store.StoreService;
import com.comicstore.storeservice.presentationlayer.Inventory.InventoryResponseModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lab1/v1/stores")
public class StoreController {
    StoreService storeService;

    //ClientService clientService;

    public StoreController(StoreService storeService/*, ClientService clientService*/) {
        this.storeService = storeService;
        //this.clientService = clientService;
    }

    @GetMapping("/{storeId}/clients")
    public StoreClientsResponseModel getStoreClients(@PathVariable String storeId){
        return storeService.getStoreClients(storeId);
    }

    @GetMapping()
    public List<StoreResponseModel> getStores(){
        return storeService.getStores();
    }

    @GetMapping("/{storeId}")
    public StoreResponseModel getStore(@PathVariable String storeId){
        return storeService.getStore(storeId);
    }

   /* @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{storeId}/clients")
    public ClientResponseModel createClient(@PathVariable String storeId, @RequestBody ClientRequestModel clientRequestModel){
        return clientService.createClient(storeId,clientRequestModel);
    }
    */


    @PostMapping()
    public StoreResponseModel createStore(@RequestBody StoreRequestModel storeRequestModel){
        return storeService.createStore(storeRequestModel);
    }

    @GetMapping("/{storeId}/inventories")
    public List<InventoryResponseModel> getInventoriesByStoreId(@PathVariable String storeId){
        return storeService.getInventoryByStoreId(storeId);
    }

}
