package vista2;

import java.util.Scanner;

public class Validacion {

    //Constantes
    public static final String INSERTAR_NOMBRE = "Inserte el nombre: ";
    public static final String INSERTAR_APELLIDOS = "Inserte los apellidos: ";
    public static final String INSERTAR_DNI = "Inserte el dni: ";
    public static final String INSERTAR_TLFN = "Inserte el número de teléfono: ";
    public static final String INSERTAR_DIRECCION = "Inserte la dirección: ";
    public static final String FORMATO = "Inserte el formato: ";
    public static final int LONGITUDMAX_NOMBRE_APELLIDOS = 25;
    public static final int LONGITUDMAX_DIRECCION = 30;
    public static final int LONGITUDMAX_TELEFONO = 9;

    //Propiedades estáticas
    private static Scanner teclado = new Scanner(System.in);
    private static Scanner tecladoInt = new Scanner(System.in);

    //Métodos
    /**
     * <h1>Cabecera: </h1>public static String pedirNombre()<br/>
     * <h1>Descripción: </h1> Método para pedir y validar el nombre por teclado
     *                       El nombre debe tener una longitud menor que 25<br/>
     * <br/>
     */
    public static String pedirNombre(){
        String nombre;

        do{
            System.out.println(INSERTAR_NOMBRE);
            nombre = teclado.nextLine();
        }
        while(nombre.length()>LONGITUDMAX_NOMBRE_APELLIDOS);

        return nombre;
    }

    /**
     * <h1>Cabecera: </h1>public static String pedirApellidos()<br/>
     * <h1>Descripción: </h1> Método para pedir y validar los apellidos por teclado
     *                        El nombre debe tener una longitud menor que 25<br/>
     * <br/>
     */
    public static String pedirApellidos(){
        String apellidos;

        do{
            System.out.println(INSERTAR_APELLIDOS);
            apellidos = teclado.nextLine();
        }
        while(apellidos.length()>LONGITUDMAX_NOMBRE_APELLIDOS);

        return apellidos;
    }

    /**
     * <h1>Cabecera: </h1>public static String pedirDni()<br/>
     * <h1>Descripción: </h1> Método para pedir y validar el dni por teclado <br/>
     *                  El dni debe ser real(longitud 9)<br/>
     * <br/>
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
     * <h1>Cabecera: </h1>private static char calcularLetra(String dni)<br/>
     * <h1>Descripción: </h1> Método para calcular la letra correspondiente a la parte numérica del dni dado<br/>
     * <br/>
     */
    private static char calcularLetra(String dni){
        char[] caracteres = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int modulo= Integer.parseInt(dni)%23;

        return caracteres[modulo];
    }

    /**
     * <h1>Cabecera: </h1>public static String pedirTlfn()<br/>
     * <h1>Descripción: </h1> Método para pedir y validar el número de teléfono por teclado <br/>
     *                        El teléfono debe tener una longitud de 9<br/>
     * <br/>
     */
    public static String pedirTlfn(){
        String tlfn;

        do{
            System.out.println(INSERTAR_TLFN);
            tlfn = teclado.nextLine();
        }
        while(tlfn.length()!=LONGITUDMAX_TELEFONO||!validarTlfn(tlfn));

        return tlfn;
    }

    /**
     * <h1>Cabecera: </h1>public static String pedirDireccion()<br/>
     * <h1>Descripción: </h1> Método para pedir y validar la dirección por teclado
     *                        La dirección debe tener una longitud menor que 30<br/>
     * <br/>
     */
    public static String pedirDireccion(){
        String direccion;

        do{
            System.out.println(INSERTAR_DIRECCION);
            direccion = teclado.nextLine();
        }
        while(direccion.length()>LONGITUDMAX_DIRECCION);

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
     * <h1>Descripción: </h1> Método para pedir y validar la opción del menú por teclado, debe ser un número entre 0 y 5 <br/>
     * <br/>
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
     * <h1>Cabecera: </h1> public static boolean pedirSalir()<br/>
     * <h1>Descripción: </h1> Método para pedir y validar la opción del menú por teclado, debe ser 1 o 2 <br/>
     */
    public static boolean pedirSalir(){
        boolean salir = false;
        int numeroSalir;

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
     * <h1>Descripción: </h1> Método para pedir y validar el formato por teclado <br/>
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
