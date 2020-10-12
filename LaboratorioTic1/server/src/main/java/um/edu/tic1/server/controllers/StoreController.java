package um.edu.tic1.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import um.edu.tic1.server.entities.Store;
import um.edu.tic1.server.repositories.StoreRepository;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreRepository storeRepository;

    @PostMapping("/saveStore")
    @Transactional
    public void createCustomer(@RequestBody Store store) {
        storeRepository.save(store);
    }

}
