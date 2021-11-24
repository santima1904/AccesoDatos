package modelo.ficheros;

import java.io.*;
import java.util.List;

public class FileAccessText{

    //Constantes
    public static final String FICHERO_PRINCIPAL = "configuracion.bin";
    public static final String FICHERO_TEXT = "listado_clientes.bin";

    //Propiedades estáticas
    private static File ficheroConfiguracion = new File(FICHERO_PRINCIPAL);
    private static File ficheroText = new File(FICHERO_TEXT);


    /**
     * <h1>Cabecera: </h1> public static void inicializarFichero()<br/>
     * <h1>Descripción :</h1> Método para inicializar un fichero
     */
    public static void inicializarFichero() {

        try {
            ficheroConfiguracion.createNewFile();
            escribirCodificacionFichero("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <h1>Cabecera: </h1>public static void escribirCodificacionFichero(String codificacion)<br/>
     * <h1>Descripción: </h1> Método para escribir en el fichero dado la cadena introducida <br/>
     * <h1>Precondiciones: </h1>Fichero creado y cadena diferente de null <br/>
     * <h1>Postocondiciones: </h1>Cadena introducida en el fichero <br/>
     * <br/>
     * <h1>Entradas: </h1>String codificacion<br/>
     * <h1>Salidas: </h1>Ninguna
     *
     * @param codificacion
     */
    public static void escribirCodificacionFichero(String codificacion) {
        try(FileWriter fw = new FileWriter(ficheroConfiguracion, false)) {
            fw.write(codificacion);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <h1>Cabecera: </h1> public static void escribirClientesFichero(List<String> lista) <br/>
     * <h1>Descripción: </h1> Método para escribir en el fichero dado la lista de clientes <br/>
     * <h1>Precondiciones: </h1>Fichero creado y lista diferente de null <br/>
     * <h1>Postocondiciones: </h1>Lista introducida en el fichero <br/>
     * <br/>
     * <h1>Entradas: </h1>List(Cliente) lista<br/>
     * <h1>Salidas: </h1>Ninguna
     *
     * @param lista
     */
    public static void escribirClientesFichero(List<String> lista) {
        try(OutputStreamWriter osw = new OutputStreamWriter((new FileOutputStream(ficheroText, true)), leerFicheroText(ficheroConfiguracion))) {
            for (String cliente:lista){
                osw.write(cliente);
                osw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <h1>Cabecera: </h1>private static String leerFicheroText(File fichero)<br/>
     * <h1>Descripción: </h1> Método para leer el fichero de texto dado <br/>
     *
     * @param fichero
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
