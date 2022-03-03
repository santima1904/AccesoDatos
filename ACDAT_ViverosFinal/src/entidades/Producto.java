package entidades;

public class Producto {

    private String descripcion;
    private String codigo;
    private double precioUnitario;
    private int unidadesDisponibles;


    public Producto(String descripcion, String codigo, double precioUnitario, int unidadesDisponibles) {
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.precioUnitario = precioUnitario;
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public Producto() {
    }


    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }
    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    //ToString
    @Override
    public String toString() {
        return codigo +", "+ descripcion +", "+ precioUnitario +", "+ unidadesDisponibles;
    }
}
