package com.example.ticproject.app.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MetodoDePagoRepository extends CrudRepository<MetodoDePago, Integer> {

    List<MetodoDePago> findByTitular(String titular);

    MetodoDePago findByNTarjeta(int nTarjeta);

}
