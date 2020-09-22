package com.example.ticproject.app.repositories;

import com.example.ticproject.app.entities.MetodoDePago;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoDePagoRepository extends CrudRepository<MetodoDePago, Integer> {

    //List<MetodoDePago> findByTitular(String titular);

    //MetodoDePago findByNTarjeta(int nTarjeta);

}
