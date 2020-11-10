package dtos;

public class ShoppingCartDTO {

    private String iD;
    private long precio;

    public ShoppingCartDTO(String iD) {
        this.iD = iD;
    }

    public ShoppingCartDTO() {

    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

}
