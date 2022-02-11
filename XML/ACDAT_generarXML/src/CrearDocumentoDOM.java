// Creación de árbol DOM añadiendo elementos y serialización una vez creado

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

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

    private static ArrayList<Producto> generarLista(){
        ArrayList<Producto> productos = new ArrayList<>();
        Producto p1 = new Producto("Casco","Soy un casco",10);
        Producto p2 = new Producto("Microfono","Soy un microfono",100);
        Producto p3 = new Producto("Patata","Soy una patata",1000);
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        return productos;
    }


    public static void main(String[] args) {

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            doc.setXmlVersion("1.0");

            ArrayList<Producto> productos = generarLista();

            Element elClientes = doc.createElement("productos");
            doc.appendChild(elClientes);


            for (Producto p : productos) {
                Element elCliente = doc.createElement("producto");
                Element elApell = doc.createElement("nombre");
                elApell.appendChild(doc.createTextNode(p.getNombre()));
                elCliente.appendChild(elApell);
                Element elValidez = doc.createElement("descripcion");
                elValidez.appendChild(doc.createTextNode(p.getDescripcion()));
                elCliente.appendChild(elValidez);
                Element elValidez2 = doc.createElement("precio");
                elValidez2.appendChild(doc.createTextNode(String.valueOf(p.getPrecio())));
                elCliente.appendChild(elValidez2);
                elClientes.appendChild(elCliente);
            }

            DOMSource domSource = new DOMSource(doc);
            Transformer transformer = TransformerFactory.newInstance().
                    newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");
            StreamResult sr = new StreamResult("./prueba3.xml");
            transformer.transform(domSource, sr);
        } catch (ParserConfigurationException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
