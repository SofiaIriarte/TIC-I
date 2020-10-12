package um.edu.tic1.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import um.edu.tic1.server.entities.Product;
import um.edu.tic1.server.repositories.ProductRepository;

import javax.transaction.Transactional;

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

}
