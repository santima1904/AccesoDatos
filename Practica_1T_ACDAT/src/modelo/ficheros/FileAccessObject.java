package modelo.ficheros;

import modelo.Cliente;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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


}
