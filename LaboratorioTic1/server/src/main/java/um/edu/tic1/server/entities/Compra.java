package um.edu.tic1.server.entities;

import um.edu.tic1.server.dtos.CompraDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Compra {

    @Id
    private String identificador;
    private String productName;
    private String userId;
    private String tiendaTalle;
    private int quantity;
    private String price;
    private LocalDate date;
    private String metodoDePago;

    public Compra (){}

    public Compra (String id, String productId, String userId, String type, int quantity,
                   String price, LocalDate date, String metodoDePago){
        this.identificador=id;
        this.productName=productId;
        this.userId=userId;
        this.tiendaTalle =type;
        this.quantity=quantity;
        this.price = price;
        this.date = date;
        this.metodoDePago = metodoDePago;
    }

    public String getId() {
        return identificador;
    }

    public void setId(String id) {
        this.identificador = id;
    }

    public String getProductId() {
        return productName;
    }

    public void setProductId(String productId) {
        this.productName = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTiendaTalle() {
        return tiendaTalle;
    }

    public void setTiendaTalle(String type) {
        this.tiendaTalle = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public CompraDTO toDTO (){
        return new CompraDTO(this.identificador,this.productName,this.userId,this.tiendaTalle,
                this.quantity,this.price,this.date,this.metodoDePago);
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }
}
