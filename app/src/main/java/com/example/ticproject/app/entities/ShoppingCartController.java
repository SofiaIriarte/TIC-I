package com.example.ticproject.app.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/cartS")
@AllArgsConstructor
@Service
public class ShoppingCartController {

    @Autowired
    ShoppingCartRepository sCRepository;

    @Transactional
    public void createSC(int iD, long precio) {
        ShoppingCart toInsert = new ShoppingCart(iD,precio);
        sCRepository.save(toInsert);
    }

    @PostMapping("/")
    public void create(@RequestBody ShoppingCart cartS) {
        sCRepository.save(cartS);
    }

}

