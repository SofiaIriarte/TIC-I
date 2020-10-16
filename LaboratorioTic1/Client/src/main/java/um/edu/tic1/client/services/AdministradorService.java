package um.edu.tic1.client.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import um.edu.tic1.client.dtos.AdministradorDTO;

@Service
public class AdministradorService {

    public AdministradorDTO findById (String userName){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AdministradorDTO> response = restTemplate.exchange("http://localhost:8080/administrador/findById/"+userName,
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        AdministradorDTO administradorDTO = response.getBody();
        return administradorDTO;
    }

}
