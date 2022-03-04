package principal;

import XML.Reader;
import XML.UtilidadesXML;
import modelo.Cliente;

import java.util.ArrayList;

public class Main {
    public static final String NOMBRE_FICHERO = "./papopepo.xml";

    private static ArrayList<Cliente> generarLista(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        Cliente p1 = new Cliente("78901234X","Antonio","Cruz","Calle... 14 puerta 5", "44126");
        Cliente p2 = new Cliente("89012345E","Ernesto","Rojas","Calle Zimbawe 29", "41001");
        Cliente p3 = new Cliente("56789012B","Maria ","Samper","Calle Placa Solar", "29730");
        clientes.add(p1);
        clientes.add(p2);
        clientes.add(p3);
        return clientes;
    }

    public static void main(String[] args) {
        UtilidadesXML.exportarXML(NOMBRE_FICHERO,generarLista());
        Reader.generarTabla();
    }
}
