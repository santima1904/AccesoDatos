package modelo.entidades;

import modelo.enums.TipoPlanta;

public class ProductoPlanta extends Producto {

    //Atributos
    private TipoPlanta tipo;

    //Constructor
    //Con parámetros
    public ProductoPlanta(String codigo, String descripcion, double precioUnitario, int unidades, TipoPlanta tipo) {
        super(descripcion, codigo, precioUnitario, unidades);
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
        return super.toString() +", tipo: " + mostrarTipo();
    }

    //private method
    private String mostrarTipo(){
        String cadenatipo = "";
        switch (tipo){
            case INTERIOR ->  cadenatipo = "Interior";
            case EXTERIOR -> cadenatipo = "Exterior";
            case ARBOLES_FRUTALES -> cadenatipo = "Árbol frutal";
            case ARBOLES_ORNAMENTALES -> cadenatipo = "Árbol ornamental";
        }
        return cadenatipo;
    }

}
