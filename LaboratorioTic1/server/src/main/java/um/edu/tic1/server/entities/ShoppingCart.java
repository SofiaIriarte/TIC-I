package um.edu.tic1.server.entities;

import um.edu.tic1.server.dtos.ProductDTO;
import um.edu.tic1.server.dtos.ShoppingCartDTO;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name="shopping_cart")
public class ShoppingCart {

    @Id
    private String iD;
    private long precio;

    public ShoppingCart(String iD) {
        this.iD = iD;
    }

    public ShoppingCart() {

    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public ShoppingCartDTO toDTO(){
        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO(this.iD);
        List<ProductDTO> productDTOS = new ArrayList<>();
        return shoppingCartDTO;
    }

}
