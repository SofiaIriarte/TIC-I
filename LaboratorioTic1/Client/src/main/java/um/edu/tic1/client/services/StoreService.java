package um.edu.tic1.client.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import um.edu.tic1.client.dtos.StoreDTO;

@Service
public class StoreService {

    public void save (StoreDTO store){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<StoreDTO> body = new HttpEntity<>(store);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/store/saveStore",
                HttpMethod.POST,body,String.class);
        System.out.println("RestTemplate response: " + response.getBody());
    }

    public StoreDTO findById (String userName){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StoreDTO> response = restTemplate.exchange("http://localhost:8080/store/findById/"+userName,
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        StoreDTO storeDTO = response.getBody();
        return storeDTO;
    }

    public StoreDTO findByNum (int id){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StoreDTO> response = restTemplate.exchange("http://localhost:8080/store/findByNumId/"+id,
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        StoreDTO storeDTO = response.getBody();
        return storeDTO;
    }

}
