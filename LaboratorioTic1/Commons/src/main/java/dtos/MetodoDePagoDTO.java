package dtos;

public class MetodoDePagoDTO {

    private int nTarjeta;
    private String titular;

    public MetodoDePagoDTO(int nTarjeta, String titular) {
        this.nTarjeta = nTarjeta;
        this.titular = titular;
    }

    public MetodoDePagoDTO() {

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

}
