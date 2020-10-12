package com.example.ticproject.app.server.entitiesControllers;

import com.example.ticproject.app.server.entities.Client;
import com.example.ticproject.app.server.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/client")
@Service
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @PostMapping("/saveClient")
    @Transactional
    public void createCustomer(@RequestBody Client client) {
        clientRepository.save(client);
    }

}
