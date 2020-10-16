package um.edu.tic1.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import um.edu.tic1.server.dtos.AdministradorDTO;
import um.edu.tic1.server.entities.Administrador;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador, String> {

    AdministradorDTO findByUserName (String userName);

}

