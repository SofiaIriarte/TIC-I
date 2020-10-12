package com.example.ticproject.app.client.services;

import com.example.ticproject.app.dto.ClientDTO;
import com.example.ticproject.app.server.entities.Client;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientServices {

    public void save (Client client){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ClientDTO> body = new HttpEntity<>(client.toDTO());
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/client/saveClient", HttpMethod.POST,body,String.class);
        System.out.println("RestTemplate response: " + response.getBody());
    }

}
