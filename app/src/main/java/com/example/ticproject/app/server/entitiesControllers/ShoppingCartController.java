package com.example.ticproject.app.server.entitiesControllers;

import com.example.ticproject.app.server.entities.ShoppingCart;
import com.example.ticproject.app.server.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;

@Service
public class ShoppingCartController {

    @Autowired
    ShoppingCartRepository sCRepository;

    @Transactional
    public void createSC(int iD, long precio) {
        ShoppingCart toInsert = new ShoppingCart(iD,precio);
        sCRepository.save(toInsert);
    }

}

