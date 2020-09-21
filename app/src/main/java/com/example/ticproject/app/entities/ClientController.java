package com.example.ticproject.app.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
@RestController
@RequestMapping("/clients")
@AllArgsConstructor
@Service
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @Transactional
    public void createCustomer(String cI, String firstName, String lastName, String address, String userName, String passworld) {
        Client toInsert = new Client(cI,firstName,lastName,address,userName,passworld);
        clientRepository.save(toInsert);
    }

    @PostMapping("/")
    public void create(@RequestBody Client client) {
        clientRepository.save(client);
    }

}
