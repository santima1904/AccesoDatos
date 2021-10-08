package vista;

import java.util.List;
import java.util.Scanner;

public class Menu {

    //Propiedad estatica
    public static Scanner teclado = new Scanner(System.in);
    public static Scanner tecladoString = new Scanner(System.in);

    //Constantes
    public static final String MENU = """
            1. Crear fichero.
            2. Abrir fichero.
            0. Salir""";

    public static final String TITULO = "Conversor de formatos";
    public static final String NOMBRE = "Introduzca el nombre del fichero: ";
    public static final String TEXTO = "Introduzca el texto: ";
    public static final String FORMATO = """
            Seleccione formato:
            1. US-ASCII
            2. ISO-8859-1
            3. UTF-8
            4. UTF-16BE
            5. UTF-16LE
            6. UTF-16""";

    public static final String CAMBIO_FORMATO ="""  
            ¿Quiere cambiar el formato?:
            1. Si
            2. No""";



    /**
     * Cabecera: public static void menuPrincipal()
     * Descripcion: Muestra el mensaje de menu principal
     */
    public static void menuPrincipal(){

        System.out.println(TITULO);
        System.out.println(MENU);
    }


    /**
     * Cabecera: public static void cambiarFormato()
     * Descripcion: Muestra el mensaje de formato
     */
    public static void cambioFormato(){

        System.out.println(CAMBIO_FORMATO);

    }


    /**
     * Cabecera: public static String nombre()
     * Descripcion: recoge un String por pantalla
     */
    public static String nombre(){

        System.out.println(TITULO);
        System.out.println(NOMBRE);

        return  tecladoString.nextLine();
    }

    /**
     * Cabecera: public static String texto()
     * Descripcion: recoge un String por pantalla
     */
    public static String texto(){

        System.out.println(TEXTO);

        return  tecladoString.nextLine();
    }

    /**
     * Cabecera: public static int pedirInt()
     * Descripcion: recoge un int por pantalla
     */
    public static int pedirInt(){

        return  teclado.nextInt();
    }

    /**
     * Cabecera: public static String pedirFormato()
     * Descripcion: recoge un String por pantalla
     */
    public static String pedirFormato(){

        System.out.println(TITULO);
        System.out.println(FORMATO);

        return  tecladoString.nextLine();
    }

    /**
     * Cabecera: public static void mostrarLista()
     * Descripcion: muestra un mensaje con el contenido de la lista
     */
    public static void mostrarLista(List<String> lista){

        for (String contenido:lista) {
            System.out.println(contenido);
        }
    }


}
