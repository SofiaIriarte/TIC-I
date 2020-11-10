package um.edu.tic1.server.dtos;

public class BrandDTO {

    private int iD;
    private String name;
    private String passworld;

    public BrandDTO() {
    }

    public BrandDTO(int iD, String name, String passworld) {
        this.iD = iD;
        this.name = name;
        this.passworld = passworld;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

}
