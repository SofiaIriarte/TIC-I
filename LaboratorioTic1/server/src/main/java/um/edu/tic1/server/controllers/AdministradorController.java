package um.edu.tic1.server.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import um.edu.tic1.server.dtos.AdministradorDTO;
import um.edu.tic1.server.entities.Administrador;
import um.edu.tic1.server.repositories.AdministradorRepository;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

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

    @GetMapping("/findById/{id}")
    @Transactional
    public AdministradorDTO findByUserName (@PathVariable("id") String id) throws NoSuchElementException {
        if (administradorRepository.existsById(id)){
            Administrador administrador = administradorRepository.findById(id).get();
            return administrador.toDTO();
        }
        return null;
    }

}
