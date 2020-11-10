package dtos;

public class MetodoDePagoDTO {

    private int nTarjeta;
    private String titular;
    private String usuario;

    public MetodoDePagoDTO(int nTarjeta, String titular, String usuario) {
        this.nTarjeta = nTarjeta;
        this.titular = titular;
        this.usuario = usuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
