package com.comicstore.clientservice.presentationlayer;

import com.comicstore.clientservice.Utils.Exceptions.InvalidInputException;
import com.comicstore.clientservice.businesslayer.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/lab2/v1/stores")
public class ClientController {


    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{storeId}/clients")
    public ResponseEntity<List<ClientResponseModel>> getStoreClients(@PathVariable String storeId){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getStoreClients(storeId));
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientResponseModel>> getClients() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getClients());
    }

    @GetMapping("/clients/{clientId}")
    public ResponseEntity<ClientResponseModel> getClientById(@PathVariable String clientId) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getClientById(clientId));
    }

    @PutMapping("/clients/{clientId}")
    public ResponseEntity<ClientResponseModel> updateClient(@PathVariable String clientId,@Valid @RequestBody ClientRequestModel clientRequestModel) {


        return ResponseEntity.status(HttpStatus.OK).body(clientService.updateClient(clientRequestModel, clientId));
    }

    @PostMapping("/clients")
    public ResponseEntity<ClientResponseModel> createClient(@Valid @RequestBody ClientRequestModel clientRequestModel) {


        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(clientRequestModel));
    }



    @DeleteMapping("/clients/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable String clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
