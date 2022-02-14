package modelo.clasesBasicas.productos;

import modelo.clasesBasicas.productos.Producto;
import modelo.enums.TipoPlanta;

public class ProductoPlanta extends Producto {

    //Atributos
    private TipoPlanta tipo;

    //Constructor
    //Con parámetros
    public ProductoPlanta(int codigo, String descripcion, double precioUnitario, int unidades, TipoPlanta tipo) {
        super(codigo, descripcion, precioUnitario, unidades);
        this.tipo = tipo;
    }

    //Por defecto
    public ProductoPlanta() {
        this.tipo = null;
    }

    //Getters and setters
    public TipoPlanta getTipo() {
        return tipo;
    }

    public void setTipo(TipoPlanta tipo) {
        this.tipo = tipo;
    }


    //ToString
    @Override
    public String toString() {
        return super.toString() +" "+ tipo;
    }
}
