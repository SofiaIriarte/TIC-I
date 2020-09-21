package com.example.ticproject.app.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
@RestController
@RequestMapping("/product")
@AllArgsConstructor
@Service
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public void createProduct(int iD, long price,String descriptcion, String name,String cathegory) {
        Product toInsert = new Product(iD,price,descriptcion,name,cathegory);
        productRepository.save(toInsert);
    }

    @PostMapping("/")
    public void create(@RequestBody Product product) {
        productRepository.save(product);
    }

}