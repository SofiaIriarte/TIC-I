package um.edu.tic1.client.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import um.edu.tic1.client.dtos.StockDTO;

@Service
public class StockService {

    public void save (StockDTO stock){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<StockDTO> body = new HttpEntity<>(stock);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/stock/savestock",
                HttpMethod.POST,body,String.class);
        System.out.println("RestTemplate response: " + response.getBody());
    }

}
