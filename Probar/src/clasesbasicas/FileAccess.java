package clasesbasicas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAccess {

    public static File fichero;



    /**
     * Prototipo: public static File crearFichero(String nombre)
     * Precondiciones: nombre diferente de nulo
     * Entradas: String nombre
     * Salida: fichero creado con el nombre dado
     * Postcondiciones: fichero creado
     */
    public static File crearFichero(String nombre){
        boolean existe;

        return fichero = new File(nombre);

    }

    /**
     * Prototipo: public static void escribirFichero(File fichero, String cadena)
     * Precondiciones: fichero creado, cadena String válido
     * Entradas: File fichero, String cadena
     * Salida: niunguna
     * Postcondiciones: Se inserta la cadena en el fichero
     */
    public static void escribirFichero(File fichero, String cadena){

        BufferedWriter bw = null;

        try{

            bw = new BufferedWriter(new FileWriter(fichero, true));
            bw.write(cadena);


        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
