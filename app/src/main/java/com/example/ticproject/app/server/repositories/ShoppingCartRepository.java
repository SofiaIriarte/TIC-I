package com.example.ticproject.app.server.repositories;

import com.example.ticproject.app.server.entities.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Integer> {

    ShoppingCart findByiD(int iD);

}
