package com.example.ticproject.app.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.sql.Time;

@RestController
@RequestMapping("/sp")
@AllArgsConstructor
@Service
public class SPController {

    @Autowired
    SPRepository spRepository;

    @Transactional
    public void createSP(int iD) {
        SP toInsert = new SP(iD);
        spRepository.save(toInsert);
    }

    @PostMapping("/")
    public void create(@RequestBody SP sp) {
        spRepository.save(sp);
    }

}