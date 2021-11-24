package vista2;

public class Menu {

    //Constantes
    public static final String MENU_PRINCIPAL = """
            Gestor de clientes:\s
            ----------------------------
            1. Nuevo cliente
            2. Consultar cliente
            3. Borrar cliente
            4. Configuración de exportación
            5. Exportar cliente
            0. Salir
            """;

    public static final String INSERTAR_CLIENTE = "Inserte un nuevo cliente: ";
    public static final String SALIR = "Desea salir: "+
            "\n"+"1. Sí"+
            "\n"+"2. No";

    //Métodos
    public static void menu(){
        System.out.println(MENU_PRINCIPAL);
    }

    public static void insertarCliente(){
        System.out.println(INSERTAR_CLIENTE);
    }

    public static void mostrarCliente(String cliente){
        System.out.println(cliente);
    }

    public static void salir(){
        System.out.println(SALIR);
    }

    public static void mostrarPersonaBorrada(String mensaje){
        System.out.println(mensaje);
    }
}
