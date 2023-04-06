package com.comicstore.storeservice.presentationlayer.Inventory;

import com.comicstore.storeservice.businesslayer.Inventory.InventoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lab2/v1/inventories")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{inventoryId}")
    public  InventoryResponseModel updateInventory(@PathVariable String inventoryId,@Valid @RequestBody InventoryRequestModel inventoryRequestModel){
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
