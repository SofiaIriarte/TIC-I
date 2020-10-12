package um.edu.tic1.server.dtos;

import java.util.ArrayList;
import java.util.List;

public class BrandDTO {

    private int iD;
    private String name;
    private String passworld;
    private List<ProductDTO> products;
    private List<StoreDTO> storesBrand;

    public BrandDTO() {
    }

    public BrandDTO(int iD, String name, String passworld) {
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

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public List<StoreDTO> getStoresBrand() {
        return storesBrand;
    }

    public void setStoresBrand(List<StoreDTO> storesBrand) {
        this.storesBrand = storesBrand;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

}
