package um.edu.tic1.server.dtos;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDTO {

    private String iD;
    private long precio;
    private List<ProductDTO> products;

    public ShoppingCartDTO(String iD) {
        this.iD = iD;
        this.products = new ArrayList<>();
    }

    public ShoppingCartDTO() {

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

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

}
