package um.edu.tic1.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import um.edu.tic1.server.entities.Carrito;

import java.util.List;

@Repository
public interface CarritoRepository extends CrudRepository<Carrito, String> {

    List<Carrito> findAllByUserId (String userId);

    Carrito findByIdentificador (String id);

}
