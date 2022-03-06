package controlador;

import controlador.gestionXML.UtilidadesXML;
import modelo.Producto;

import java.util.ArrayList;

public class Main {

    private static final String NOMBRE_FICHERO = "./productos.xml";

    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();
            productos.add(new Producto(1,"Pistachos",5.50,309));
            productos.add(new Producto(2,"Conchitas ",2.50,255));
            productos.add(new Producto(3,"Risquetos",1.00,500));

        UtilidadesXML.exportarXML(NOMBRE_FICHERO,productos);
        UtilidadesXML.mostrarTabla(UtilidadesXML.parseXML(UtilidadesXML.getDocumentBuilder(true,true), Main.NOMBRE_FICHERO));
    }

}
