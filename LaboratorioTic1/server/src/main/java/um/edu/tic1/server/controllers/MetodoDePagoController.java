package um.edu.tic1.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import um.edu.tic1.server.dtos.MetodoDePagoDTO;
import um.edu.tic1.server.entities.MetodoDePago;
import um.edu.tic1.server.repositories.MetodoDePagoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/getMetodos/{userName}")
    @Transactional
    public List<MetodoDePagoDTO> getMetodos (@PathVariable("userName") String userName){
        return metodoDePagoRepository.findAllByUsuario(userName).stream().map(MetodoDePago::toDTO).collect(Collectors.toList());
    }

}
