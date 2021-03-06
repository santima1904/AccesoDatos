/**
 * Clase para pedir por teclado y validar los datos necesarios
 */
package vista;

import java.util.Scanner;

public class Validaciones {

    public static Scanner teclado = new Scanner(System.in);
    public static Scanner tecladoInt = new Scanner(System.in);

    /**
     * Metodo para pedir una cadena por teclado al usuario
     *
     * @return String
     */
    public String pedirString(){
        return teclado.nextLine();
    }

    /**
     * Metodo para pedir un entero por teclado al usuario
     *
     * @return int
     */
    public int pedirInt(){
        String cadena_entero = "";
        int entero = 0;
        boolean valido = false;

        while(!valido){
           cadena_entero = teclado.nextLine();
           try{
               entero = Integer.parseInt(cadena_entero);
               valido = true;
           }catch (NumberFormatException nfe){
               valido = false;
           }
        }
        return entero;
    }

    /**
     * Metodo para validar un mes introducido por el usuario
     *
     * @return int mes
     */
    public int validarMes(){
        int mes;

        do{
            mes = pedirInt();
        }while (mes<1||mes>12);

        return mes;
    }

    public int validarOpcionConsulta(){
        int opcion = 8;

        while(opcion<0 || opcion>7){
            opcion = tecladoInt.nextInt();
        }
        return opcion;
    }

    /**
     *
     * @return
     */
    public static boolean validarIdClientePorDni(int id){
        boolean valido = true;

        if (id == -1){
            Menu.clienteIncorrecto();
            valido = false;
           }

        return valido;
    }

}
