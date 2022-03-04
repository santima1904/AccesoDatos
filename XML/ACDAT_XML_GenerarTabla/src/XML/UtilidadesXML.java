package XML;

import modelo.Cliente;
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

public class UtilidadesXML {

    private static final String TABULACION = "       ";
    private static final int LONGITUD =30;

    /**
     * Cabecera: public static void exportarXML(String nombreFichero, ArrayList<Producto> clientes)
     *
     * Descripcion: Este metodo se encarga de exportar los xml con el nombre dle fichero pasado por parametros
     * y una lista de clientes.
     * @param nombreFichero String
     * @param clientes ArrayList<Producto>
     */
    public static void exportarXML(String nombreFichero, ArrayList<Cliente> clientes){
        transformer(documentBuilder(clientes),nombreFichero);
    }

    /**
     * Cabecera: private static Document documentBuilder(ArrayList<Producto> clientes)
     *
     * Descripcion: Este metodo se encarga de generar el doc y de llamar al metodo para generar las etiquetas.
     *
     * Precondciiones: Ninguna
     * Postcondiciones: Devuelve el documento creado
     * @param clientes ArrayList<Productos>
     * @return Document doc
     */
    private static Document documentBuilder(ArrayList<Cliente> clientes){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;

        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = db.newDocument();
        doc.setXmlVersion("1.0");
        Element elClientes = doc.createElement("clientes");
        doc.appendChild(elClientes);
        Document docRelleno = generarEtiquetas(doc,elClientes,clientes);
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
    public static ArrayList<Cliente> parseXML(DocumentBuilder db, String nombreFichero){
        File file = new File(nombreFichero);
        Document document;
        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            document = db.parse(file);
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("cliente");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Cliente cliente = new Cliente(eElement.getAttribute("DNI"),
                            eElement.getElementsByTagName("nombre").item(0).getTextContent(),
                            eElement.getElementsByTagName("apellidos").item(0).getTextContent(),
                            eElement.getElementsByTagName("direccion").item(0).getTextContent(),
                            eElement.getElementsByTagName("CP").item(0).getTextContent());
                    clientes.add(cliente);
                }
            }
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }
    public static void mostrarTabla(ArrayList<Cliente> clientes){
        mostrarCabecera();
        for (Cliente c:clientes) {
            StringBuilder sb = new StringBuilder();
            sb.append(rellenarString(LONGITUD,c.getDni()));
            sb.append(TABULACION);
            sb.append(rellenarString(LONGITUD,c.getNombre()));
            sb.append(TABULACION);
            sb.append(rellenarString(LONGITUD,c.getApellidos()));
            sb.append(TABULACION);
            sb.append(rellenarString(LONGITUD,c.getDireccion()));
            sb.append(TABULACION);
            sb.append(rellenarString(LONGITUD,c.getCp()));
            System.out.println(sb);
        }
    }
    private static void mostrarCabecera(){
        StringBuilder sb = new StringBuilder();
        sb.append(rellenarString(LONGITUD,"DNI"));
        sb.append(TABULACION);
        sb.append(rellenarString(LONGITUD,"NOMBRE"));
        sb.append(TABULACION);
        sb.append(rellenarString(LONGITUD,"APELLIDOS"));
        sb.append(TABULACION);
        sb.append(rellenarString(LONGITUD,"DIRECCION"));
        sb.append(TABULACION);
        sb.append(rellenarString(LONGITUD,"CP"));
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
     * Cabecera: private static Document generarEtiquetas(Document doc,Element elProductos,ArrayList<Producto> clientes)
     *
     * Descripcion: Este metodo se encarga de generar las eqtiquetas en el Document pasado por parametros.
     *
     * Precondiciones: Ninguno
     *
     * Postcondiciones: Generas las etiquetas
     * @param doc Document
     * @param elProductos Element
     * @param clientes ArrayList<Producto>
     * @return Document doc
     */
    private static Document generarEtiquetas(Document doc,Element elProductos,ArrayList<Cliente> clientes){
        for (Cliente p : clientes) {
            Element elCliente = doc.createElement("cliente");
            elCliente.setAttribute("DNI",String.valueOf(p.getDni()));
            Element laNombre = doc.createElement("nombre");
            laNombre.appendChild(doc.createTextNode(p.getNombre()));
            elCliente.appendChild(laNombre);
            Element elApellidos = doc.createElement("apellidos");
            elApellidos.appendChild(doc.createTextNode(p.getApellidos()));
            elCliente.appendChild(elApellidos);
            Element elDireccion = doc.createElement("direccion");
            elDireccion.appendChild(doc.createTextNode(p.getDireccion()));
            elCliente.appendChild(elDireccion);
            Element elCP = doc.createElement("CP");
            elCP.appendChild(doc.createTextNode(p.getCp()));
            elCliente.appendChild(elCP);
            elProductos.appendChild(elCliente);
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
