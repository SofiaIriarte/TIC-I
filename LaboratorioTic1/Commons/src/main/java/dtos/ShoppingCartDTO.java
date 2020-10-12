package dtos;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDTO {

    private int iD;
    private long precio;
    private List<ProductDTO> products;

    public ShoppingCartDTO(int iD, long precio) {
        this.iD = iD;
        this.precio = precio;
        this.products = new ArrayList<>();
    }

    public ShoppingCartDTO() {

    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
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
