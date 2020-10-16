package um.edu.tic1.server.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import um.edu.tic1.server.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product findByiD(int iD);

    List<Product> findByCathegory(String Cat);

    @Query("SELECT distinct p.marca from product p")
    List<String> findDistinctByMarca();

    @Query("SELECT distinct p.cathegory from product p")
    List<String> findDistinctByCathegory();

    @Query("SELECT distinct p.color from product p")
    List<String> findDistinctByColor();

    @Query("SELECT distinct p.estacion from product p")
    List<String> findDistinctByEstacion();

}
