package clasesBasicas;

import java.io.File;

public class FileAccess {

    public static File fich;


    /**
     * Prototipo:  public static File[] listarDirectorio (String ruta)
     * Descripcion: Metodo para meter en una array el contenido de un directorio
     * Precondiciones: ruta cadena valida
     * Postcondiciones: array cargada con contenidos del directorio
     *
     * Entradas: String ruta
     * Salidas: File[] ficheros
     *
     * @param ruta
     */
    public static File[] listarDirectorio (String ruta) {
        fich = new File(ruta);
        boolean fichero = false;
        File [] ficheros = null;

        ficheros = fich.listFiles();

        return ficheros;
    }


    /**
     * Prototipo:  public static String puedeLeer(File fich)
     * Descripcion: Metodo para comprobar si se puede leer el fichero
     * Precondiciones: fich tiene que ser un fichero
     * Postcondiciones: cadena modificada
     *
     * Entradas: File fich
     * Salidas: String puedeLeer
     *
     * @param fich
     */
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
