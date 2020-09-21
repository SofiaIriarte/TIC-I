package com.example.ticproject.app.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product findByiD(int iD);
    Product findByPrice(long price);


}