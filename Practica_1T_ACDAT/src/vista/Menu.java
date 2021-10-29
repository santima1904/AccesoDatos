package vista;

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
}
