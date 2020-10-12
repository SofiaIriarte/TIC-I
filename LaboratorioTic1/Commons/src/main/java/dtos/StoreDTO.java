package dtos;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class StoreDTO {

    private int iD;
    private Time hours;
    private String user;
    private String address;
    private String password;
    private List<ProductDTO> products;
    private List<BrandDTO> brands;

    public StoreDTO(int iD, Time hours, String user, String address, String password) {
        this.iD = iD;
        this.hours = hours;
        this.user = user;
        this.address = address;
        this.password = password;
        this.products = new ArrayList<>();
        this.brands = new ArrayList<>();
    }

    public StoreDTO() {    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public Time getHours() {
        return hours;
    }

    public void setHours(Time hours) {
        this.hours = hours;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public List<BrandDTO> getBrands() {
        return brands;
    }

    public void setBrands(List<BrandDTO> brands) {
        this.brands = brands;
    }

}
