package um.edu.tic1.server.entities;

import um.edu.tic1.server.dtos.CarritoDTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "carrito")
public class Carrito {

    @Id
    private String identificador;
    private int quantity;
    private int productId;
    private String name;
    private String userId;
    private String storeAndTalle;
    private String idStock;
    private String price;

    public Carrito (){    }

    public Carrito (String id, int quantity, int productId, String name, String userId,
                    String storeAndTalle, String idStock, String price){
        this.identificador=id;
        this.quantity=quantity;
        this.productId=productId;
        this.name=name;
        this.userId=userId;
        this.storeAndTalle=storeAndTalle;
        this.idStock = idStock;
        this.price=price;
    }

    public String getId() {
        return identificador;
    }

    public void setId(String id) {
        this.identificador = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStoreAndTalle() {
        return storeAndTalle;
    }

    public void setStoreAndTalle(String storeAndTalle) {
        this.storeAndTalle = storeAndTalle;
    }

    public String getIdStock() {
        return idStock;
    }

    public void setIdStock(String idStock) {
        this.idStock = idStock;
    }

    public CarritoDTO toDTO (){
        return new CarritoDTO(this.identificador, this.quantity, this.productId, this.name,
                this.userId, this.storeAndTalle,this.idStock,this.price);
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
