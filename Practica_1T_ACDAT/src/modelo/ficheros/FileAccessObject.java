package modelo.ficheros;

import modelo.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAccessObject {

    //Constantes
    public static final String FICHERO_CLIENTES = "clientes.bin";
    public static final String FICHERO_INDICE = "indice_clientes.bin";
    public static final String FICHERO_INDICE_AUX = "indice_aux.bin";
    public static final int LONGITUD_MAXIMA = 110;//Longitud máxma del cliente

    //Propiedades estáticas
    private static File ficheroClientes = new File(FICHERO_CLIENTES);
    private static File ficheroIndice = new File(FICHERO_INDICE);
    private static File ficheroIndiceAux = new File(FICHERO_INDICE_AUX);


    /**
     * <h1>Cabecera: </h1>public static void escribirCliente(Cliente cliente)<br/>
     * <h1>Descripción: </h1> Método para escribir en el fichero el cliente dado <br/>
     * <h1>Precondiciones: </h1>Fichero creado y cliente diferente de null <br/>
     * <h1>Postocondiciones: </h1>Cliente introducido en el fichero <br/>
     * <br/>
     * <h1>Entradas: </h1>List<Cliente>Cliente cliente <br/>
     * <h1>Salidas: </h1>Ninguna
     *
     * @param cliente
     */
    public static void escribirCliente(Cliente cliente){
       try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(ficheroClientes, true))){
           dos.write(cliente.toString().getBytes());
           //dos.writeBytes("\n");
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    /**
     * <h1>Cabecera: </h1>public static List<String> leerClientes()<br/>
     * <h1>Descripción: </h1> Método para guardar el contenido del fichero en una lista <br/>
     * <h1>Precondiciones: </h1>Fichero creado<br/>
     * <h1>Postocondiciones: </h1>Contenido insertado en la lista<br/>
     * <br/>
     * <h1>Entradas: </h1>Ninguna<br/>
     * <h1>Salidas: </h1>Ninguna
     *
     */
    public static List<String> leerClientes(boolean ficheroCliente){
        String linea;
        List<String> lista = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(elegirFichero(ficheroCliente))))) {
                do {
                    linea = br.readLine();
                    if (linea != null) {
                        lista.add(linea);
                    }
                } while (linea != null);
            } catch (IOException e) {
                e.printStackTrace();
            }

        return lista;
    }

    private static String elegirFichero(boolean ficheroCliente){
        String nombreFichero = " ";

         nombreFichero = (ficheroCliente) ? FICHERO_CLIENTES : FICHERO_INDICE;

        return nombreFichero;
    }

        /**
     * <h1>Cabecera: </h1>public static int buscarPosicion(String dni)<br/>
     * <h1>Descripción: </h1> Método para buscar la posición del cliente con el dni dado <br/>
     * <h1>Precondiciones: </h1>Fichero creado y dni diferente de null <br/>
     * <h1>Postocondiciones: </h1>Posicion encontrada<br/>
     * <br/>
     * <h1>Entradas: </h1>String dni <br/>
     * <h1>Salidas: </h1>int
     */
    public static int getLongitudFichero() {
        int contador = -1, numCliente = 1;
        boolean salir = false;
        String linea = "";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroClientes)))) {
            try{
                linea = br.readLine();
                while (linea.substring(LONGITUD_MAXIMA*numCliente) != null&&!salir) {
                    contador++;
                    numCliente++;
                }
            }catch (StringIndexOutOfBoundsException e){
                salir = true;
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return contador;
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
     * @return formato
     */
    public static void escribirFicheroIndice(String dni, int posicion){

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

    public static void borrarClienteFicheroIndice(String dni, List<String> listadoFicheroIndice){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroIndiceAux, true))){
            for (String linea:encontrarDniBorrado(dni,listadoFicheroIndice)) {
                bw.write(linea);
                bw.newLine();
            }
            ficheroIndice = ficheroIndiceAux;
            ficheroIndiceAux.delete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> encontrarDniBorrado(String dni, List<String> listadoFicheroIndice){
       String linea;
       String [] atributoscliente;
       List<String> listadoFiltrado = new ArrayList<>();

        for(int i = 0;i<listadoFicheroIndice.size();i++){
            linea = listadoFicheroIndice.get(i);
            atributoscliente = linea.split(",");
            if (comprobarDni(atributoscliente[1], dni)){
                linea = "-1"+","+dni;
            }
            listadoFiltrado.add(linea);
        }
        return listadoFiltrado;
    }

    /**
     * <h1>Cabecera: </h1>public static int buscarPosicion(String dni)<br/>
     * <h1>Descripción: </h1> Método para buscar la posición del cliente con el dni dado <br/>
     * <h1>Precondiciones: </h1>Fichero creado y dni diferente de null <br/>
     * <h1>Postocondiciones: </h1>Posicion encontrada<br/>
     * <br/>
     * <h1>Entradas: </h1>String dni <br/>
     * <h1>Salidas: </h1>int
     *
     * @param dni
     */
    public static int buscarPosicionFicheroIndice(String dni) {
        int posicion = -1;
        boolean valido = false, salir = false;
        String dniCliente, linea;
        String [] atributoscliente;

        try (BufferedReader br = new BufferedReader(new FileReader(ficheroIndice))) {
            try{
                while (!valido||!salir) {
                    linea = br.readLine();
                    atributoscliente = linea.split(",");
                    dniCliente = atributoscliente[1];
                    valido = comprobarDni(dniCliente, dni);
                    if (valido){
                        posicion = Integer.parseInt(atributoscliente[0]);
                        salir = true;
                    }
                }
            }catch (EOFException e){
                salir = true;
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return posicion;
    }

    /**
     *
     * @param posicion
     * @return
     */
    public static String buscarClientePorPosicion(int posicion){
        String cliente = null;

        try(RandomAccessFile raf = new RandomAccessFile(ficheroClientes, "rws")){
            raf.seek((long) posicion *LONGITUD_MAXIMA);
            cliente = raf.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cliente.substring(LONGITUD_MAXIMA);
    }

    /**
     * <h1>Cabecera: </h1>private static boolean comprobarDni(Cliente cliente, String dni)<br/>
     * <h1>Descripción: </h1> Método para comprobar que el dni dado y el del cliente coinciden<br/>
     * <br/>
     * <h1>Entradas: </h1>Cliente cliente, String dni<br/>
     * <h1>Salidas: </h1>boolean
     *
     * @param dni
     */
    private static boolean comprobarDni(String dniCliente, String dni) {
        boolean igual = false;

        if (dniCliente.equals(dni)) {
            igual = true;
        }
        return igual;
    }
}
