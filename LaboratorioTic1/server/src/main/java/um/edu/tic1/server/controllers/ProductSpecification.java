package um.edu.tic1.server.controllers;

import org.springframework.data.jpa.domain.Specification;
import um.edu.tic1.server.entities.Product;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification  implements Specification<Product> {

    private String cathegory;
    private String marca;
    private String color;
    private String estacion;

    public ProductSpecification (String cathegory, String marca, String color, String estacion){
        this.cathegory = cathegory;
        this.marca = marca;
        this.color = color;
        this.estacion = estacion;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (cathegory != null) {
            predicates.add(criteriaBuilder.equal(root.get("cathegory"), cathegory));
        }
        if (marca != null) {
            predicates.add(criteriaBuilder.equal(root.get("marca"), marca));
        }
        if (color != null) {
            predicates.add(criteriaBuilder.equal(root.get("color"), color));
        }
        if (estacion != null) {
            predicates.add(criteriaBuilder.equal(root.get("estacion"), estacion));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

}
