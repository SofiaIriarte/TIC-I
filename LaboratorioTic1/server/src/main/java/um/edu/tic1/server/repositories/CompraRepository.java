package um.edu.tic1.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import um.edu.tic1.server.entities.Compra;

import java.util.List;

@Repository
public interface CompraRepository extends CrudRepository<Compra, String> {

    List<Compra> findAllByUserId(String userID);

    List<Compra> findAllByTienda (String tienda);

}
