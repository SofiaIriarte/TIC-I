package com.example.ticproject.app.server.entitiesControllers;

import com.example.ticproject.app.server.entities.Brand;
import com.example.ticproject.app.server.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class BrandController {

    @Autowired
    BrandRepository brandRepository;

    @Transactional
    public void createBrand(int iD, String name, String passworld) {
        Brand toInsert = new Brand(iD,name,passworld);
        brandRepository.save(toInsert);
    }

}