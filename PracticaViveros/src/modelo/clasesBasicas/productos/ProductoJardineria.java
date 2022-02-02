package modelo.clasesBasicas.productos;

import modelo.clasesBasicas.productos.Producto;

public class ProductoJardineria extends Producto {

    //Constructor
    //Con parámetros
    public ProductoJardineria(int codigo, String descripcion, double precioUnitario, int unidades) {
        super(codigo, descripcion, precioUnitario, unidades);
    }

    //Por defecto
    public ProductoJardineria() {
    }
}
