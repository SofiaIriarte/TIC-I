package com.example.ticproject.app.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
@RestController
@RequestMapping("/stock")
@AllArgsConstructor
@Service
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @Transactional
    public void createStock(int iD, int quantity) {
        Stock toInsert = new Stock(iD,quantity);
        stockRepository.save(toInsert);
    }

    @PostMapping("/")
    public void create(@RequestBody Stock stock) {
        stockRepository.save(stock);
    }

}