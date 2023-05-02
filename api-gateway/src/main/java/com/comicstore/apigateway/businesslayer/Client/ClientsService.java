package com.comicstore.apigateway.businesslayer.Client;

import com.comicstore.apigateway.presentationlayer.Client.ClientResponseModel;

public interface ClientsService {
    ClientResponseModel getClientAggregateById(String clientId);
}
