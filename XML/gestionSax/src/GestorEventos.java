import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.io.PrintStream;

public class GestorEventos extends DefaultHandler {

    private static final String INDENT_NIVEL = "  ";  // Para indentación
    private final PrintStream ps = new PrintStream(System.out);
    private int nivel;


    @Override
    public void startDocument() {
        nivel = 0;
    }

    @Override
    public void startElement(String uri, String nombreLocal, String nombreCualif, Attributes atributos) {
        nivel++;
        ps.println("Inicio de elemento "+nombreCualif);
    }

    @Override
    public void endElement(String uri, String nombreLocal, String nombreCualif) {
        nivel--;
        ps.println("Fin de elemento "+nombreCualif);
    }

    @Override
    public void characters(char[] cars, int inicio, int longitud) {
        String texto = new String(cars, inicio, longitud);
        if (texto.trim().length() != 0) {
            ps.println("Contenido en texto:" + texto);
        }
    }
}
