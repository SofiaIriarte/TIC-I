package um.edu.tic1.server.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import um.edu.tic1.server.entities.Administrador;
import um.edu.tic1.server.repositories.AdministradorRepository;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    AdministradorRepository administradorRepository;

    @PostMapping("/saveadmin")
    @Transactional
    public void createBrand(@RequestBody Administrador administrador) {
        administradorRepository.save(administrador);
    }

}
