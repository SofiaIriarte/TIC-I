package um.edu.tic1.server.entities;


import um.edu.tic1.server.dtos.ClientDTO;
import um.edu.tic1.server.dtos.MetodoDePagoDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name="client")
public class Client {

    @Column(length = 12)
    private String cI;
    @Column(length = 30)
    private String firstName;
    @Column(length = 30)
    private String lastName;
    private LocalDate birthday;
    @Column(length = 60)
    private String address;
    @Id
    @Column(length = 30)
    private String userName;
    @Column(length = 30)
    private String passworld;
    @OneToMany
    @JoinColumn(name="pago_nTarjeta")
    private List<MetodoDePago> metodoDePagos;
    @OneToOne
    @JoinColumn(name="cartS_iD")
    private ShoppingCart cartS;

    public Client(){
    }

    public Client(String cI, String firstName, String lastName, LocalDate birthday, String address,
                  String userName, String passworld, ShoppingCart shoppingCart) {
        this.cI = cI;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.userName = userName;
        this.passworld = passworld;
        this.metodoDePagos = new ArrayList<>();
        this.cartS = shoppingCart;
    }

    public Client(String cI, String firstName, String lastName, LocalDate birthday, String address,
                  String userName, String passworld) {
        this.cI = cI;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.userName = userName;
        this.passworld = passworld;
        this.metodoDePagos = new ArrayList<>();
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

    public List<MetodoDePago> getMetodoDePagos() {
        return metodoDePagos;
    }

    public void setMetodoDePagos(List<MetodoDePago> metodoDePagos) {
        this.metodoDePagos = metodoDePagos;
    }

    public ShoppingCart getCartS() {
        return cartS;
    }

    public void setCartS(ShoppingCart cartS) {
        this.cartS = cartS;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public ClientDTO toDTO (){
        ClientDTO clientDTO = new ClientDTO( this.cI = cI, this.firstName, this.lastName, this.birthday,
                this.address, this.userName, this.passworld);
        if (this.cartS != null){
            clientDTO.setCartS(this.cartS.toDTO());
        }
        List<MetodoDePagoDTO> metodoDePagosDtos = new ArrayList<>();
        for (MetodoDePago metodo : this.metodoDePagos) {
            metodoDePagosDtos.add(metodo.toDTO());
        }
        clientDTO.setMetodoDePagos(metodoDePagosDtos);
        return clientDTO;
    }
}
