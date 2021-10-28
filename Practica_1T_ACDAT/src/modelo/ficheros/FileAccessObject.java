package modelo.ficheros;

import modelo.Cliente;

import java.io.*;

public class FileAccessObject {

    //Constantes
    public static final String FICHERO_CLIENTES = "clientes.bin";
    public static final String FICHERO_INDICE = "indice_clientes.bin";

    //Propiedades estáticas
    private static File ficheroClientes = new File(FICHERO_CLIENTES);
    private static File ficheroIndice = new File(FICHERO_INDICE);


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
       try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(ficheroClientes))){
           dos.writeBytes(cliente.toString());
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
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
    public static int buscarPosicion(String dni) {
        int contador = 0;
        boolean valido = false, salir = false;
        String linea;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroClientes)))) {
            try{
                while (!valido||!salir) {
                    linea = br.readLine();
                    valido = comprobarDni(linea, dni);
                    if (valido){
                        salir = true;
                    }
                    contador++;
                }
            }catch (EOFException e){
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
    private static void escribirFicheroIndice(String dni, int posicion){

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(ficheroIndice, false))){
            if (posicion != -1) {
                dos.write(posicion);
                dos.writeBytes("-" + dni);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        String linea, dniCliente;
        String[] atributosCliente;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroClientes)))) {
            try{
                while (!valido||!salir) {
                    linea = br.readLine();
                    atributosCliente = linea.split("-");
                    dniCliente = atributosCliente[1];
                    valido = comprobarDni(dniCliente, dni);
                    if (valido){
                        posicion = Integer.parseInt(atributosCliente[1]);
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
    public static String consultarCliente(int posicion) {
        String linea = null;
        int i = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroClientes)))) {
            try{
                for (i = 0;i == posicion;i++){
                    linea = br.readLine();
                }
            }catch (EOFException e){
                i =+ posicion;
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return linea;
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
