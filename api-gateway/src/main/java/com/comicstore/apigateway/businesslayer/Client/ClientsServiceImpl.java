package com.comicstore.apigateway.businesslayer.Client;


import com.comicstore.apigateway.domainclientlayer.Client.ClientServiceClient;
import com.comicstore.apigateway.presentationlayer.Client.ClientResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
