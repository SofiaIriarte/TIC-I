package dtos;

public class ProductDTO {

    private int iD;
    private long price;
    private String description;
    private String name;
    private String cathegory;
    private String marca;
    private String estacion;
    private byte[] image;

    public ProductDTO(int iD, long price, String description, String name,
                      String cathegory, String marca, String estacion) {
        this.iD = iD;
        this.price = price;
        this.description = description;
        this.name = name;
        this.cathegory = cathegory;
        this.marca = marca;
        this.estacion = estacion;
    }

    public ProductDTO() {

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
