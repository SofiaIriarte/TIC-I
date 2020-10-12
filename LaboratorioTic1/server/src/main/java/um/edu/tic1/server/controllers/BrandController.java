package um.edu.tic1.server.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import um.edu.tic1.server.entities.Brand;
import um.edu.tic1.server.repositories.BrandRepository;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandRepository brandRepository;

    @PostMapping("/savebrand")
    @Transactional
    public void createBrand(@RequestBody Brand brand) {
        brandRepository.save(brand);
    }

}
