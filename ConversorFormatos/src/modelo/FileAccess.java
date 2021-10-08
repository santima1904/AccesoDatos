package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAccess {

    /**
     * Cabecera:   public void crearFichero(String nombre)
     * Descripcion: Metodo para crear un fichero con un nombre dado
     * Precondiciones: nombre no nulo
     * Postcondiciones: fichero creado
     *
     * @param nombre
     * @return file
     */
    public static File crearFichero(String nombre){

        File fichero = new File(nombre, ".");

        try {

            if (!fichero.exists()){
                fichero.createNewFile();
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return fichero;
    }


    /**
     * Cabecera: public static void escribir(String texto, File fichero)
     * Descripcion: Metodo para insertar texto en un fichero
     * Precondiciones: fichero creado
     * Entradas: String texto, File fichero
     * Salida: niunguna
     * Postcondiciones: Texto insertado en fichero
     *
     * @param texto, fichero, formato
     */
    public static void escribir(String texto, File fichero, String formato){

        try(OutputStreamWriter osw = new OutputStreamWriter((new FileOutputStream(fichero, true)), formato)) {

           osw.write(texto);

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    /**
     * Cabecera: public static List<String> leerLinea(File fichero)
     * Precondiciones: fichero creado
     * Entradas: File fichero
     * Salida: lista con el contenido del fichero
     * Postcondiciones: Devuelve una lista con el contenido para mostrarlo
     *
     * @param fichero, formato
     * @return  lista
     */

    public static List<String> leerLinea(File fichero, String formato){

        String linea = null;
        List<String > lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader((new FileInputStream(fichero)), formato)) ){


            do{
                linea = br.readLine();

                if(linea!=null){

                    lista.add(linea);
                }

            }while(linea!=null);

        } catch (IOException e) {
            e.printStackTrace();

        }

        return lista;
    }
}
