import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.IOException;

import static javax.script.ScriptEngine.FILENAME;

public class Main {
    public static void main(String[] args) {
        String nomFich = "clientes.xml";
        if (args.length < 1) {
            System.out.println("Indicar por favor nombre de fichero");
        } else {
            nomFich = args[0];
        }
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            GestorEventos handler = new GestorEventos();
            saxParser.parse(nomFich, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
