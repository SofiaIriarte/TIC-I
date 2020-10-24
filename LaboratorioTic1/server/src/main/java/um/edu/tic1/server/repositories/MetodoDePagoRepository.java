package um.edu.tic1.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import um.edu.tic1.server.entities.MetodoDePago;

import java.util.List;

@Repository
public interface MetodoDePagoRepository extends CrudRepository<MetodoDePago, Integer> {

    List<MetodoDePago> findAllByUsuario (String userName);

}
