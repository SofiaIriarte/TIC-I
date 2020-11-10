package um.edu.tic1.server.entities;

import um.edu.tic1.server.dtos.BrandDTO;
import um.edu.tic1.server.dtos.ProductDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
//    @OneToMany
//    @JoinColumn(name="product_iD")
//    private List<Product> products;
//    @ManyToMany
//    @JoinTable(
//            name = "Brand_Store",
//            joinColumns = {@JoinColumn(name = "brand_id")},
//            inverseJoinColumns = {@JoinColumn(name = "store_id")}
//    )
//    private List<Store> storesBrand;

    public Brand() {
    }

    public Brand(int iD, String name, String passworld) {
        this.iD = iD;
        this.name = name;
        this.passworld = passworld;
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

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

    public BrandDTO toDTO() {
        BrandDTO brandDTO = new BrandDTO(this.iD, this.name, this.passworld );
        List<ProductDTO> productDTOS = new ArrayList<>();
        return brandDTO;
    }

}
