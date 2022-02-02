// Creación de árbol DOM añadiendo elementos y serialización una vez creado
package creardocumentodom;

import java.io.StringWriter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.stream.StreamResult;

public class CrearDocumentoDOM {

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            doc.setXmlVersion("1.0");

            Element elClientes = doc.createElement("clientes");
            doc.appendChild(elClientes);

            Element elCliente = doc.createElement("cliente");
            elCliente.setAttribute("DNI", "89012345E");
            Element elApell = doc.createElement("apellidos");
            elApell.appendChild(doc.createTextNode("ROJAS"));
            elCliente.appendChild(elApell);
            Element elValidez = doc.createElement("validez");
            elValidez.setAttribute("estado", "borrado");
            elValidez.setAttribute("timestamp", "1528286082");
            elCliente.appendChild(elValidez);

            elClientes.appendChild(elCliente);

            Element elCliente2 = doc.createElement("cliente");
            elCliente2.setAttribute("DNI", "77866084K");
            Element elApell2 = doc.createElement("apellidos");
            elApell2.appendChild(doc.createTextNode("Macetero"));
            elCliente2.appendChild(elApell2);
            Element elValidez2 = doc.createElement("validez");
            elValidez2.setAttribute("estado", "activo papi");
            elValidez2.setAttribute("timestamp", "si");
            elCliente2.appendChild(elValidez2);

            elClientes.appendChild(elCliente2);

            DOMSource domSource = new DOMSource(doc);
            Transformer transformer = TransformerFactory.newInstance().
                    newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");


            StreamResult sr = new StreamResult("./prueba.xml");
            transformer.transform(domSource, sr);
        } catch (ParserConfigurationException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
