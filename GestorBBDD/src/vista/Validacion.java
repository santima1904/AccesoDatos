package vista;

import java.util.Scanner;

public class Validacion {

    public static Scanner teclado = new Scanner(System.in);
    public static Scanner tecladoString = new Scanner(System.in);

    public static final String PEDIR_CONSULTA = "Introduzca la consulta: ";
    public static final String CONTINUAR_CREANDO = "Desea continuar creando columnas? " +"\n"+
            "1. Si" +"\n"+
            "2. No";

    public static int pedirOpcion(){
        return teclado.nextInt();
    }

    public static String pedirConsulta(){
        System.out.println(PEDIR_CONSULTA);
        return tecladoString.nextLine();
    }

    public static int pedirContinuar(){
        System.out.println(CONTINUAR_CREANDO);
        return teclado.nextInt();
    }
}
