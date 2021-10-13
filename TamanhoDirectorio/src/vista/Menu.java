package vista;

import modelo.FileAccess;

import java.io.File;
import java.util.Scanner;

public class Menu {

    //Constantes
    public static final String PEDIR_RUTA = "Indique la ruta por favor: ";
    public static final String NUM_DIRECTORIOS = "El numero de directorios es: ";
    public static final String NUM_FICHEROS = "El numero de ficheros es: ";
    public static final String TAMANHO = "El tamaño de los ficheros es: ";

    //Atributos staticos
    public static Scanner teclado = new Scanner(System.in);


    /**
     * Prototipo:  public static String pedirRuta()
     * Descripcion: Metodo para recibir una cadena por teclado
     * Precondiciones: teclado declarado previamente en la clase
     * Postcondiciones: cadena recogida
     *
     * Entradas: ninguna
     * Salidas: ninguna
     *
     */
    public static String pedirRuta(){

        System.out.println(PEDIR_RUTA);

        return teclado.next();
    }


    /**
     * Cabecera: public static void escribirListado(File[] ficheros)
     * Descripcion: Metodo para mostrar una lista dada
     */
    public static void escribirListado(File[] ficheros, int contador){

        for(File f: ficheros){
            if (f.isFile()) {
                tabulaciones(contador);
                System.out.println("-"+f.getName());
                // System.out.println(String.format("-%1s%2s%3s",FileAccess.puedeLeer(f),FileAccess.puedeEscribir(f),FileAccess.puedeEjecutar(f)));
            } else {
                tabulaciones(contador);
                System.out.println(f);
                contador += 1;
                escribirListado(FileAccess.listarDirectorio(f), contador+1);
            }
        }

    }

    public static void tabulaciones(int contador){

        if (contador > 0) {
            for (int i = 0; i <= contador; i++) {
                System.out.print(" ");
            }
        }
    }

    /**
     * Cabecera: public static void mostrarNumDirectorios()
     * Descripcion: Metodo para mostrar el numero de directorios
     *
     * @param numDirectorios
     */
    public static void mostrarNumDirectorios(int numDirectorios){
        System.out.println(NUM_DIRECTORIOS+numDirectorios);
    }

    /**
     * Cabecera: public static void mostrarNumFicheros()
     * Descripcion: Metodo para mostrar el numero de ficheros
     *
     * @param numFicheros
     */
    public static void mostrarNumFicheros(int numFicheros){
        System.out.println(NUM_FICHEROS+numFicheros);
    }

    /**
     * Cabecera: public static void mostrarTamanho()
     * Descripcion: Metodo para mostrar el tamaño de los ficheros
     *
     * @param tamanho
     */
    public static void mostrarTamanho(long tamanho){
        System.out.println(TAMANHO+tamanho);
    }


}
