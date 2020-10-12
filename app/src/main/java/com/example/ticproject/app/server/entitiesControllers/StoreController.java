package com.example.ticproject.app.server.entitiesControllers;

import com.example.ticproject.app.server.entities.Store;
import com.example.ticproject.app.server.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.sql.Time;

@Service
public class StoreController {

    @Autowired
    StoreRepository storeRepository;

    @Transactional
    public void createStore(int iD, Time hours,String user, String address, String password) {
        Store toInsert = new Store(iD,hours,user,address,password);
        storeRepository.save(toInsert);
    }

}