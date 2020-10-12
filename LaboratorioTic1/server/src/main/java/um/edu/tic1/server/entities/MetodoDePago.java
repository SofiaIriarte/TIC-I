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

    public MetodoDePago(int nTarjeta, String titular) {
        this.nTarjeta = nTarjeta;
        this.titular = titular;
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

    public MetodoDePagoDTO toDTO (){
        MetodoDePagoDTO metodoDePagoDTO = new MetodoDePagoDTO(this.nTarjeta, this.titular);
        return metodoDePagoDTO;
    }

}
