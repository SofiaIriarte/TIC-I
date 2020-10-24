package um.edu.tic1.client.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import um.edu.tic1.client.dtos.ClientDTO;


@Service
public class ClientService {

    public void save (ClientDTO client){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ClientDTO> body = new HttpEntity<>(client);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/client/saveMetodo",
                HttpMethod.POST,body,String.class);
        System.out.println("RestTemplate response: " + response.getBody());
    }

    public ClientDTO findById (String userName){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ClientDTO> response = restTemplate.exchange("http://localhost:8080/client/findById/"+userName,
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        ClientDTO client = response.getBody();
        return client;
    }

}
