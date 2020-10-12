package um.edu.tic1.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import um.edu.tic1.server.entities.MetodoDePago;

@Repository
public interface MetodoDePagoRepository extends CrudRepository<MetodoDePago, Integer> {

}
