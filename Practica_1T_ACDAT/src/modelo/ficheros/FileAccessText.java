package modelo.ficheros;

import modelo.Cliente;
import java.io.*;
import java.util.List;

public class FileAccessText{

    //Constantes
    public static final String FICHERO_PRINCIPAL = "configuracion.bin";

    /**
     * <h1>Cabecera: </h1>public void inicializarFichero()<br/>
     * <h1>Descripción :</h1> Método para crear un fichero
     */
    public static void inicializarFichero() {
        File ficheroconfiguracion = new File(FICHERO_PRINCIPAL, ".");

        try {
            ficheroconfiguracion.createNewFile();
            escribirCodificacionFichero("UTF-8", ficheroconfiguracion);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <h1>Cabecera: </h1>public static void escribirCodificacionFichero(String codificacion, File fichero)<br/>
     * <h1>Descripción: </h1> Método para escribir en el fichero dado la cadena introducida <br/>
     * <h1>Precondiciones: </h1>Fichero creado y cadena diferente de null <br/>
     * <h1>Postocondiciones: </h1>Cadena introducida en el fichero <br/>
     * <br/>
     * <h1>Entradas: </h1>String codificacion, File fichero <br/>
     * <h1>Salidas: </h1>Ninguna
     *
     * @param fichero
     * @param codificacion
     */
    public static void escribirCodificacionFichero(String codificacion, File fichero) {

        try(FileWriter fw = new FileWriter(fichero, false)) {
            fw.write(codificacion);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <h1>Cabecera: </h1>public static void escribirCodificacionFichero(String codificacion, File fichero, String formato)<br/>
     * <h1>Descripción: </h1> Método para escribir en el fichero dado la lista de clientes <br/>
     * <h1>Precondiciones: </h1>Fichero creado y lista diferente de null <br/>
     * <h1>Postocondiciones: </h1>Lista introducida en el fichero <br/>
     * <br/>
     * <h1>Entradas: </h1>List<Cliente> lista, File fichero, String formato <br/>
     * <h1>Salidas: </h1>Ninguna
     *
     * @param fichero
     * @param lista
     * @param formato
     */
    public static void escribirClientesFichero(List<Cliente> lista, File fichero, String formato) {

        try(OutputStreamWriter osw = new OutputStreamWriter((new FileOutputStream(fichero, true)), leerFicheroText(fichero))) {
            for (Cliente cliente:lista){
                osw.write(cliente.toString());
                osw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <h1>Cabecera: </h1>private static String leerFicheroText(File fichero)<br/>
     * <h1>Descripción: </h1> Método para leer el fichero de texto <br/>
     * <h1>Precondiciones: </h1>Fichero creado<br/>
     * <h1>Postocondiciones: </h1>Formato leido<br/>
     * <br/>
     * <h1>Entradas: </h1>File fichero<br/>
     * <h1>Salidas: </h1>String formato
     *
     * @param fichero
     * @return formato
     */
    private static String leerFicheroText(File fichero){
        String formato = null;

        try(BufferedReader br = new BufferedReader(new FileReader(fichero))){
            formato = br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return formato;
    }
}
