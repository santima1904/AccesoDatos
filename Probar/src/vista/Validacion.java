package vista;

import java.util.Scanner;

public class Validacion {
     public static Scanner teclado = new Scanner(System.in);

    /**
     * Prototipo: public static String pedirString()
     * Descripcion: Pide una cadena al usuario
     *
     * @return cadena
     */
    public static String pedirString(){
         String cadena;

         cadena = teclado.nextLine();

         return cadena;
    }
}
