package com.example.ticproject.app.server.repositories;

import com.example.ticproject.app.server.entities.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {

    Store findByiD(int iD);


}