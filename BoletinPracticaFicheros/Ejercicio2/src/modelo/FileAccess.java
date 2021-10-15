package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAccess {


    /**
     * Cabecera: public static void crearFichero()
     * Precondiciones: ninguna
     * Entradas: String nombre
     * Salida: niunguna
     * Postcondiciones: fichero creaado
     */
    public static File crearFichero(String nombre){

        File fichero = new File (nombre);//introduzco el nombre del fichero a crear

        try {
            fichero.createNewFile();//creo el fichero

        } catch (IOException e) {
            e.printStackTrace();
        }

        return fichero;
    }


    /**
     * Cabecera: public static void escribirFichero(File fichero)
     * Precondiciones: fichero creado
     * Entradas: nada
     * Salida: niunguna
     * Postcondiciones: Inserta en el fichero los datos pedidos al principio del programa
     */
    public static void escribirFichero(File fichero, int numeroTlf) {

        try (DataOutputStream oos = new DataOutputStream(new FileOutputStream(fichero, true))){

            oos.writeInt(numeroTlf);


        } catch (IOException e) {//si salta la excepcion  IOException
            e.printStackTrace();//muestro la excepcion
        }

    }

    /**
     * Cabecera: public static List<Integer> leerNumeroEspecifico(File fichero)
     * Precondiciones: fichero creado
     * Entradas: File fichero
     * Salida: int [] numeros
     * Postcondiciones: Devuelve una lista con los enteros del fichero
     */
    public static List<Integer> leerNumeros(File fichero){
        List<Integer> numeros = new ArrayList<>();
        boolean finFichero = false;

        try (DataInputStream ois = new DataInputStream(new FileInputStream(fichero))){
            while(!finFichero){
                try{
                    numeros.add(ois.readInt());
                }catch (IOException e){
                    finFichero = true;
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        return numeros;
    }


}
