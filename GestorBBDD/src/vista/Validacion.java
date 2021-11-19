package vista;

import java.util.Scanner;

public class Validacion {

    public static Scanner teclado = new Scanner(System.in);
    public static Scanner tecladoString = new Scanner(System.in);

    public static int pedirOpcion(){
        return teclado.nextInt();
    }

    public static String pedirConsulta(){return tecladoString.next();}
}
