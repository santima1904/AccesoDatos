import java.util.ArrayList;

public class CrearDocumentoDOM {

    private static final String NOMBRE_FICHERO = "./papopepo.xml";

    private static ArrayList<Producto> generarLista(){
        ArrayList<Producto> productos = new ArrayList<>();
        Producto p1 = new Producto(1,"Mantequilla",10);
        Producto p2 = new Producto(2,"Brocheta",99.67);
        Producto p3 = new Producto(3,"Piel de Toro",9999.99);
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        return productos;
    }

    public static void main(String[] args) {
        UtilidadesXML.exportarXML(NOMBRE_FICHERO,generarLista());
    }
}
