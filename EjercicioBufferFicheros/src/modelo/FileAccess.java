package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAccess {

    //Propiedad estatica
    public static File fichero;


    //Metodos
    public static File crearFichero(String nombre){

        fichero = new File(nombre);

        return fichero;
    }


    /**
     * Cabecera: public static void escribirBuffer()
     * Precondiciones: fichero creado
     * Entradas: String nombre
     * Salida: niunguna
     * Postcondiciones: Inserta dos lineas en el fichero
     */
    public static void escribirBuffer(File fichero, String cadena){
        BufferedWriter bw = null;

        try {

            bw = new BufferedWriter(new FileWriter(fichero, true));

            bw.write(cadena);

            bw.newLine();


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
