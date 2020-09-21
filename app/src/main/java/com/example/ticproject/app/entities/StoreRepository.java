package com.example.ticproject.app.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {

    Store findByiD(int iD);


}