package um.edu.tic1.server.entities;

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
    @Column(length = 30)
    private String marca;
    @Column(length = 15)
    private String estacion;
    @Lob
    private byte[] image;

    public Product(int iD, long price, String description, String name,
                   String cathegory, String marca, String estacion) {
        this.iD = iD;
        this.price = price;
        this.description = description;
        this.name = name;
        this.cathegory = cathegory;
        this.marca = marca;
        this.estacion = estacion;
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

    public ProductDTO toDTO(){
        ProductDTO productDTO = new ProductDTO(this.iD, this.price, this.description,this.name,
                this.cathegory,this.marca,this.estacion);
        List<StoreDTO> productDTOS= new ArrayList<>();
        productDTO.setImage(this.image);
        return productDTO;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }
}