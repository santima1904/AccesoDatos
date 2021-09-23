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
    public static boolean puedeLeer(File fich){

        return fich.canRead();
    }

    //Metodo para ver si se puede escribir
    public static boolean puedeEscribir(File fich){

        return fich.canWrite();
    }

    //Metodo para ver si se puede ejecutar
    public static boolean puedeEjecutar(File fich){

        return fich.canExecute();
    }




}
