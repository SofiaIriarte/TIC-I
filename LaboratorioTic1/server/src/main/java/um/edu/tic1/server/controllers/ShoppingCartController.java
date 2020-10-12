package um.edu.tic1.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import um.edu.tic1.server.entities.ShoppingCart;
import um.edu.tic1.server.repositories.ShoppingCartRepository;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/shopcart")
public class ShoppingCartController {

    @Autowired
    ShoppingCartRepository sCRepository;

    @PostMapping("/saveCart")
    @Transactional
    public void createSC(@RequestBody ShoppingCart shoppingCart) {
        sCRepository.save(shoppingCart);
    }

}