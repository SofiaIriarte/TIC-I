package com.example.ticproject.app.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.sql.Time;

@RestController
@RequestMapping("/cp")
@AllArgsConstructor
@Service
public class CPController {

    @Autowired
    CPRepository cpRepository;

    @Transactional
    public void createCP(int iD) {
        CP toInsert = new CP(iD);
        cpRepository.save(toInsert);
    }

    @PostMapping("/")
    public void create(@RequestBody CP cp) {
        cpRepository.save(cp);
    }

}