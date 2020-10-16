package um.edu.tic1.server.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import um.edu.tic1.server.dtos.BrandDTO;
import um.edu.tic1.server.entities.Brand;
import um.edu.tic1.server.repositories.BrandRepository;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

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

    @GetMapping("/findById/{id}")
    @Transactional
    public BrandDTO findByUserName (@PathVariable("id") Integer id) throws NoSuchElementException {
        if (brandRepository.existsById(id)){
            Brand brand = brandRepository.findById(id).get();
            return brand.toDTO();
        }
        return null;
    }

}
