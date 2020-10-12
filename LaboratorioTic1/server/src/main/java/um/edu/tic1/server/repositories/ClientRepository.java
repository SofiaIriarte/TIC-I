package um.edu.tic1.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import um.edu.tic1.server.dtos.ClientDTO;
import um.edu.tic1.server.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {

    ClientDTO findByUserName (String userName);

}
