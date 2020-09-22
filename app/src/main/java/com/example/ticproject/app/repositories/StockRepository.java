package com.example.ticproject.app.repositories;

import com.example.ticproject.app.entities.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer> {

    Stock findByiD(int iD);


}