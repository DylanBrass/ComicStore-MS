package com.comicstore.storeservice.presentationlayer.Inventory;

import com.comicstore.storeservice.businesslayer.Inventory.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lab1/v1/inventories")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
        public InventoryResponseModel createInventory(@RequestBody InventoryRequestModel inventoryRequestModel){
        return inventoryService.createInventory(inventoryRequestModel);
    }

    @PutMapping("/{inventoryId}")
    public  InventoryResponseModel updateInventory(@PathVariable String inventoryId, @RequestBody InventoryRequestModel inventoryRequestModel){
        return  inventoryService.updateInventory(inventoryId, inventoryRequestModel);
    }

    @GetMapping()
    public List<InventoryResponseModel> getInventories(){
        return inventoryService.getInventories();
    }
    @GetMapping("/{inventoryId}")
    public InventoryResponseModel getInventoryById(@PathVariable String inventoryId){
        return inventoryService.getInventoryById(inventoryId);
    }

}
