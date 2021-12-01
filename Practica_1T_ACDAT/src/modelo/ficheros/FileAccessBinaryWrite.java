package modelo.ficheros;

import modelo.clasesBasicas.Cliente;

import java.io.*;

public class FileAccessBinaryWrite {

    //Constantes
    public static final String FICHERO_CLIENTES = "clientes.bin";
    public static final String FICHERO_INDICE = "indice_clientes.bin";
    public static final String FICHERO_AUX = "fichero_aux.bin";

    //Propiedades estáticas
    public static File ficheroClientes = new File(FICHERO_CLIENTES);
    public static File ficheroIndice = new File(FICHERO_INDICE);
    public static File ficheroAux = new File(FICHERO_AUX);

    /**
     * <h1>Cabecera: </h1>public static void escribirCliente(Cliente cliente)<br/>
     * <h1>Descripción: </h1> Método para escribir en el fichero el cliente dado <br/>
     * <h1>Precondiciones: </h1>Fichero creado y cliente diferente de null <br/>
     * <h1>Postcondiciones: </h1>Cliente introducido en el fichero clientes y en el de índice <br/>
     * <br/>
     * <h1>Entradas: </h1>Cliente cliente <br/>
     * <h1>Salidas: </h1>Ninguna
     * <br/>
     *
     * @param cliente
     */
    public static void escribirCliente(Cliente cliente){
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(ficheroClientes, true))){
            dos.write(cliente.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        escribirFicheroIndice(cliente.getDni(), FileAccessBinaryRead.getLongitudFichero());
    }

    /**
     * <h1>Cabecera: </h1>private static void escribirFicheroIndice(String dni, int posicion)<br/>
     * <h1>Descripción: </h1> Método para escribir en el fichero de indice <br/>
     * <h1>Precondiciones: </h1>Fichero creado, dni distinto de null<br/>
     * <h1>Postcondiciones: </h1>dni y posicion escritos en el fichero indice<br/>
     * <br/>
     * <h1>Entradas: </h1>String dni, int posicion<br/>
     * <br/>
     *
     * @param dni
     * @param posicion
     */
    private static void escribirFicheroIndice(String dni, int posicion){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroIndice, true))){
            if (posicion != -1) {
                bw.write(posicion+","+dni);
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <h1>Cabecera: </h1>private static void escribirFichero(String cliente, String nombreFichero)<br/>
     * <h1>Descripción: </h1> Método para escribir la cadena dada en el fichero dado <br/>
     * <br/>
     * @param cliente
     * @param nombreFichero
     */
    public static void escribirFichero(String cliente, String nombreFichero){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero, true))){
            bw.write(cliente);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <h1>Cabecera: </h1>private static void inicializarFichero(String nombreFichero)<br/>
     * <h1>Descripción: </h1> Método para inicializar el fichero dado <br/>
     * <br/>
     * @param nombreFichero
     */
    public static void inicializarFichero(String nombreFichero){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero, false))){
            bw.write("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
