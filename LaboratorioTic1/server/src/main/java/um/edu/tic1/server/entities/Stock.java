package um.edu.tic1.server.entities;

import um.edu.tic1.server.dtos.StockDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name="stock")
public class Stock {

    @Id
    private String id;
    @Column(length = 30)
    private int productId;
    @Column(length = 30)
    private int storeId;
    @Column(length = 6)
    private String talle;
    @Column(length = 10)
    private int quantity;
    @Column(length = 30)
    private String color;

    public Stock (String id, int productId, int storeId, String talle, int quantity, String color){
        this.id = id;
        this.productId = productId;
        this.storeId = storeId;
        this.talle=talle;
        this.quantity = quantity;
        this.color = color;
    }

    public Stock() {    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public StockDTO toDTO(){
        StockDTO stockDTO = new StockDTO(this.id, this.productId,this.storeId,this.talle,this.quantity,this.color);
        return stockDTO;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
