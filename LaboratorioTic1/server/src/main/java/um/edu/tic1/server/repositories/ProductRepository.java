package um.edu.tic1.server.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import um.edu.tic1.server.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product findByiD(int iD);

    @Query("SELECT distinct p.marca from product p")
    List<String> findDistinctByMarca();

    @Query("SELECT distinct p.cathegory from product p")
    List<String> findDistinctByCathegory();

    @Query("SELECT distinct p.color from product p")
    List<String> findDistinctByColor();

    @Query("SELECT distinct p.estacion from product p")
    List<String> findDistinctByEstacion();

    @Query(value = "SELECT p FROM product p WHERE (:cathegory is null or p.cathegory = :cathegory) and (:marca is null or p.marca = :marca) and (:color is null or p.color = :color) and (:estacion is null or p.estacion = :estacion)")
    List<Product> findAllByCathegoryAndMarcaAndColorAndEstacion(@Param("cathegory") String cathegory, @Param("marca") String marca, @Param("color") String color, @Param("estacion") String estacion);

    List<Product> findAllByCathegory(String cat);

}
