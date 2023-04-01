package com.comicstore.clientservice.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
List<Client> findByStoreIdentifier_StoreId(String storeId);

Client findClientByClientIdentifier_ClientId(String ClientId);
}
