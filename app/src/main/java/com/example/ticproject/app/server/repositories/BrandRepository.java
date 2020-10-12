package com.example.ticproject.app.server.repositories;

import com.example.ticproject.app.server.entities.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {

    Brand findByiD(int iD);

}