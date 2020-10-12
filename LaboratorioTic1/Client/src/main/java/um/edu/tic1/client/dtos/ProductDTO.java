package um.edu.tic1.client.dtos;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    private int iD;
    private long price;
    private String description;
    private String name;
    private String cathegory;
    // Revisar
    private Blob image;
    private List<StoreDTO> stores;
    private List<ShoppingCartDTO> shoppingCarts;

    public ProductDTO(int iD, long price, String description, String name, String cathegory) {
        this.iD = iD;
        this.price = price;
        this.description = description;
        this.name = name;
        this.cathegory = cathegory;
        this.stores = new ArrayList<>();
        this.shoppingCarts = new ArrayList<>();
    }

    public ProductDTO() {

    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCathegory() {
        return cathegory;
    }

    public void setCathegory(String cathegory) {
        this.cathegory = cathegory;
    }

    public List<StoreDTO> getStores() {
        return stores;
    }

    public void setStores(List<StoreDTO> stores) {
        this.stores = stores;
    }

    public List<ShoppingCartDTO> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(List<ShoppingCartDTO> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

}
