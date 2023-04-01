package com.comicstore.clientservice.presentationlayer;

import com.comicstore.clientservice.businesslayer.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lab1/v1/clients")
public class ClientController {

    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public List<ClientResponseModel> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/{clientId}")
    public ClientResponseModel getClientById(@PathVariable String clientId){
        return clientService.getClientById(clientId);
    }

    @PutMapping("/{clientId}")
    public ClientResponseModel updateClient(@PathVariable String clientId, @RequestBody ClientRequestModel clientRequestModel){
        return clientService.updateClient(clientRequestModel,clientId);
    }

    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable String clientId){
         clientService.deleteClient(clientId);
    }
}
