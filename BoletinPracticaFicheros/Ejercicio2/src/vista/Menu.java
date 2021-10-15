package vista;

import java.util.List;
import java.util.Scanner;

public class Menu {

    //Constantes
    public static final String MENU_PRINCIPAL = "Menu principal: " +"\n"+
            "1. Añadir nuevo numero de telefono" +"\n"+
            "2. Buscar numero deseado" +"\n"+
            "3. Salir";

    public static final String SEPARACION = "-------------------------------";
    public static final String MOSTRAR_MOVILES = "Los moviles guardados son: ";
    public static final String PEDIR_INDICE = "Introduzca la posicion del numero a buscar: ";
    public static final String SALIDA = "Hasta pronto ^^";
    public static final String PEDIR_NUMERO = "Introduzca el numero de telefono: ";


    //Teclado
    public static Scanner teclado = new Scanner(System.in);
    public static Scanner tecladoString = new Scanner(System.in);


    //Metodos

    /**
     * Cabecera: public static void mostrarMenu()
     * Descripcion: Metodo para mostrar el menu principal
     *
     */
    public static void mostrarMenu(){

        System.out.println(MENU_PRINCIPAL);
        System.out.println(SEPARACION);

    }

    /**
     * Cabecera: public static void mostrarListaMovilesGuardados(List<Integer> lista)
     * Descripcion: Metodo para mostrar una lista dada
     */
    public static void mostrarMovilesGuardados(List<Integer> lista){

        int contador = 0;

        System.out.println(MOSTRAR_MOVILES);

        for (int numero:lista) {

            System.out.println(contador+". "+numero);
            contador++;
        }

        System.out.println(SEPARACION);
    }
    /**
     * Cabecera: public static void mostrarMovilBuscado(int numero)
     * Descripcion: Metodo para mostrar un int dado
     */
    public static void mostrarMovilBuscado(int numero){

        System.out.println(numero);
        System.out.println(SEPARACION);
    }



    /**
     * Cabecera: public static int pedirOpcion()
     * Descripcion: Metodo para pedir un int  al usuario por pantalla
     *
     * @return
     */
    public static int pedirOpcion(){

        return teclado.nextInt();
    }

    /**
     * Cabecera: public static int pedirNumeroTlf()
     * Descripcion: Metodo para pedir un int  al usuario por pantalla
     *
     * @return
     */
    public static int pedirNumeroTlf(){
        int numeroTlf = 0;

        numeroTlf = validarString(tecladoString.nextLine());

        return numeroTlf;
    }

    private static int validarString(String cadena){
        int numero = 0;

        try{
            numero = Integer.parseInt(cadena);
        }catch (NumberFormatException e){
            validarString(cadena);
        }
        return numero;
    }


    /**
     * Cabecera: public static void salida()
     * Descripcion: Metodo para mostrar mensaje de despedida
     */
    public static void salida(){
        System.out.println(SALIDA);
    }


    /**
     * Cabecera: public static int pedirIndice()
     * Descripcion: Metodo para pedir un int al usuario por pantalla
     *
     * @return int
     */
    public static int pedirIndice(){

        System.out.println(PEDIR_INDICE);

        return teclado.nextInt();
    }


}
