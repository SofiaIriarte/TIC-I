package um.edu.tic1.client.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import um.edu.tic1.client.dtos.StockDTO;

import java.util.List;

@Service
public class StockService {

    public void save (StockDTO stock){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<StockDTO> body = new HttpEntity<>(stock);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/stock/savestock",
                HttpMethod.POST,body,String.class);
        System.out.println("RestTemplate response: " + response.getBody());
    }

    public List<StockDTO> getStocks (int productId){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<StockDTO>> response = restTemplate.exchange("http://localhost:8080/stock/getStocks/"+productId,
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        List<StockDTO> stocks = response.getBody();
        return stocks;
    }

    public StockDTO getStock (String id){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StockDTO> response = restTemplate.exchange("http://localhost:8080/stock/getStock/"+id,
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        StockDTO stock = response.getBody();
        return stock;
    }

}
