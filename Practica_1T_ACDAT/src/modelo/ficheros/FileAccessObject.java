package modelo.ficheros;

import modelo.Cliente;

import java.io.*;

public class FileAccessObject {

    //Constantes
    public static final String FICHERO_CLIENTES = "clientes.bin";

    //Propiedades estáticas
    private static File ficheroClientes = new File(FICHERO_CLIENTES);


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
        ObjectOutputStream oos = null;//Instancio el ObjectOutputStream y lo pongo a nulo

        try {
            if (ficheroClientes.exists()){//si el fichero existe
                oos = new MyObjectOutPutStream(new FileOutputStream(ficheroClientes, true));//uso mi propio ObjectOutputStream para no sobreescribir los productos, simplemente añadirlos
            }else{
                ficheroClientes.createNewFile();//si no esta creado, lo creo
                oos = new ObjectOutputStream(new FileOutputStream(ficheroClientes, true));//uso el ObjectOutputStream de java para escribir en un fichero nuevo
            }
            oos.writeObject(cliente);//escribo el objeto en el fichero

        } catch (IOException e) {//si salta la excepcion  IOException
            e.printStackTrace();//muestro la excepcion
        }
        finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
    public static int buscarPosicion(String dni){
        int contador = 0;
        boolean valido = false;
        Object aux = new Object();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroClientes))){
            while (aux != null || !valido) {
                aux = ois.readObject();
                contador++;
                valido = comprobarDni((Cliente) aux, dni);
            }
            if (!valido){
                contador = -1;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contador;
    }

    /**
     * <h1>Cabecera: </h1>private static boolean comprobarDni(Cliente cliente, String dni)<br/>
     * <h1>Descripción: </h1> Método para comprobar que el dni dado y el del cliente coinciden<br/>
     * <br/>
     * <h1>Entradas: </h1>Cliente cliente, String dni<br/>
     * <h1>Salidas: </h1>boolean
     *
     * @param dni
     * @param cliente
     */
    private static boolean comprobarDni(Cliente cliente, String dni){
        boolean igual = false;

        if (cliente.getDni().equals(dni)){
            igual = true;
        }
        return igual;
    }
}
