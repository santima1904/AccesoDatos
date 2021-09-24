package vista;

import clasesBasicas.FileAccess;

import java.io.File;
import java.util.Scanner;

public class Mensajes {
    //En esta clase va a haber tanto entradas como salidas por teclado

    //Constantes
    public static final String pedirRuta = "Indique la ruta por favor: ";
    public static final String esDierctorio = "+---";

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

        System.out.println(pedirRuta);

        return teclado.next();
    }


    /**
     * Prototipo:  public static void escribirListado(File[] ficheros)
     * Descripcion: Metodo para mostrar por pantalla el contenido del fichero o directorio segun las indicaciones
     * Precondiciones: ficheros diferente de null
     * Postcondiciones: texto mostrado por pantalla
     *
     * Entradas: File[] ficheros
     * Salidas: ninguna
     * @param ficheros
     */
    public static void escribirListado(File[] ficheros){

        for(File f: ficheros) {

            if (f.isFile()) {
                System.out.println(String.format("-%1s%2s%3s", FileAccess.puedeLeer(f), FileAccess.puedeEscribir(f), FileAccess.puedeEjecutar(f) ));
            }
            else{
                System.out.println(esDierctorio+f.getName());
                escribirListado(FileAccess.listarDirectorio(f.getPath()));
            }
        }


    }
}
