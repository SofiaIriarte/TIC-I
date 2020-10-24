package um.edu.tic1.client.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import um.edu.tic1.client.dtos.MetodoDePagoDTO;

import java.util.List;

@Service
public class MetodoDePagoService {

    public void save (MetodoDePagoDTO metodoDePagoDTO){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<MetodoDePagoDTO> body = new HttpEntity<>(metodoDePagoDTO);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/metodo/saveMetodo",
                HttpMethod.POST,body,String.class);
        System.out.println("RestTemplate response: " + response.getBody());
    }

    public List<MetodoDePagoDTO> getMetodosPorUsuario (String userName) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<MetodoDePagoDTO>> response = restTemplate.exchange("http://localhost:8080/metodo/getMetodos/"+userName,
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        List<MetodoDePagoDTO> metodos = response.getBody();
        return metodos;
    }

}
