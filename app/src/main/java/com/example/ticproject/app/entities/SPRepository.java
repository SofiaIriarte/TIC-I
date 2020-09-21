package com.example.ticproject.app.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SPRepository extends CrudRepository<SP, Integer> {

    SP findByiD(int iD);


}