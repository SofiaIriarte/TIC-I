package dtos;

public class StoreDTO {

    private int iD;
    private int horaApertura;
    private int horaCerrar;
    private String user;
    private String address;
    private String password;

    public StoreDTO(int iD, int horaApertura, int horaCerrar, String user, String address, String password) {
        this.iD = iD;
        this.horaApertura = horaApertura;
        this.horaCerrar = horaCerrar;
        this.user = user;
        this.address = address;
        this.password = password;
    }

    public StoreDTO() {    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(int horaApertura) {
        this.horaApertura = horaApertura;
    }

    public int getHoraCerrar() {
        return horaCerrar;
    }

    public void setHoraCerrar(int horaCerrar) {
        this.horaCerrar = horaCerrar;
    }
}
