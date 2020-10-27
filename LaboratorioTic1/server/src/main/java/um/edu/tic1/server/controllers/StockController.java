package um.edu.tic1.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import um.edu.tic1.server.dtos.StockDTO;
import um.edu.tic1.server.entities.Stock;
import um.edu.tic1.server.repositories.StockRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/getStocks/{productId}")
    @Transactional
    public List<StockDTO> getStocks (@PathVariable("productId") int productId) {
        return stockRepository.findAllByProductId(productId).stream().map(Stock::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/getStock/{id}")
    @Transactional
    public StockDTO getStock (@PathVariable("id") String id) {
        if (stockRepository.existsById(id)){
            Stock stock = stockRepository.findById(id).get();
            return stock.toDTO();
        }
        return null;
    }

}
