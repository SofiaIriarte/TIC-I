package um.edu.tic1.client.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import um.edu.tic1.client.dtos.BrandDTO;

@Service
public class BrandService {

    public void save (BrandDTO brand){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<BrandDTO> body = new HttpEntity<>(brand);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/brand/savebrand",
                HttpMethod.POST,body,String.class);
        System.out.println("RestTemplate response: " + response.getBody());
    }

    public BrandDTO findById (int userName){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BrandDTO> response = restTemplate.exchange("http://localhost:8080/brand/findById/"+userName,
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        BrandDTO brandDTO = response.getBody();
        return brandDTO;
    }

}
