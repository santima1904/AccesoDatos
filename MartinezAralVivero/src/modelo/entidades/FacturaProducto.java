package modelo.entidades;

public class FacturaProducto {
    private int idFactura;
    private String code;
    private int cantidad;
    private double valorPrecio;
    private double coste;

    public FacturaProducto() {
    }

    public FacturaProducto(String code, int cantidad, double valorPrecio, double coste) {
        this.idFactura = 0;
        this.code = code;
        this.cantidad = cantidad;
        this.valorPrecio = valorPrecio;
        this.coste = coste;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorPrecio() {
        return valorPrecio;
    }

    public void setValorPrecio(double valorPrecio) {
        this.valorPrecio = valorPrecio;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
}
