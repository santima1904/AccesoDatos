package vista;

import java.util.List;
import java.util.Scanner;

public class Menu {

    //Teclado
    public static Scanner tecladoString = new Scanner(System.in);
    public static Scanner tecladoInt = new Scanner(System.in);



    //Constantes
    public static final String PEDIR_TEXTO = "Introduzca el texto a escribir";
    public static final String PEDIR_NOMBRE = "Introduzca el nombre del fichero";
    public static final String SALIDA = "Hasta pronto ^^";
    public static final String ESPACIO = "------------------";
    public static final String MENU = "Bienvenido" +'\n'+
            "Que desea hacer?"+'\n'+
            "1. Generar fichero de texto"+'\n'+
            "2. Añadir texto"+'\n'+
            "3. Mostrar contenido fichero"+'\n'+
            "4. Salir";


    /**
     * Cabecera: public static void mostrarMenu()
     * Descripcion: Metodo para mostrar el menu principal
     *
     */
    public static void mostrarMenu(){

        System.out.println(MENU);

    }


    /**
     * Cabecera: public static String pedirTexto()
     * Descripcion: Metodo para pedir una cadena al usuario por pantalla
     *
     * @return
     */
    public static String pedirTexto(){

        System.out.println(PEDIR_TEXTO);

        return tecladoString.nextLine();
    }

    /**
     * Cabecera: public static String pedirTexto()
     * Descripcion: Metodo para pedir una cadena al usuario por pantalla
     *
     * @return
     */
    public static String pedirNombre(){

        System.out.println(PEDIR_NOMBRE);

        return tecladoString.nextLine();
    }

    /**
     * Cabecera: public static int pedirOpcion()
     * Descripcion: Metodo para pedir un int  al usuario por pantalla
     *
     * @return
     */
    public static int pedirOpcion(){

        return tecladoInt.nextInt();
    }


    /**
     * Cabecera: public static void salida()
     * Descripcion: Metodo para mostrar mensaje de despedida
     */
    public static void salida(){
        System.out.println(SALIDA);
    }

    /**
     * Cabecera: public static void mostrarLista(List <String> lista)
     * Descripcion: Metodo para mostrar una lista dada
     */
    public static void mostrarLista(List <String> lista){

        for (String linea:lista) {

            System.out.println(linea);

        }
    }

    /**
     * Cabecera: public static void espacioEntreOpciones()
     * Descripcion: Metodo para hacer el codigo mas estetico al dejar espacio entre opciones
     */
    public static void espacioEntreOpciones(){
        System.lineSeparator();
        System.out.println(ESPACIO);
        System.lineSeparator();
    }

}
