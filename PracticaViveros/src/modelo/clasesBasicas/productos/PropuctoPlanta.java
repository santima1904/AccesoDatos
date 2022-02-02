package modelo.clasesBasicas.productos;

import modelo.clasesBasicas.productos.Producto;
import modelo.enums.TipoPlanta;

public class PropuctoPlanta extends Producto {

    //Atributos
    private TipoPlanta tipo;

    //Constructor
    //Con parámetros
    public PropuctoPlanta(int codigo, String descripcion, double precioUnitario, int unidades, TipoPlanta tipo) {
        super(codigo, descripcion, precioUnitario, unidades);
        this.tipo = tipo;
    }

    //Por defecto
    public PropuctoPlanta() {
        this.tipo = null;
    }

    //Getters and setters
    public TipoPlanta getTipo() {
        return tipo;
    }

}
