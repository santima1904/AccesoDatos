package controlador;

import controlador.gestionXML.UtilidadesXML;
import modelo.Producto;

import java.util.ArrayList;

public class Main {

    private static final String NOMBRE_FICHERO = "./productos.xml";

    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();
            productos.add(new Producto(1,"Mantequilla",10,15));
            productos.add(new Producto(2,"Brocheta",99.67,100));
            productos.add(new Producto(3,"Piel de Toro",9999.99,14));

        UtilidadesXML.exportarXML(NOMBRE_FICHERO,productos);
    }

}
