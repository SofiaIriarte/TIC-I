package um.edu.tic1.client.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import um.edu.tic1.client.dtos.CompraDTO;

import java.util.List;

@Service
public class CompraService {

    public void save (CompraDTO compra){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CompraDTO> body = new HttpEntity<>(compra);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/compra/saveCompra",
                HttpMethod.POST,body,String.class);
        System.out.println("RestTemplate response: " + response.getBody());
    }

    public List<CompraDTO> getboughtItems (String userId){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<CompraDTO>> response = restTemplate.exchange("http://localhost:8080/compra/findByUserId/"+userId,
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        List<CompraDTO> items = response.getBody();
        return items;
    }

}
