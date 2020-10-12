package com.example.ticproject.app.server.entitiesControllers;

import com.example.ticproject.app.server.entities.Stock;
import com.example.ticproject.app.server.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @Transactional
    public void createStock(int productoId, int storeId,String talle, int quantity) {
        Stock toInsert = new Stock(productoId,storeId,talle,quantity);
        stockRepository.save(toInsert);
    }

}