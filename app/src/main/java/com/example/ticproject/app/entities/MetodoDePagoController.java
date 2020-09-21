package com.example.ticproject.app.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
@RestController
@RequestMapping("/pagos")
@AllArgsConstructor
@Service
public class MetodoDePagoController {

    @Autowired
    MetodoDePagoRepository pagoRepository;

    @Transactional
    public void createPago(int nTarjeta, String titular) {
        MetodoDePago toInsert = new MetodoDePago(nTarjeta,titular);
        pagoRepository.save(toInsert);
    }

    @PostMapping("/")
    public void create(@RequestBody MetodoDePago pago) {
        pagoRepository.save(pago);
    }

}

