package vista2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {

    //Constantes
    public static final String INSERTAR_NOMBRE = "Inserte el nombre: ";
    public static final String INSERTAR_APELLIDOS = "Inserte los apellidos: ";
    public static final String INSERTAR_DNI = "Inserte el dni: ";
    public static final String INSERTAR_TLFN = "Inserte el número de teléfono: ";
    public static final String INSERTAR_DIRECCION = "Inserte la dirección: ";
    public static final String FORMATO = "Inserte el formato: ";

    //Propiedades estáticas
    private static Scanner teclado = new Scanner(System.in);
    private static Scanner tecladoInt = new Scanner(System.in);

    //Métodos
    /**
     * <h1>Cabecera: </h1>public static String pedirNombre()<br/>
     * <h1>Descripción: </h1> Método para pedir el nombre por teclado <br/>
     */
    public static String pedirNombre(){
        String nombre;

        do{
            System.out.println(INSERTAR_NOMBRE);
            nombre = teclado.nextLine();
        }
        while(nombre.length()>25);

        return nombre;
    }

    /**
     * <h1>Cabecera: </h1>public static String pedirApellidos()<br/>
     * <h1>Descripción: </h1> Método para pedir los apellidos por teclado <br/>
     */
    public static String pedirApellidos(){
        String apellidos;

        do{
            System.out.println(INSERTAR_APELLIDOS);
            apellidos = teclado.nextLine();
        }
        while(apellidos.length()>25);

        return apellidos;
    }

    /**
     * <h1>Cabecera: </h1>public static String pedirDni()<br/>
     * <h1>Descripción: </h1> Método para pedir el dni por teclado <br/>
     */
    public static String pedirDni(){
        String dni = " ";
        boolean valido = false;

       while(!valido){
           System.out.println(INSERTAR_DNI);
           dni = teclado.nextLine();
           if (dni.length() == 9) {
               if (dni.charAt(8) == calcularLetra(dni.substring(0, 8))) {
                   valido = true;
               }
           }
        }

        return dni;
    }

    /**
     * <h1>Cabecera: </h1>public static String pedirDni()<br/>
     * <h1>Descripción: </h1> Método para pedir el dni por teclado <br/>
     */
    private static char calcularLetra(String dni){
        char[] caracteres = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int modulo= Integer.parseInt(dni)%23;
        char letra = caracteres[modulo];

        return letra;
    }

    /**
     * <h1>Cabecera: </h1>public static String pedirTlfn()<br/>
     * <h1>Descripción: </h1> Método para pedir el número de teléfono por teclado <br/>
     */
    public static String pedirTlfn(){
        String tlfn;

        do{
            System.out.println(INSERTAR_TLFN);
            tlfn = teclado.nextLine();
        }
        while(tlfn.length()!=9&&validarTlfn(tlfn));

        return tlfn;
    }

    /**
     * <h1>Cabecera: </h1>public static String pedirDireccion()<br/>
     * <h1>Descripción: </h1> Método para pedir la dirección por teclado <br/>
     */
    public static String pedirDireccion(){
        String direccion;

        do{
            System.out.println(INSERTAR_DIRECCION);
            direccion = teclado.nextLine();
        }
        while(direccion.length()>30);

        return direccion;
    }

    /**
     * <h1>Cabecera: </h1>private static boolean validarTlfn(String numero)<br/>
     * <h1>Descripción: </h1> Método para validar la cadena con el número de teléfono dado <br/>
     * </br>
     * @param numero
     */
    private static boolean validarTlfn(String numero){
        boolean valido = true;

        try{
            Integer.parseInt(numero);
        }catch (NumberFormatException e){
            valido = false;
        }

        return valido;
    }

    /**
     * <h1>Cabecera: </h1>public static int pedirOpcion()<br/>
     * <h1>Descripción: </h1> Método para pedir la opción del menú por teclado <br/>
     */
    public static int pedirOpcion(){
        int opcion;

        do{
            opcion = tecladoInt.nextInt();
        }
        while(opcion < 0 || opcion > 5);

        return opcion;
    }

    /**
     * <h1>Cabecera: </h1>public static int pedirOpcion()<br/>
     * <h1>Descripción: </h1> Método para pedir la opción del menú por teclado <br/>
     */
    public static boolean pedirSalir(){
        boolean salir = false;
        int numeroSalir = 0;

        do{
            numeroSalir = tecladoInt.nextInt();
        }
        while(numeroSalir != 1 && numeroSalir != 2);

        if (numeroSalir == 1){
            salir = true;
        }
        return salir;
    }

    /**
     * <h1>Cabecera: </h1>public static String pedirFormato()<br/>
     * <h1>Descripción: </h1> Método para pedir el formato por teclado <br/>
     */
    public static String pedirFormato(){
        String formato = " ";

        while(!formato.equals("UTF-8")&&!formato.equals("ISO-8859-1")&&!formato.equals("US-ASCII")&&!formato.equals("UTF-16BE")&&!formato.equals("UTF-16LE")&&!formato.equals("UTF-16")){
            System.out.println(FORMATO);
            formato = teclado.nextLine();
        }

        return  formato;
    }
}
