package vista;

import java.util.Scanner;

public class Menu {

    //Teclado
    public static Scanner teclado = new Scanner(System.in);

    //Constantes
    public static final String INTRODUCIR_NOMBRE = "Introduce el nombre del fichero";
    public static final String INTRODUCIR_TEXTO = "Introduce el texto a buscar";

    //Métodos

    public static void introducirNombre(){
        System.out.println(INTRODUCIR_NOMBRE);
    }

    public static void introducirTexto(){
        System.out.println(INTRODUCIR_TEXTO);
    }

    public static String pedirString(){

        return teclado.nextLine();
    }
}
