package dtos;

public class StockDTO {

    private String id;
    private int productId;
    private int storeId;
    private String talle;
    private int quantity;
    private String color;

    public StockDTO (String id, int productId, int storeId, String talle, int quantity, String color){
        this.id = id;
        this.productId = productId;
        this.storeId = storeId;
        this.talle = talle;
        this.quantity = quantity;
        this.color = color;
    }

    public StockDTO() {    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
