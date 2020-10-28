package um.edu.tic1.client.dtos;

import java.time.LocalDate;

public class CompraDTO {

    private String identificador;
    private String productName;
    private String userId;
    private String tiendaTalle;
    private int quantity;
    private String price;
    private LocalDate date;
    private String metodoDePago;
    private String type;
    private String estado;
    private String tienda;

    public CompraDTO (){}

    public CompraDTO (String id, String productId, String userId, String tiendaTalle, int quantity,
                      String price, LocalDate date, String metodoDePago, String type, String estado, String tienda){
        this.identificador=id;
        this.productName=productId;
        this.userId=userId;
        this.tiendaTalle =tiendaTalle;
        this.quantity=quantity;
        this.price = price;
        this.date = date;
        this.metodoDePago = metodoDePago;
        this.type = type;
        this.estado = estado;
        this.tienda = tienda;
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

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

}
