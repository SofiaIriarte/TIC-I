package com.example.ticproject.app.repositories;

import com.example.ticproject.app.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product findByiD(int iD);
    Product findByPrice(long price);


}