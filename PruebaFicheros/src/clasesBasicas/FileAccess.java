package clasesBasicas;

import java.io.File;

public class FileAccess {

    public static File fich;


    public static File[] listarDirectorio (String ruta) {
        fich = new File(ruta);
        boolean fichero = false;
        File [] ficheros = null;

        ficheros = fich.listFiles();

        return ficheros;
    }


    //Metodo para ver si se puede leer
    public static String puedeLeer(File fich){

        String puedeLeer = "_";

        if (fich.canRead()){
            puedeLeer = "R";
        }
        return puedeLeer;
    }

    //Metodo para ver si se puede escribir
    public static String puedeEscribir(File fich){

        String puedeEscribir= "_";

        if (fich.canWrite()){
            puedeEscribir= "W";
        }
        return puedeEscribir;
    }

    //Metodo para ver si se puede ejecutar
    public static String puedeEjecutar(File fich){

        String puedeEjecutar = "_";

        if (fich.canExecute()){
            puedeEjecutar = "X";
        }
        return puedeEjecutar;
    }




}
