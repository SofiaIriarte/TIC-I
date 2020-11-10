package um.edu.tic1.server.entities;


import um.edu.tic1.server.dtos.ProductDTO;
import um.edu.tic1.server.dtos.StoreDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name="store")
public class Store {

    @Column(name = "iD", length = 30)
    private int identificador;
    @Column(length = 5)
    private int horaApertura;
    @Column(length = 5)
    private int horaCerrar;
    @Id
    @Column(length = 30)
    private String user;
    @Column(length = 30)
    private String address;
    @Column(length = 30)
    private String password;
//    @ManyToMany(mappedBy = "stores")
//    private List<Product> products;
//    @ManyToMany(mappedBy = "storesBrand")
//    private List<Brand> brands;

    public Store(int iD, int horaApertura, int horaCerrar, String user, String address, String password) {
        this.identificador = iD;
        this.horaApertura = horaApertura;
        this.horaCerrar = horaCerrar;
        this.user = user;
        this.address = address;
        this.password = password;
    }

    public Store() {

    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
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

    public StoreDTO toDTO(){
        StoreDTO storeDTO = new StoreDTO(this.identificador = identificador, this.horaApertura,this.horaCerrar, this.user, this.address, this.password);
        List<ProductDTO> productDTOS = new ArrayList<>();
        return storeDTO;
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
