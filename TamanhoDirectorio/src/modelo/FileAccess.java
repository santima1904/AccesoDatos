package modelo;

import vista.Menu;

import java.io.File;

public class FileAccess {

    public static File fich;

    private static int contadorFicheros;
    private static int contadorDirectorios;
    private static long tamanho;

    /**
     * Prototipo:  public static File[] listarDirectorio (String ruta)
     * Descripcion: Metodo para meter en una array el contenido de un directorio
     * Precondiciones: ruta cadena valida
     * Postcondiciones: array cargada con contenidos del directorio
     *
     * Entradas: File fich
     * Salidas: File[] ficheros
     *
     * @param fich
     */
    public static File[] listarDirectorio (File fich) {

        File [] ficheros = null;

        ficheros = fich.listFiles();

        return ficheros;
    }


    /**
     * Cabecera: public static int contarFicheros(File [] ficheros)
     * Descripcion: Metodo para contar ficheros del directorio
     * Precondiciones: ficheros diferente de null
     * Postcondiciones: numero de ficheros contados
     *
     * Entradas: File [] ficheros
     * Salida: ninguna
     *
     * @param ficheros
     */
    public static void contarFicheros(File [] ficheros){

        for (File fichero:ficheros) {
            if (fichero.isFile()){
               contadorFicheros++;
               tamanho += fichero.length();
            }
            if (fichero.isDirectory()){
                contadorDirectorios++;
                contarFicheros(listarDirectorio(fichero));
            }
        }
    }

    /**
     * Cabecera: public static void NexoConMenu()
     * Descripcion: Metodo para realizar la conexion con la clase menu
     *
     */
    public static void NexoConMenu(){

        Menu.mostrarNumDirectorios(contadorDirectorios);
        Menu.mostrarNumFicheros(contadorFicheros);
        Menu.mostrarTamanho(tamanho);

    }

}
