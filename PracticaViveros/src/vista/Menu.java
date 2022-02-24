package vista;

import modelo.clasesBasicas.Factura;
import modelo.clasesBasicas.personas.Cliente;
import modelo.clasesBasicas.personas.UsuarioGestor;
import modelo.clasesBasicas.personas.UsuarioVendedor;
import modelo.clasesBasicas.productos.Producto;
import modelo.clasesBasicas.productos.ProductoJardineria;
import modelo.clasesBasicas.productos.ProductoPlanta;

import java.util.List;

public class Menu {
    //Constantes
    public final static String PEDIR_HOST = "Introduzca el host: ";
    public final static String PEDIR_PUERTO = "Introduzca el puerto: ";
    public final static String PEDIR_USUARIO = "Introduzca el usuario: ";
    public final static String PEDIR_CONTRASENHA = "Introduzca la contrasenha: ";
    public final static String PEDIR_BBDD = "Introduzca una base de datos de tu host(no sera modificada): ";
    public final static String MENU_CONSULTAS = "Qué desea consultar: " +"\n"+
            "1. Informe de ventas del mes." +"\n"+
            "2. Informe de ventas del anho." +"\n"+
            "3. Productos." +"\n"+
            "4. Clientes." +"\n"+
            "5. Vendedores." +"\n"+
            "6. Gestores." +"\n"+
            "7. Facturas de un cliente.";
    public final static String PEDIR_CLIENTE = "Introduzca el dni del ciente: ";
    public final static String PEDIR_MES = "Introduzca el mes que desea consultar: ";
    public final static String PEDIR_ANHO = "Introduzca el anho que desea consultar: ";
    public final static String CLIENTE_INCORRECTO = "Cliente no encontrado, introduzca otro";

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

    public static String menuPedirDniCliente(){
        System.out.println(PEDIR_CLIENTE);
        return validaciones.pedirString();
    }

    public static void clienteIncorrecto(){
        System.out.println(CLIENTE_INCORRECTO);
    }

    public static int menu_consultas(){
        System.out.println(MENU_CONSULTAS);
        return validaciones.validarOpcionConsulta();
    }

    public static int pedirMes(){
        System.out.println(PEDIR_MES);
        return validaciones.validarMes();
    }

    public static int pedirAnho(){
        System.out.println(PEDIR_ANHO);
        return validaciones.pedirInt();
    }

    public static void mostrarListadoProductosJardineria(List<ProductoJardineria> listadoProductos){
        for (ProductoJardineria p:listadoProductos) {
            System.out.println(p.toString());
            System.out.println("\n");
        }
    }

    public static void mostrarListadoProductosPlanta(List<ProductoPlanta> listadoProductos){
        for (ProductoPlanta p:listadoProductos) {
            System.out.println(p.toString());
            System.out.println("\n");
        }
    }

    public static void mostrarListadoClientes(List<Cliente> listadoClientes){
        for (Cliente c:listadoClientes) {
            System.out.println(c.toString());
            System.out.println("\n");
        }
    }

    public static void mostrarListadoVendedores(List<UsuarioVendedor> listadoVendedores){
        for (UsuarioVendedor uv:listadoVendedores) {
            System.out.println(uv.toString());
            System.out.println("\n");
        }
    }

    public static void mostrarListadoGestores(List<UsuarioGestor> listadoGestores){
        for (UsuarioGestor ug:listadoGestores) {
            System.out.println(ug.toString());
            System.out.println("\n");
        }
    }

    public static void mostrarFacturasClienteConcreto(List<Factura> listadoFacturas){
        for (Factura factura:listadoFacturas) {
            System.out.println(factura.toString());
        }
    }

}
