package um.edu.tic1.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import um.edu.tic1.server.dtos.StoreDTO;
import um.edu.tic1.server.entities.Store;
import um.edu.tic1.server.repositories.StoreRepository;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

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

    @GetMapping("/findById/{id}")
    @Transactional
    public StoreDTO findByUserName (@PathVariable("id") String id) throws NoSuchElementException {
        if (storeRepository.existsById(id)){
            Store store = storeRepository.findById(id).get();
            return store.toDTO();
        }
        return null;
    }

    @GetMapping("/findByNumId/{id}")
    @Transactional
    public StoreDTO findById (@PathVariable("id") int id) throws NoSuchElementException {
        Store store = storeRepository.findByIdentificador(id);
        return store.toDTO();
    }

}
