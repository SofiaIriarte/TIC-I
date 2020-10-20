package um.edu.tic1.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import um.edu.tic1.server.dtos.ProductDTO;
import um.edu.tic1.server.entities.Product;
import um.edu.tic1.server.repositories.ProductRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/findProduct/")
    @Transactional
    public ProductDTO findProduct (@RequestParam(name = "productId") String productId){
        int idProduct = Integer.parseInt(productId);
        if (productRepository.existsById(idProduct)){
            Product product = productRepository.findById(idProduct).get();
            return product.toDTO();
        }
        return null;
    }

    @PostMapping("/saveproduct")
    @Transactional
    public void createCustomer(@RequestBody Product product) {
        productRepository.save(product);
    }

    @GetMapping("/findMarca")
    @Transactional
    public List<String> findUniqueBrand (){
        List<String> lista = productRepository.findDistinctByMarca();
        return lista.stream().collect(Collectors.toList());
    }

    @GetMapping("/findColor")
    @Transactional
    public List<String> findUniqueColor (){
        List<String> lista = productRepository.findDistinctByColor();
        return lista.stream().collect(Collectors.toList());
    }

    @GetMapping("/findCathegory")
    @Transactional
    public List<String> findUniqueCathegory (){
        List<String> lista = productRepository.findDistinctByCathegory();
        return lista.stream().collect(Collectors.toList());
    }

    @GetMapping("/findEstacion")
    @Transactional
    public List<String> findUniqueEstacion (){
        List<String> lista = productRepository.findDistinctByEstacion();
        return lista.stream().collect(Collectors.toList());
    }

    @GetMapping("/findProducts/")
    @Transactional
    public List<ProductDTO> findProducts (@RequestParam(name = "cathegory", required = false) String cathegory,
                                          @RequestParam(name = "marca", required = false) String marca,
                                          @RequestParam(name = "color", required = false) String color,
                                          @RequestParam(name = "estacion", required = false) String estacion) {
        if (cathegory != null || marca != null || color != null || estacion != null){
            List<Product>  result = productRepository.findAll(new ProductSpecification(cathegory, marca, color, estacion));
            return result.stream().map(Product::toDTO).collect(Collectors.toList());
        } else {
            List<Product> result = new ArrayList<>();
            Iterator<Product> studentIterator = productRepository.findAll().iterator();
            while (studentIterator.hasNext())
                result.add(studentIterator.next());
            return result.stream().map(Product::toDTO).collect(Collectors.toList());
        }
    }

}
