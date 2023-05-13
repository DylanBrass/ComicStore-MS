package com.comicstore.apigateway.businesslayer.Client;


import com.comicstore.apigateway.domainclientlayer.Client.ClientServiceClient;
import com.comicstore.apigateway.presentationlayer.Client.ClientRequestModel;
import com.comicstore.apigateway.presentationlayer.Client.ClientResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClientsServiceImpl implements ClientsService{
    private ClientServiceClient clientServiceClient;

    public ClientsServiceImpl(ClientServiceClient clientServiceClient) {
        this.clientServiceClient = clientServiceClient;
    }


    @Override
    public ClientResponseModel getClientAggregateById(String clientId) {
        return clientServiceClient.getClientAggregateById(clientId);

    }

    @Override
    public ClientResponseModel createNewClient(ClientRequestModel clientRequestModel) {
        return clientServiceClient.createNewClient(clientRequestModel);
    }

    @Override
    public void updateClient(ClientRequestModel clientRequestModel, String clientId) {
         clientServiceClient.updateClient(clientRequestModel,clientId);
    }

    @Override
    public void deleteClient(String clientId) {
        clientServiceClient.deleteClient(clientId);
    }

    @Override
    public ClientResponseModel[] getAllClientsOfStore(String storeId) {
        return clientServiceClient.getAllClientFromStoreId(storeId);
    }
}
