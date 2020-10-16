package um.edu.tic1.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import um.edu.tic1.server.entities.Product;
import um.edu.tic1.server.repositories.ProductRepository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/saveproduct")
    @Transactional
    public void createCustomer(@RequestBody Product product) {
        productRepository.save(product);
    }

    @GetMapping("/findMarca")
    @Transactional
    public List<String> findUniqueBrand (){
        List<String> lista = productRepository.findDistinctByMarca();
        return lista.stream().collect(Collectors.toList());
    }

    @GetMapping("/findColor")
    @Transactional
    public List<String> findUniqueColor (){
        List<String> lista = productRepository.findDistinctByColor();
        return lista.stream().collect(Collectors.toList());
    }

    @GetMapping("/findCathegory")
    @Transactional
    public List<String> findUniqueCathegory (){
        List<String> lista = productRepository.findDistinctByCathegory();
        return lista.stream().collect(Collectors.toList());
    }
    @GetMapping("/findEstacion")
    @Transactional
    public List<String> findUniqueEstacion (){
        List<String> lista = productRepository.findDistinctByEstacion();
        return lista.stream().collect(Collectors.toList());
    }

}
