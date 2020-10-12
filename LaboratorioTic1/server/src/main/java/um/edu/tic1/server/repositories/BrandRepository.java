package um.edu.tic1.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import um.edu.tic1.server.entities.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {

    Brand findByiD(int iD);

}
