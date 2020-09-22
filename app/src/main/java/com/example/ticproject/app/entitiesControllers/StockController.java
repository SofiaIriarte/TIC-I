package com.example.ticproject.app.entitiesControllers;

import com.example.ticproject.app.entities.Stock;
import com.example.ticproject.app.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @Transactional
    public void createStock(int iD, int quantity) {
        Stock toInsert = new Stock(iD,quantity);
        stockRepository.save(toInsert);
    }

}