package modelo;

import modelo.conexionBBdd.MiConexion;

import java.io.*;

public class FileAccess {

    //Constantes
    public static final String NOMBRE_FICHERO = "configuracion.txt";

    //Métodos
    public static File crearFichero() {
        File fichero = new File(NOMBRE_FICHERO);

        try {
            fichero.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fichero;
    }

    /**
     * Cabecera: public static void escribirProducto()
     * Precondiciones: fichero creado
     * Entradas: producto p
     * Salida: niunguna
     * Postcondiciones: Inserta el objeto p en el fichero
     */
    public static void escribirFichero(File fichero, MiConexion oConexion) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(fichero, true));
            oos.writeObject(oConexion);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (oos != null) {
                cerrarObjectOutput(oos);
            }
        }
    }

    /**
     * Cabecera: public static void leerFichero()
     * Precondiciones: fichero creado
     * Entradas: ninguno
     * Salida: lista de objetos producto
     * Postcondiciones: Devuelve una lista con los contenidos de los objetos del fichero
     */
    public static MiConexion leerFichero(File fichero){
        MiConexion oconexion = null;

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            oconexion = (MiConexion) ois.readObject();
        }catch (EOFException end){
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return oconexion;
        }

    /**
     * Cabecera: private void cerrarObjectOutput(ObjectOutputStream oos)
     * Precondiciones: ObjectOutputStream credo
     * Entradas: ObjectOutputStream oos
     * Salida: niunguna
     * Postcondiciones: cierra el oos
     */
    private static void cerrarObjectOutput(ObjectOutputStream oos) {
        try {
            assert oos != null;
            oos.close();  // Se cierra al terminar.
        } catch (IOException e) {//si salta la excepcion  IOException
            e.printStackTrace();//muestro la excepcion
        }
    }

    /**
     * Cabecera: private void cerrarObjectOutput(ObjectOutputStream oos)
     * Precondiciones: ObjectOutputStream credo
     * Entradas: ObjectOutputStream oos
     * Salida: niunguna
     * Postcondiciones: cierra el oos
     */
    private static void cerrarObjectInput(ObjectInputStream ois) {
        try {
            assert ois != null;
            ois.close();  // Se cierra al terminar.
        } catch (IOException e) {//si salta la excepcion  IOException
            e.printStackTrace();//muestro la excepcion
        }
    }
}
