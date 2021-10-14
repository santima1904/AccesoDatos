package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAcccess {

    //Metodos

    /**
     * Cabecera: public static File generarFichero(String nombre)
     * Descripcion: Metodo para crear un fichero con un nombre dado
     *
     * @param nombre
     *
     * @return
     */
    public static File generarFichero(String nombre){

        File fichero = new File(nombre, ".");

        return fichero;
    }


    /**
     * Cabecera: public static void escribirSinBuffer()
     * Precondiciones: fichero creado
     * Entradas: String nombre
     * Salida: niunguna
     * Postcondiciones: Inserta dos lineas en el fichero
     */
    public static void escribirSinBuffer(File fichero, String cadena) {

        try {
            //Creo el fileWriter. Al poner append false, cada vez que se ejecute, se sobreescribe
            //Si lo pusiera en true, se ecribiria uno despues de otro
            FileWriter fw = new FileWriter(fichero, true);

            //Inserto la cadena escrita en el fichero
            fw.write(cadena);

            fw.write(System.lineSeparator());

            //Cerrar el fileWriter
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /**
     * Cabecera: public static void escribirBuffer(File fichero, String cadena)
     * Precondiciones: fichero creado
     * Entradas: String nombre
     * Salida: niunguna
     * Postcondiciones: Inserta dos lineas en el fichero
     */
    public static void escribirBuffer(File fichero, String cadena){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true))) {

            bw.write(cadena);

            bw.newLine();


        } catch (IOException e) {
            e.printStackTrace();

        }

    }


}
