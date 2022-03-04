package XML;

import principal.Main;

public class Reader {
    public static void generarTabla(){
        UtilidadesXML.mostrarTabla(UtilidadesXML.parseXML(UtilidadesXML.getDocumentBuilder(true,true), Main.NOMBRE_FICHERO));
    }
}
