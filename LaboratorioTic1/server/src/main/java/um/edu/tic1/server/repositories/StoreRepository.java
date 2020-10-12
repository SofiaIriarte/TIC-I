package um.edu.tic1.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import um.edu.tic1.server.entities.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {

    Store findByiD(int iD);

}
