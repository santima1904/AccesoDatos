package vista;

import modelo.conexionBBdd.MiConexion;

public class Menu {
    public static final String MENU = "Gestor de base de datos: " +"\n"+
            "1. Ejecutar consulta" +"\n"+
            "2. Ejecutar DML" +"\n"+
            "3. Ejecutar DDL" +"\n"+
            "4. Configurar conexion" +"\n"+
            "0. Salir";

    public static void salir(){
        System.out.println("Adioooos");
    }

    public static void menu(){
        System.out.println(MENU);
    }

    public static void mostarConsulta(String consulta){
        System.out.println(consulta);
    }

    public static void mostrarInt(int resultado){
        System.out.println("Filas afectadas: "+resultado);
    }

    public static void confirmarAccion(boolean realizado) {
        String mensaje = "Se ha realizado";
        if (realizado){
            mensaje = "No se ha realizado con exito";
        }
        System.out.println(mensaje);
    }

    public static void mostarContenidoFichero(MiConexion conexion){
        System.out.println(conexion);
    }
}
