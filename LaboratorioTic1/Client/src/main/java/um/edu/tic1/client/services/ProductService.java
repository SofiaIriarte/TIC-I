package um.edu.tic1.client.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import um.edu.tic1.client.dtos.ProductDTO;

import java.util.List;

@Service
public class ProductService {

    public void save (ProductDTO product){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ProductDTO> body = new HttpEntity<>(product);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/product/saveproduct",
                HttpMethod.POST,body,String.class);
        System.out.println("RestTemplate response: " + response.getBody());
    }

    public List<String> getDistinctBrand (){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<String>> response = restTemplate.exchange("http://localhost:8080/product/findMarca",
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        List<String> brands = response.getBody();
        return brands;
    }

    public List<String> getDistinctColor (){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<String>> response = restTemplate.exchange("http://localhost:8080/product/findColor",
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        List<String> brands = response.getBody();
        return brands;
    }

    public List<String> getDistinctCathegory (){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<String>> response = restTemplate.exchange("http://localhost:8080/product/findCathegory",
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        List<String> brands = response.getBody();
        return brands;
    }

    public List<String> getDistinctEstacion (){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<String>> response = restTemplate.exchange("http://localhost:8080/product/findEstacion",
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        List<String> brands = response.getBody();
        return brands;
    }

    public List<ProductDTO> getProductosFiltrados (String cat, String brand, String col, String esta){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ProductDTO>> response = restTemplate.exchange("http://localhost:8080/product/findFilters/"+cat+"/"+brand+"/"+col+"/"+esta,
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        List<ProductDTO> productosfiltrados = response.getBody();
        return productosfiltrados;
    }

    public List<ProductDTO> getProductsByCathegory (String cat){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ProductDTO>> response = restTemplate.exchange("http://localhost:8080/product/findCathegory/"+cat,
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        List<ProductDTO> productosfiltrados = response.getBody();
        return productosfiltrados;
    }

}
