package vista;

import java.util.Scanner;

public class Validacion {
     public static Scanner teclado = new Scanner(System.in);

    public static String pedirString (){
         String cadena;

         cadena = teclado.nextLine();

         return cadena;
    }
}
