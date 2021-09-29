package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAccessText {

    //Propiedades estáticas
     public static  File fichero;


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

        fichero = new File(nombre, ".");

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


    /**
     * Cabecera: public static List<String> leerContenido(File fichero)
     * Precondiciones: fichero creado
     * Entradas: File fichero
     * Salida: Lista con el contenido del fichero
     * Postcondiciones: Devuelve una lista con el contenido del fichero
     */

    public static List<String> leerContenido(File fichero){

        BufferedReader br = null;
        String linea = null;
        List<String> lista = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(fichero));

            do{
                linea = br.readLine();

                if(linea!=null){
                    lista.add(linea);
                }

            }while(linea!=null);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return lista;
    }


}
