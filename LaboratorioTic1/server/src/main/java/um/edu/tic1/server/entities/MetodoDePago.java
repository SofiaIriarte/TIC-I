package um.edu.tic1.server.entities;


import um.edu.tic1.server.dtos.MetodoDePagoDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name="pago")
public class MetodoDePago {

    @Id
    @Column(length = 15)
    private int nTarjeta;
    @Column(length = 45)
    private String titular;
    @Column(length = 45)
    private String usuario;

    public MetodoDePago(int nTarjeta, String titular, String usuario) {
        this.nTarjeta = nTarjeta;
        this.titular = titular;
        this.usuario = usuario;
    }

    public MetodoDePago() {
    }

    public int getnTarjeta() {
        return nTarjeta;
    }

    public void setnTarjeta(int nTarjeta) {
        this.nTarjeta = nTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public MetodoDePagoDTO toDTO (){
        MetodoDePagoDTO metodoDePagoDTO = new MetodoDePagoDTO(this.nTarjeta, this.titular, this.usuario);
        return metodoDePagoDTO;
    }

}
