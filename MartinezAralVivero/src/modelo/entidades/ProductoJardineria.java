package modelo.entidades;

public class ProductoJardineria extends Producto {

    //Constructor
    //Con parámetros
    public ProductoJardineria(String codigo, String descripcion, double precioUnitario, int unidades) {
        super(descripcion, codigo, precioUnitario, unidades);
    }

    //Por defecto
    public ProductoJardineria() {
    }

}
