package um.edu.tic1.client.dtos;

import java.time.LocalDate;

public class ClientDTO {

    private String cI;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String address;
    private String userName;
    private String passworld;
    //private List<MetodoDePagoDTO> metodoDePagos;
    private ShoppingCartDTO cartS;

    public ClientDTO(){
    }

    public ClientDTO(String cI, String firstName, String lastName, LocalDate birthday, String address,
                     String userName, String passworld, ShoppingCartDTO shoppingCartDTO) {
        this.cI = cI;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.userName = userName;
        this.passworld = passworld;
        //this.metodoDePagos = new ArrayList<>();
        this.cartS = shoppingCartDTO;
    }

    public ClientDTO(String cI, String firstName, String lastName, LocalDate birthday, String address,
                     String userName, String passworld) {
        this.cI = cI;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.userName = userName;
        this.passworld = passworld;
        //this.metodoDePagos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format(
                "Client[id=%d, firstName='%s', lastName='%s']",
                cI, firstName, lastName);
    }

    public String getcI() {
        return cI;
    }

    public void setcI(String cI) {
        this.cI = cI;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

//    public List<MetodoDePagoDTO> getMetodoDePagos() {
//        return metodoDePagos;
//    }
//
//    public void setMetodoDePagos(List<MetodoDePagoDTO> metodoDePagos) {
//        this.metodoDePagos = metodoDePagos;
//    }

    public ShoppingCartDTO getCartS() {
        return cartS;
    }

    public void setCartS(ShoppingCartDTO cartS) {
        this.cartS = cartS;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

}