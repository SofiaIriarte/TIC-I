package com.example.ticproject.app.entitiesControllers;

import com.example.ticproject.app.entities.Brand;
import com.example.ticproject.app.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class BrandController {

    @Autowired
    BrandRepository brandRepository;

    @Transactional
    public void createBrand(int iD, String name) {
        Brand toInsert = new Brand(iD,name);
        brandRepository.save(toInsert);
    }

}