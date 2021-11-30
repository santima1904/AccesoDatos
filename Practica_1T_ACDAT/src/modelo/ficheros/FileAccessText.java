package modelo.ficheros;

import java.io.*;

public class FileAccessText{

    //Constantes
    public static final String FICHERO_PRINCIPAL = "configuracion.bin";
    public static final String FICHERO_TEXT = "listado_clientes.bin";

    //Propiedades estáticas
    public static File ficheroConfiguracion = new File(FICHERO_PRINCIPAL);
    public static File ficheroText = new File(FICHERO_TEXT);


    /**
     * <h1>Cabecera: </h1>public static void escribirCodificacionFichero(String codificacion)<br/>
     * <h1>Descripción: </h1> Método para escribir en el fichero de configuración la codificación introducida <br/>
     * <h1>Precondiciones: </h1>Fichero creado y cadena diferente de null <br/>
     * <h1>Postocondiciones: </h1>Cadena introducida en el fichero <br/>
     * <br/>
     * <h1>Entradas: </h1>String codificacion<br/>
     * <h1>Salidas: </h1>Ninguna <br/>
     * <br/>
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
     * <h1>Cabecera: </h1> public static void escribirClientesFichero(String cliente) <br/>
     * <h1>Descripción: </h1> Método para escribir en el fichero el cliente dado <br/>
     * <h1>Precondiciones: </h1>Fichero creado y cliente diferente de null <br/>
     * <h1>Postocondiciones: </h1> Cliente introducido en el fichero <br/>
     * <br/>
     * <h1>Entradas: </h1>String cliente<br/>
     * <h1>Salidas: </h1>Ninguna
     *
     * @param cliente
     */
    public static void escribirClientesFicheroExportado(String cliente) {
        try(OutputStreamWriter osw = new OutputStreamWriter((new FileOutputStream(ficheroText, true)), leerFicheroText())) {
                osw.write(cliente);
                osw.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <h1>Cabecera: </h1>public static void inicializarFicheroExportado()<br/>
     * <h1>Descripción: </h1> Metodo para ver si existe el fichero y sobrescribirlo o no <br/>
     *
     */
    public static void inicializarFicheroExportado(){
        try(OutputStreamWriter osw = new OutputStreamWriter((new FileOutputStream(ficheroText, false)))) {
            osw.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <h1>Cabecera: </h1>private static String leerFicheroText(File fichero)<br/>
     * <h1>Descripción: </h1> Método para leer el fichero de configuración <br/>
     *
     */
    private static String leerFicheroText(){
        String linea = null;

        try(BufferedReader br = new BufferedReader(new FileReader(ficheroConfiguracion))){
            linea = br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linea;
    }
}
