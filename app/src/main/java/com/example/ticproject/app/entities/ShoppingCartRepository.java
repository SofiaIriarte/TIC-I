package com.example.ticproject.app.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Integer> {

    ShoppingCart findByiD(int iD);

}
