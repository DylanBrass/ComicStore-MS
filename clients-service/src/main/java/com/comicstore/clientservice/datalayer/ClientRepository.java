package com.comicstore.clientservice.datalayer;

import com.comicstore.clientservice.presentationlayer.ClientResponseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
List<Client> findByStoreIdentifier_StoreId(String storeId);

Client findClientByClientIdentifier_ClientId(String ClientId);

Boolean existsByLastName(String lastname);

Boolean existsByFirstName(String firstName);
Boolean existsByContact_Email(String email);

List<Client> findClientByStoreIdentifier_StoreId(String storeId);

}
