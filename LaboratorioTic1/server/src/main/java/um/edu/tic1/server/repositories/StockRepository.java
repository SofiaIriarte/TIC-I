package um.edu.tic1.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import um.edu.tic1.server.entities.Stock;

import java.util.List;

@Repository
public interface StockRepository extends CrudRepository<Stock, String> {

    List<Stock> findAllByProductId(int productId);

}
