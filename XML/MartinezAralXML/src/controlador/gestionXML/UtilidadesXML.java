package controlador.gestionXML;

import modelo.Producto;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class UtilidadesXML {

    private static final String TABULACION = "       ";
    private static final int LONGITUD =30;

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

    public static DocumentBuilder getDocumentBuilder(boolean ignorarComentarios, boolean ignorarEspaciosBlancos){
        DocumentBuilder db = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringComments(ignorarComentarios);
        dbf.setIgnoringElementContentWhitespace(ignorarEspaciosBlancos);
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return db;
    }
    public static ArrayList<Producto> parseXML(DocumentBuilder db, String nombreFichero){
        File file = new File(nombreFichero);
        Document document;
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            document = db.parse(file);
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("producto");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Producto producto = new Producto(Integer.parseInt(eElement.getAttribute("id")),
                            eElement.getElementsByTagName("descripcion").item(0).getTextContent(),
                            Double.parseDouble(eElement.getElementsByTagName("precio").item(0).getTextContent()),
                            Integer.parseInt(eElement.getElementsByTagName("stock").item(0).getTextContent()));
                    productos.add(producto);
                }
            }
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return productos;
    }
    public static void mostrarTabla(ArrayList<Producto> productos){
        mostrarCabecera();
        for (Producto p:productos) {
            StringBuilder sb = new StringBuilder();
            sb.append(rellenarString(LONGITUD,p.getDescripcion()));
            sb.append(TABULACION);
            sb.append(rellenarString(LONGITUD,String.valueOf(p.getPrecio())));
            sb.append(TABULACION);
            sb.append(rellenarString(LONGITUD,String.valueOf(p.getStock())));
            System.out.println(sb);
        }
    }
    private static void mostrarCabecera(){
        StringBuilder sb = new StringBuilder();
        sb.append(rellenarString(LONGITUD,"Descripcion"));
        sb.append(TABULACION);
        sb.append(rellenarString(LONGITUD,"Precio"));
        sb.append(TABULACION);
        sb.append(rellenarString(LONGITUD,"Stock"));
        System.out.println(sb);
    }

    /**
     * Cabecera: public static String rellenarString(int longitudDeseada,String cadena)
     * descripcion: Este metodo se encarga de rellenar una string con espacios según la longitud pasada por parámetros.
     * Precondiciones: Ninguna
     * Postcondiciones: Devuelve la string con la longitud deseada.
     *
     * @param longitudDeseada String
     * @param cadena String
     * @return String cadenaConLongitudDeseada
     */
    public static String rellenarString(int longitudDeseada,String cadena){
        while(cadena.length() < longitudDeseada){
            cadena += " ";
        }
        return cadena;
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
            Element laDescripcion = doc.createElement("descripcion");
            laDescripcion.appendChild(doc.createTextNode(p.getDescripcion()));
            elProducto.appendChild(laDescripcion);
            Element elPrecio = doc.createElement("precio");
            elPrecio.appendChild(doc.createTextNode(String.valueOf(p.getPrecio())));
            elProducto.appendChild(elPrecio);
            Element elStock = doc.createElement("stock");
            elStock.appendChild(doc.createTextNode(String.valueOf(p.getStock())));
            elProducto.appendChild(elStock);
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
