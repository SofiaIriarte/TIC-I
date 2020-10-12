package com.example.ticproject.app.server.entitiesControllers;

import com.example.ticproject.app.server.entities.MetodoDePago;
import com.example.ticproject.app.server.repositories.MetodoDePagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class MetodoDePagoController {

    @Autowired
    MetodoDePagoRepository pagoRepository;

    @Transactional
    public void createPago(int nTarjeta, String titular) {
        MetodoDePago toInsert = new MetodoDePago(nTarjeta,titular);
        pagoRepository.save(toInsert);
    }


}

