package um.edu.tic1.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import um.edu.tic1.server.dtos.CarritoDTO;
import um.edu.tic1.server.entities.Carrito;
import um.edu.tic1.server.repositories.CarritoRepository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    CarritoRepository carritoRepository;

    @PostMapping("/saveCarrito")
    @Transactional
    public void createBrand(@RequestBody Carrito carrito) {
        carritoRepository.save(carrito);
    }

    @DeleteMapping("/eliminar/{id}")
    @Transactional
    public void eliminar (@PathVariable String id){
        carritoRepository.deleteById(id);
    }

    @GetMapping("/getAllCartItems/{userId}")
    @Transactional
    public List<CarritoDTO> getCartItems (@PathVariable("userId") String userId){
        return carritoRepository.findAllByUserId(userId).stream().map(Carrito::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/getItem/{identificador}")
    @Transactional
    public CarritoDTO getItem (@PathVariable("identificador") String identificador){
        if (carritoRepository.existsById(identificador)){
            return carritoRepository.findByIdentificador(identificador).toDTO();
        }
        return null;
    }

}
