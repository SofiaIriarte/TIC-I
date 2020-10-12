package com.example.ticproject.app.server.repositories;

import com.example.ticproject.app.server.entities.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer> {

}