package um.edu.tic1.server.entities;

import um.edu.tic1.server.dtos.BrandDTO;
import um.edu.tic1.server.dtos.ProductDTO;
import um.edu.tic1.server.dtos.StoreDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name="brand")
public class Brand {

    @Id
    private int iD;
    @Column(length = 30)
    private String name;
    @Column(length = 30)
    private String passworld;
    @OneToMany
    @JoinColumn(name="product_iD")
    private List<Product> products;
    @ManyToMany
    @JoinTable(
            name = "Brand_Store",
            joinColumns = {@JoinColumn(name = "brand_id")},
            inverseJoinColumns = {@JoinColumn(name = "store_id")}
    )
    private List<Store> storesBrand;

    public Brand() {
    }

    public Brand(int iD, String name, String passworld) {
        this.iD = iD;
        this.name = name;
        this.passworld = passworld;
        this.products = new ArrayList<>();
        this.storesBrand = new ArrayList<>();
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Store> getStoresBrand() {
        return storesBrand;
    }

    public void setStoresBrand(List<Store> storesBrand) {
        this.storesBrand = storesBrand;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

    public BrandDTO toDTO() {
        BrandDTO brandDTO = new BrandDTO(this.iD, this.name, this.passworld );
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product producto:this.products){
            productDTOS.add(producto.toDTO());
        }
        brandDTO.setProducts(productDTOS);
        List<StoreDTO> storeDTOS = new ArrayList<>();
        for (Store store:this.storesBrand){
            storeDTOS.add(store.toDTO());
        }
        brandDTO.setStoresBrand(storeDTOS);
        return brandDTO;
    }

}
