package um.edu.tic1.client.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import um.edu.tic1.client.dtos.CarritoDTO;
import um.edu.tic1.client.dtos.ShoppingCartDTO;

import java.util.List;

@Service
public class ShoppingCartService {

    public void save (ShoppingCartDTO cart){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ShoppingCartDTO> body = new HttpEntity<>(cart);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/shopcart/saveCart",
                HttpMethod.POST,body,String.class);
        System.out.println("RestTemplate response: " + response.getBody());
    }

    public void saveCarrito (CarritoDTO carrito){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CarritoDTO> body = new HttpEntity<>(carrito);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/carrito/saveCarrito",
                HttpMethod.POST,body,String.class);
        System.out.println("RestTemplate response: " + response.getBody());
    }

    public CarritoDTO getCarrito (String id){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CarritoDTO> response = restTemplate.exchange("http://localhost:8080/carrito/getItem/"+id,
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        CarritoDTO carritoDTO = response.getBody();
        return carritoDTO;
    }

    public List<CarritoDTO> getCartItems (String userId){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<CarritoDTO>> response = restTemplate.exchange("http://localhost:8080/carrito/getAllCartItems/"+userId,
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        List<CarritoDTO> items = response.getBody();
        return items;
    }

    public void deleteItem (String id){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/carrito/eliminar/"+id,
                HttpMethod.DELETE, null, new ParameterizedTypeReference<>() {});
        System.out.println("RestTemplate response: " + response.getBody());
    }

}
