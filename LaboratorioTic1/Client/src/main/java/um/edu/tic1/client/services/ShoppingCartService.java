package um.edu.tic1.client.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import um.edu.tic1.client.dtos.ShoppingCartDTO;

@Service
public class ShoppingCartService {

    public void save (ShoppingCartDTO cart){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ShoppingCartDTO> body = new HttpEntity<>(cart);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/shopcart/saveCart",
                HttpMethod.POST,body,String.class);
        System.out.println("RestTemplate response: " + response.getBody());
    }

}
