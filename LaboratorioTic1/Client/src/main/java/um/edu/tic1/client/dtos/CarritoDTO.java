package um.edu.tic1.client.dtos;

public class CarritoDTO {

    private String id;
    private int quantity;
    private int productId;
    private String name;
    private String userId;
    private String storeAndTalle;
    private String idStock;
    private String price;
    private String type;

    public CarritoDTO (){    }

    public CarritoDTO (String id, int quantity, int productId, String name, String userId,
                       String storeAndTalle, String idStock, String price, String type){
        this.id=id;
        this.quantity=quantity;
        this.productId=productId;
        this.name=name;
        this.userId=userId;
        this.storeAndTalle=storeAndTalle;
        this.idStock = idStock;
        this.price = price;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
