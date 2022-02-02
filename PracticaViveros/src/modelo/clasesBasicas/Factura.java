package modelo.clasesBasicas;

import modelo.clasesBasicas.personas.Cliente;
import modelo.clasesBasicas.personas.UsuarioVendedor;
import java.time.LocalDate;

public class Factura {

    //Artibutos
    private LocalDate fecha;
    private double importe;
    private UsuarioVendedor vendedor;
    private Cliente cliente;

    //Constructores
    //Con parámetros
    public Factura(LocalDate fecha, double importe, UsuarioVendedor vendedor, Cliente cliente) {
        this.fecha = fecha;
        this.importe = importe;
        this.vendedor = vendedor;
        this.cliente = cliente;
    }

    //Por defecto
    public Factura() {
        this.fecha = null;
        this.importe = 0;
        this.vendedor = null;
        this.cliente = null;
    }

    //Getters and setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public UsuarioVendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(UsuarioVendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
