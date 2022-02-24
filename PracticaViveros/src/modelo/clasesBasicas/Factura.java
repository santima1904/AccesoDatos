package modelo.clasesBasicas;

import modelo.clasesBasicas.personas.Cliente;
import modelo.clasesBasicas.personas.UsuarioVendedor;

import java.time.LocalDate;

public class Factura {

    //Artibutos
    private int id;
    private LocalDate fecha;
    private double importe;
    private UsuarioVendedor vendedor;
    private Cliente cliente;

    //Constructores
    //Con parámetros
    public Factura(int id, LocalDate fecha, double importe, UsuarioVendedor vendedor, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.importe = importe;
        this.vendedor = vendedor;
        this.cliente = cliente;
    }

    //Por defecto
    public Factura() {
        id = 0;
        this.fecha = null;
        this.importe = 0;
        this.vendedor = null;
        this.cliente = null;
    }

    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Factura = " +
                id + ", " +
                fecha + ", " +
                importe + ", " +
                vendedor.getNombre() + ", " +
                cliente.getNombre();
    }
}
