package um.edu.tic1.client.dtos;

public class StockDTO {

    private String id;
    private int productId;
    private int storeId;
    private String talle;
    private int quantity;

    public StockDTO (String id, int productId, int storeId, String talle, int quantity){
        this.id = id;
        this.productId = productId;
        this.storeId = storeId;
        this.talle=talle;
        this.quantity = quantity;
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
}