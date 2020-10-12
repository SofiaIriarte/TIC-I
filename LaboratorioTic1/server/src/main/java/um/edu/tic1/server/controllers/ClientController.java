package um.edu.tic1.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import um.edu.tic1.server.dtos.ClientDTO;
import um.edu.tic1.server.entities.Client;
import um.edu.tic1.server.repositories.ClientRepository;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @PostMapping("/saveClient")
    @Transactional
    public void createCustomer(@RequestBody Client client) {
        clientRepository.save(client);
    }

    @GetMapping ("/findById/{id}")
    @Transactional
    public ClientDTO findByUserName (@PathVariable("id") String id) throws NoSuchElementException {
        if (clientRepository.existsById(id)){
            Client client = clientRepository.findById(id).get();
            return client.toDTO();
        }
        return null;
    }

}
