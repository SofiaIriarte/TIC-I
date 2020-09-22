package com.example.ticproject.app.entitiesControllers;

import com.example.ticproject.app.entities.Client;
import com.example.ticproject.app.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;

@Service
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @Transactional
    public void createCustomer(String cI, String firstName, String lastName, Date birthday, String address, String userName, String passworld) {
        Client toInsert = new Client(cI,firstName,lastName,birthday,address,userName,passworld);
        clientRepository.save(toInsert);
    }

}
