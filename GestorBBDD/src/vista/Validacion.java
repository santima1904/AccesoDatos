package vista;

import java.util.Scanner;

public class Validacion {

    public static Scanner teclado = new Scanner(System.in);

    public static int pedirOpcion(){
        return teclado.nextInt();
    }
}
