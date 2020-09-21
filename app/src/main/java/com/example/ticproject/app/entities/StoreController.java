package com.example.ticproject.app.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.sql.Time;

@RestController
@RequestMapping("/store")
@AllArgsConstructor
@Service
public class StoreController {

    @Autowired
    StoreRepository storeRepository;

    @Transactional
    public void createStore(int iD, Time hours,String user, String address, String password) {
        Store toInsert = new Store(iD,hours,user,address,password);
        storeRepository.save(toInsert);
    }

    @PostMapping("/")
    public void create(@RequestBody Store store) {
        storeRepository.save(store);
    }

}