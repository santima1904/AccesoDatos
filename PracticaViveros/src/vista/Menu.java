package vista;

public class Menu {
    //Constantes
    public final static String PEDIR_HOST = "Introduzca el host: ";
    public final static String PEDIR_PUERTO = "Introduzca el puerto: ";
    public final static String PEDIR_USUARIO = "Introduzca el usuario: ";
    public final static String PEDIR_CONTRASENHA = "Introduzca la contrasenha: ";
    public final static String PEDIR_BBDD = "Introduzca una base de datos de tu host(no sera modificada): ";

    //Propiedades publicas
    public static Validaciones validaciones = new Validaciones();

    //Metodos
    public static String pedirHost(){
        System.out.println(PEDIR_HOST);
        return validaciones.pedirString();
    }

    public static String pedirPuerto(){
        System.out.println(PEDIR_PUERTO);
        return validaciones.pedirString();
    }

    public static String pedirUsuario(){
        System.out.println(PEDIR_USUARIO);
        return validaciones.pedirString();
    }

    public static String pedirContrasenha(){
        System.out.println(PEDIR_CONTRASENHA);
        return validaciones.pedirString();
    }

    public static String pedirBbdd(){
        System.out.println(PEDIR_BBDD);
        return validaciones.pedirString();
    }
}
