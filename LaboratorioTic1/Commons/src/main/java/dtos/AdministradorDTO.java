package dtos;

public class AdministradorDTO {

    private String userName;
    private String passworld;
    private String name;

    public AdministradorDTO(){    }

    public AdministradorDTO(String userName, String passworld, String name){
        this.userName = userName;
        this.passworld = passworld;
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
