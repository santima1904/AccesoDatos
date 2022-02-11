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

public abstract class UtilidadesXML {

    /**
     * Cabecera: public static void exportarXML(String nombreFichero, ArrayList<Producto> productos)
     *
     * Descripcion: Este metodo se encarga de exportar los xml con el nombre dle fichero pasado por parametros
     * y una lista de productos.
     * @param nombreFichero String
     * @param productos ArrayList<Producto>
     */
    public static void exportarXML(String nombreFichero, ArrayList<Producto> productos){
        transformer(documentBuilder(productos),nombreFichero);
    }

    /**
     * Cabecera: private static Document documentBuilder(ArrayList<Producto> productos)
     *
     * Descripcion: Este metodo se encarga de generar el doc y de llamar al metodo para generar las etiquetas.
     *
     * Precondciiones: Ninguna
     * Postcondiciones: Devuelve el documento creado
     * @param productos ArrayList<Productos>
     * @return Document doc
     */
    private static Document documentBuilder(ArrayList<Producto> productos){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;

        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = db.newDocument();
        doc.setXmlVersion("1.0");
        Element elProductos = doc.createElement("productos");
        doc.appendChild(elProductos);
        Document docRelleno = generarEtiquetas(doc,elProductos,productos);
        return  docRelleno;
    }

    /**
     * Cabecera: private static Document generarEtiquetas(Document doc,Element elProductos,ArrayList<Producto> productos)
     *
     * Descripcion: Este metodo se encarga de generar las eqtiquetas en el Document pasado por parametros.
     *
     * Precondiciones: Ninguno
     *
     * Postcondiciones: Generas las etiquetas
     * @param doc Document
     * @param elProductos Element
     * @param productos ArrayList<Producto>
     * @return Document doc
     */
    private static Document generarEtiquetas(Document doc,Element elProductos,ArrayList<Producto> productos){
        for (Producto p : productos) {
            Element elProducto = doc.createElement("producto");
            elProducto.setAttribute("id",String.valueOf(p.getId()));
//            Element elId = doc.createElement("id");
//            elId.appendChild(doc.createTextNode(String.valueOf(p.getId())));
//            elProducto.appendChild(elId);
            Element laDescripcion = doc.createElement("descripcion");
            laDescripcion.appendChild(doc.createTextNode(p.getDescripcion()));
            elProducto.appendChild(laDescripcion);
            Element elPrecio = doc.createElement("precio");
            elPrecio.appendChild(doc.createTextNode(String.valueOf(p.getPrecio())));
            elProducto.appendChild(elPrecio);
            elProductos.appendChild(elProducto);
        }
        return doc;
    }

    /**
     * Cabecera: private static void transformer(Document doc, String nombreFichero)
     *
     * Descripcion: Este metodo se encarga de realizar el transformer con el document y el nombre del fichero.
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Transforma el document pasado a XML
     *
     * @param doc Document
     * @param nombreFichero String
     */
    private static void transformer(Document doc, String nombreFichero){
        try {
            DOMSource domSource = new DOMSource(doc);
            Transformer transformer = TransformerFactory.newInstance().
                    newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");
            StreamResult sr = new StreamResult(nombreFichero);
            transformer.transform(domSource, sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
