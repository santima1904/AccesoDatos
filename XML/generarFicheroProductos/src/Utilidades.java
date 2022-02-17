import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;

public class Utilidades {

    private static ArrayList<Producto> generarLista(){
        ArrayList<Producto> productos = new ArrayList<>();
        Producto p1 = new Producto(1,14,"Si", "morado", 156);
        Producto p2 = new Producto(2,68,"Puede ser", "rosita", 15);
        Producto p3 = new Producto(3,92," ", "rojo", 49);
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        return productos;
    }

    public static void generarDocumento(){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            doc.setXmlVersion("1.0");

            ArrayList<Producto> productos = generarLista();
            Element elClientes = doc.createElement("productos");
            doc.appendChild(elClientes);

            for (Producto p : productos) {
                Element eleProducto = doc.createElement("producto");
                eleProducto.setAttribute("id", String.valueOf(p.getId()));
                Element eleStock = doc.createElement("stock");
                eleStock.appendChild(doc.createTextNode(String.valueOf(p.getStock())));
                Element eleCaracteristicas = doc.createElement("caracteristicas");
                eleCaracteristicas.appendChild(doc.createTextNode(p.getCaracteristicas()));
                eleCaracteristicas.setAttribute("color", p.getColor());
                eleCaracteristicas.setAttribute("peso", String.valueOf(p.getPeso()));
                eleProducto.appendChild(eleStock);
                eleProducto.appendChild(eleCaracteristicas);
                elClientes.appendChild(eleProducto);
            }

            DOMSource domSource = new DOMSource(doc);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");
            StreamResult sr = new StreamResult("./productos.xml");
            transformer.transform(domSource, sr);
        } catch (
                ParserConfigurationException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
