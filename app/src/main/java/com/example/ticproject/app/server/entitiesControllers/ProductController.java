package com.example.ticproject.app.server.entitiesControllers;

import com.example.ticproject.app.server.entities.Product;
import com.example.ticproject.app.server.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public void createProduct(int iD, long price,String descriptcion, String name,String cathegory) {
        Product toInsert = new Product(iD,price,descriptcion,name,cathegory);
        productRepository.save(toInsert);
    }

}