package um.edu.tic1.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import um.edu.tic1.server.entities.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer> {

}
