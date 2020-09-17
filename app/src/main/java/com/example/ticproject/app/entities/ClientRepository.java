package com.example.ticproject.app.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    List<Client> findByLastName(String lastName);

    Client findBycI(int cI);

}
