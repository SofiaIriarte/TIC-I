package com.example.ticproject.app.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
@RestController
@RequestMapping("/brand")
@AllArgsConstructor
@Service
public class BrandController {

    @Autowired
    BrandRepository brandRepository;

    @Transactional
    public void createBrand(int iD, String name) {
        Brand toInsert = new Brand(iD,name);
        brandRepository.save(toInsert);
    }

    @PostMapping("/")
    public void create(@RequestBody Brand brand) {
        brandRepository.save(brand);
    }

}