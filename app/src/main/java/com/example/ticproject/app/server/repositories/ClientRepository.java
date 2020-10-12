package com.example.ticproject.app.server.repositories;

import com.example.ticproject.app.server.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    List<Client> findByLastName(String lastName);

    Client findBycI(int cI);

}
