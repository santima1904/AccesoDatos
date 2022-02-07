package modelo.clasesBasicas.productos;

public abstract class Producto {

    //Atributos
    private int codigo;
    private String descripcion;
    private double precioUnitario;
    private int unidades;

    //Constructores
    //Con parámetros
    public Producto(int codigo, String descripcion, double precioUnitario, int unidades) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.unidades = unidades;
    }

    //Por defecto
    public Producto() {
        this.codigo = 0;
        this.descripcion = " ";
        this.precioUnitario = 0;
        this.unidades = 0;
    }

    //Getters and setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}
