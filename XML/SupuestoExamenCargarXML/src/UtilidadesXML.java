import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UtilidadesXML {

    private static final String TABULACION = "  ";

    public static DocumentBuilderFactory obtenerDocumentBuilderFactory(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringComments(true);
        dbf.setIgnoringElementContentWhitespace(true);
        return dbf;
    }

    public static Document obtenerDocument(DocumentBuilderFactory documentBuilderFactory){
        Document document = null;
        try{
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(new File(obtenerNombreFichero()));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    private static String obtenerNombreFicheroValido() {
        String nombreFichero = obtenerNombreFichero();
        while (!ficheroValido(nombreFichero)) {
            System.out.println("El ficheno no existe.");
            nombreFichero = obtenerNombreFichero();
        }
        return nombreFichero;
    }

    private static String obtenerNombreFichero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el nombre del fichero a mostrar:");
        String nomFich = scanner.nextLine();

        return nomFich;
    }

    private static boolean ficheroValido(String nombreFichero) {
        return new File(nombreFichero).exists();
    }

    public static void mostrarNodos(Document domDoc) {
        System.out.println("Clientes de la base de datos: ");
        mostrarTablaClientes(domDoc, 0);
    }

    private static void mostrarTablaClientes(Node node, int nivel) {
        NodeList nodosHijos = node.getChildNodes();
        for (int i = 0; i < nodosHijos.getLength(); i++) {
            mostrarNodo(nodosHijos.item(i), nivel + 1);
        }
    }

    private static void mostrarNodo(Node node, int nivel) {
        switch (node.getNodeType()) {
            case Node.ELEMENT_NODE:
                mostrarInformaciónElemento(node, nivel);
                break;
            case Node.TEXT_NODE:
                mostrarNodoTexto(node, nivel);
                break;
            default:
                System.out.println("(nodo de tipo: " + node.getNodeType() + ")");
        }
       mostrarTablaClientes(node, nivel);
    }

    private static void mostrarInformaciónElemento(Node node, int nivel) {
        imprimirTabulación(nivel);
        System.out.print("<" + node.getNodeName());
        mostrarAtributos(node);
        System.out.println(">");
    }

    private static void mostrarAtributos(Node node){
        NamedNodeMap listaAtr = node.getAttributes();
        for (int i = 0; i < listaAtr.getLength(); i++) {
            Node atr = listaAtr.item(i);
            System.out.print(" @" + atr.getNodeName() + "[" + atr.getNodeValue() + "]");
        }
    }

    private static void mostrarNodoTexto(Node node, int nivel) {
        String texto = node.getNodeValue();
        if (texto.trim().length() != 0) {
            imprimirTabulación(nivel);
            System.out.println(node.getNodeValue());
        }
    }

    private static void imprimirTabulación(int nivel){
        for (int i = 0; i < nivel; i++) {
            System.out.print(TABULACION);
        }
    }
}
