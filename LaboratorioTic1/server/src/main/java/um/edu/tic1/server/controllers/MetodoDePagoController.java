package um.edu.tic1.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import um.edu.tic1.server.entities.MetodoDePago;
import um.edu.tic1.server.repositories.MetodoDePagoRepository;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/metodo")
public class MetodoDePagoController {

    @Autowired
    MetodoDePagoRepository metodoDePagoRepository;

    @PostMapping("/saveMetodo")
    @Transactional
    public void createCustomer(@RequestBody MetodoDePago metodo) {
        metodoDePagoRepository.save(metodo);
    }

}
