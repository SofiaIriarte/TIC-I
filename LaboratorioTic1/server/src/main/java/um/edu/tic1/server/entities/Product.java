package um.edu.tic1.server.entities;

import org.hibernate.type.BlobType;
import um.edu.tic1.server.dtos.ProductDTO;
import um.edu.tic1.server.dtos.StoreDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name="product")
public class Product {

    @Id
    private int iD;
    private long price;
    @Column(length = 120)
    private String description;
    @Column(length = 60)
    private String name;
    @Column(length = 20)
    private String cathegory;
    @Lob
    private BlobType image;
    @ManyToMany
    @JoinTable(
            name = "Product_Store",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "sotre_id")}
    )
    private List<Store> stores;
    @ManyToMany
    @JoinTable(
            name = "Product_ShoppingCart",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "shopping_cart_id")}
    )
    private List<ShoppingCart> shoppingCarts;

    public Product(int iD, long price, String description, String name, String cathegory) {
        this.iD = iD;
        this.price = price;
        this.description = description;
        this.name = name;
        this.cathegory = cathegory;
        this.stores = new ArrayList<>();
        this.shoppingCarts = new ArrayList<>();
    }

    public Product() {

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

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public List<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    public ProductDTO toDTO(){
        ProductDTO productDTO = new ProductDTO(this.iD, this.price, this.description,this.name,this.cathegory);
        List<StoreDTO> productDTOS= new ArrayList<>();
        for (Store store:this.stores){
            productDTOS.add(store.toDTO());
        }
        productDTO.setStores(productDTOS);
        return productDTO;
    }

    public BlobType getImage() {
        return image;
    }

    public void setImage(BlobType image) {
        this.image = image;
    }
}