package um.edu.tic1.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import um.edu.tic1.server.dtos.CompraDTO;
import um.edu.tic1.server.entities.Compra;
import um.edu.tic1.server.repositories.CompraRepository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    CompraRepository compraRepository;

    @PostMapping("/saveCompra")
    @Transactional
    public void createCustomer(@RequestBody Compra compra) {
        compraRepository.save(compra);
    }

    @GetMapping("/findByUserId/{userId}")
    @Transactional
    public List<CompraDTO> findByUserName (@PathVariable("userId") String userId) throws NoSuchElementException {
        return compraRepository.findAllByUserId(userId).stream().map(Compra::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/findByTienda/{tienda}")
    @Transactional
    public List<CompraDTO> findByTienda (@PathVariable("tienda") String tienda) throws NoSuchElementException {
        return compraRepository.findAllByTienda(tienda).stream().map(Compra::toDTO).collect(Collectors.toList());
    }

}
