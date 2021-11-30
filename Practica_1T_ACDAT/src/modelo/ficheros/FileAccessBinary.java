package modelo.ficheros;

import modelo.clasesBasicas.Cliente;
import java.io.*;

public class FileAccessBinary {

    //Constantes
    public static final String FICHERO_CLIENTES = "clientes.bin";
    public static final String FICHERO_INDICE = "indice_clientes.bin";
    public static final String FICHERO_AUX = "fichero_aux.bin";
    public static final int LONGITUD_MAXIMA = 110;//Longitud máxma del cliente

    //Propiedades estáticas
    public static File ficheroClientes = new File(FICHERO_CLIENTES);
    public static File ficheroIndice = new File(FICHERO_INDICE);
    public static File ficheroAux = new File(FICHERO_AUX);


    /**
     * <h1>Cabecera: </h1>public static void escribirCliente(Cliente cliente)<br/>
     * <h1>Descripción: </h1> Método para escribir en el fichero el cliente dado <br/>
     * <h1>Precondiciones: </h1>Fichero creado y cliente diferente de null <br/>
     * <h1>Postocondiciones: </h1>Cliente introducido en el fichero clientes y en el de índice <br/>
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
        escribirFicheroIndice(cliente.getDni(), getLongitudFichero());
    }

    /**
     * <h1>Cabecera: </h1>public static void leerClientesFicheroIndiceEnAuxiliar()<br/>
     * <h1>Descripción: </h1> Método para guardar el contenido del fichero en un fichero auxiliar<br/>
     * <h1>Precondiciones: </h1>Fichero creado<br/>
     * <h1>Postocondiciones: </h1>Contenido insertado en el fichero<br/>
     * <br/>
     * <h1>Entradas: </h1>Ninguna<br/>
     * <h1>Salidas: </h1>Ninguna
     * <br/>
     */
    public static void leerClientesFicheroIndiceEnAuxiliar(){
        String linea;

        inicializarFichero(FICHERO_AUX);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FICHERO_INDICE)))) {
                do {
                    linea = br.readLine();
                    if (linea != null) {
                        escribirFichero(linea, FICHERO_AUX);
                    }
                } while (linea != null);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    /**
     * <h1>Cabecera: </h1>public static void exportarFicheroCliente()<br/>
     * <h1>Descripción: </h1> Método para escribir el contenido del fichero cliente en el fichero para exportar <br/>
     * <h1>Precondiciones: </h1>Ninguna<br/>
     * <h1>Postocondiciones: </h1>Contenido insertado en el fichero exportado<br/>
     * <br/>
     * <h1>Entradas: </h1>Ninguna<br/>
     * <h1>Salidas: </h1>Ninguna
     * <br/>
     */
    public static void exportarFicheroCliente(){
        String linea;

        FileAccessText.inicializarFicheroExportado();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FICHERO_INDICE)))) {
            do {
                linea = br.readLine();
                if (linea != null && comprobarPosicion(linea)) {
                   FileAccessText.escribirClientesFicheroExportado(buscarClientePorPosicion(Integer.parseInt(linea.substring(0,1))));
                }
            } while (linea != null);
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
    private static void escribirFichero(String cliente, String nombreFichero){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero, true))){
            bw.write(cliente);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <h1>Cabecera: </h1>public static void leerClientesFicheroAux(String dni)<br/>
     * <h1>Descripción: </h1> Método para leer el contenido del fichero auxciliar y escribirlo en el de índice <br/>
     * <h1>Precondiciones: </h1>dni diferente de null<br/>
     * <h1>Postocondiciones: </h1>Contenido del fichero auxiliar introducido en el de índice<br/>
     * <br/>
     * <h1>Entradas: </h1>String dni<br/>
     * <h1>Salidas: </h1>Ninguna<br/>
     * <br/>
     * @param dni
     */
    public static void leerClientesFicheroAux(String dni){
        String linea;
        inicializarFichero(FICHERO_INDICE);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FICHERO_AUX)))) {
            do {
                linea = br.readLine();
                if (linea != null) {
                    escribirFichero(encontrarDniBorrado(dni, linea), FICHERO_INDICE);
                }
            } while (linea != null);
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
    private static void inicializarFichero(String nombreFichero){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero, false))){
            bw.write("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * <h1>Cabecera: </h1>private static boolean comprobarPosicion(String linea)<br/>
     * <h1>Descripción: </h1> Método para comprobarla posicion de la linea dada <br/>
     *                        Si la posición es -1, devuelve un false <br/>
     * <br/>
     * @param linea
     * @return boolean
     */
    private static boolean comprobarPosicion(String linea){
        boolean valido = true;

        if (linea.startsWith("-1")) {
            valido = false;
        }

        return valido;
    }

        /**
     * <h1>Cabecera: </h1>private static int getLongitudFichero()<br/>
     * <h1>Descripción: </h1> Método para buscar la posición del cliente con el dni dado <br/>
     * <h1>Precondiciones: </h1>Fichero creado y dni diferente de null <br/>
     * <h1>Postocondiciones: </h1>Posicion encontrada<br/>
     * <br/>
     * <h1>Entradas: </h1>String dni <br/>
     * <h1>Salidas: </h1>int
     */
    private static int getLongitudFichero() {
        int contador = -1, numCliente = 1;
        boolean salir = false;
        String linea;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroClientes)))) {
                linea = br.readLine();
                while (linea.substring(LONGITUD_MAXIMA*numCliente) != null&&!salir) {
                    contador++;
                    numCliente++;
                }
        }catch (StringIndexOutOfBoundsException e){
                salir = true;
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


    private static String encontrarDniBorrado(String dni, String linea){
       String [] atributoscliente;

            atributoscliente = linea.split(",");
            if (comprobarDni(atributoscliente[1], dni)){
                linea = "-1"+","+dni;
            }
        return linea;
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
        String linea;
        String [] atributoscliente;

        try (BufferedReader br = new BufferedReader(new FileReader(ficheroIndice))) {
            try{
                while (!valido||!salir){
                    linea = br.readLine();
                    atributoscliente = linea.split(",");
                    valido = comprobarDni(atributoscliente[1], dni);
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
     * <h1>Cabecera: </h1>public static String buscarClientePorPosicion(int posicion)<br/>
     * <h1>Descripción: </h1> Método para buscar un cliente con la posicion dada en el ficherode clientes <br/>
     * <h1>Precondiciones: </h1>Fichero creado y posicion mayor que -1 <br/>
     * <h1>Postocondiciones: </h1>Cliente encontrado o mandar mensaje de no encontrado<br/>
     * <br/>
     * <h1>Entradas: </h1>String dni <br/>
     * <h1>Salidas: </h1>int
     *
     * @param posicion
     * @return String
     * */
    public static String buscarClientePorPosicion(int posicion){
        String cliente = null;
        String cadena =" ";

        if (posicion == -1){
            cadena = "No encontrado";
        }else {
            try (RandomAccessFile raf = new RandomAccessFile(ficheroClientes, "rws")) {
                raf.seek((long) posicion * LONGITUD_MAXIMA);
                cliente = raf.readLine();
                cadena = cliente.substring(0,LONGITUD_MAXIMA);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cadena;
    }

    /**
     * <h1>Cabecera: </h1>private static boolean comprobarDni(String dniCliente, String dni)<br/>
     * <h1>Descripción: </h1> Método para comprobar que el dni dado y el del cliente coinciden<br/>
     * <br/>
     * <h1>Entradas: </h1>String dniCliente, String dni<br/>
     * <h1>Salidas: </h1>boolean
     *
     * @param dni
     * @param dniCliente
     */
    private static boolean comprobarDni(String dniCliente, String dni) {
        boolean igual = false;

        if (dniCliente.equals(dni)) {
            igual = true;
        }
        return igual;
    }
}