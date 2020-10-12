package um.edu.tic1.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import um.edu.tic1.server.entities.Stock;
import um.edu.tic1.server.repositories.StockRepository;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @PostMapping("/savestock")
    @Transactional
    public void createCustomer(@RequestBody Stock stock) {
        stockRepository.save(stock);
    }
}
