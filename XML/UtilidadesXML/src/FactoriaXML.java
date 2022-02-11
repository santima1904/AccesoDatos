import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public abstract class FactoriaXML {

    public static DocumentBuilder getDocumentBuilder(boolean ignorarComentarios, boolean ignorarEspaciosBlancos){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder document = null;
        dbf.setIgnoringComments(ignorarComentarios);
        dbf.setIgnoringElementContentWhitespace(ignorarEspaciosBlancos);
        try {
            document = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return document;
    }

    public static Document generarDocumentVacio(DocumentBuilder db){
        return db.newDocument();
    }
}
