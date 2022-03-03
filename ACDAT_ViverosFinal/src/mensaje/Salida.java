package mensaje;

import entidades.*;

import java.util.ArrayList;
import java.util.List;

public class Salida {
    public static final String INSERTE_NUMERO_DEL_0_AL_1="Introduzca un numero del 0 al 1";
    public static final String INSERTE_NUMERO_DEL_0_AL_2="Introduzca un numero del 0 al 2";
    public static final String INSERTE_NUMERO_DEL_0_AL_3="Introduzca un numero del 0 al 3";
    public static final String INSERTE_NUMERO_DEL_0_AL_4="Introduzca un numero del 0 al 4";
    public static final String INSERTE_NUMERO_DEL_0_AL_7="Introduzca un numero del 0 al 7";
    public static final String CANCELAR_FACTURA="Factura cancelada, volviendo al menu anterior";
    public static final String MENSAJE_PEDIR_USUARIO="Introduzca el usuario de la conexión";
    public static final String MENSAJE_PEDIR_CONTRASENYA="Introduzca la contraseña de la conexión";
    public static final String MENSAJE_PEDIR_SERVIDOR_BBDD="Introduzca el nombre del servidor de la Base de Datos";
    public static final String MENSAJE_PEDIR_PUERTO="Introduzca el puerto de conexión de la BBDD";
    public static final String MENSAJE_ERROR_NUMERO_NO_VALIDO="El número introducido no es un número, o no es un número válido";
    public static final String MENSAJE_ERROR_GENERICO_BBDD="Ha habido un problema con la conexión a realizar o con la instrucción introducida";
    public static final String MENSAJE_ERROR_FICHERO="Fichero no encontrado, o ha habido algun problema con él";
    public static final String MENSAJE_BIENVENIDA="Bienvenido al software de gestión de viveros";
    public static final String LOGIN_PEDIR_NOMBREUSUARIO="Introduzca su nombre de usuario:";
    public static final String LOGIN_PEDIR_CONTRASENYA="Introduzca su contraseña";
    public static final String MENSAJE_PEDIR_IDPEDIDO="Introduzca el id del pedido del que desea crear factura";
    public static final String USUARIO_NO_ENCONTRADO = "Los datos introducidos no corresponden con ningun usuario. Intentelo de nuevo.";
    public static final String PEDIR_NOMBRE = "\nIntroduzca su nombre:";
    public static final String PEDIR_DNI = "\nIntroduzca el DNI:";
    public static final String PEDIR_TELEFONO = "\nIntroduzca su telefono:";
    public static final String PEDIR_DIRECCION = "\nIntroduce su direccion";
    public static final String PEDIR_CORREO = "\nIntroduzca su correo:";
    public static final String PEDIR_CONTRASENA = "\nIntroduzca su contraseña:";
    public static final String PEDIR_CIUDAD = "\nIntroduzca su ciudad:";
    public static final String PEDIR_CODIGO_POSTAL = "\nIntroduzca su código postal:";
    public static final String ERROR= "\nEste campo no es válido.";
    public static final String PEDIR_ID = "\nIntroduce el id.";
    public static final String PEDIR_VALOR = "\nIntroduce un valor.";
    public static final String PEDIR_DESCRIPCION = "Introduce la descripción del producto.";
    public static final String PEDIR_CODIGO = "\nIntroduzca el codigo del producto.";
    public static final String PEDIR_PRECIO = "\nIntroduzca el precio unitario del producto.";
    public static final String PEDIR_UNIDADES = "\nIntroduzca las unidades disponibles del producto.";
    public static final String PEDIR_MES = "Introduza el número correspondiente al mes del que desea el informe";
    public static final String PEDIR_ANYO = "Introduza el número correspondiente al anyo del que desea el informe";
    public static final String PEDIR_CODIGO_PRODUCTO = "Introduzca el codigo del producto.";
    public static final String PEDIR_CANTIDAD_PRODUCTO = "Introduzca la cantidad que desea del producto";
    public static final String FALLO_CANTIDAD = "No hay suficientes productos en el almacen para satisfacer sus necesidades. Sentimos las molestias";
    public static final String FACTURA_INTRODUCIDA_EXITO = "La factura ha sido creada con éxito";
    public static final String PEDIR_CONFIRMACION_FACTURA = "Si desea confirmar la factura pulse 1, si prefiere cancelarla puse 2";
    public static final String FACTURA_CANCELADA = "Factura cancelada";

    public static void mostrarColumnasCliente(){
        System.out.println("""
            
            -------------------------------------
            Seleccione un atributo del cliente:
            
            1.- Direccion.
            2.- Codigo Postal.
            3.- Ciudad.
            4.- Telefono.
            5.- Correo.
            """);
    }
    public static void mostrarColumnasProducto(){
        System.out.println("""
            
            -------------------------------------
            Seleccione un atributo del producto:
            
            1.- Descripcion.
            2.- Precio Unitario.
            3.- Unidades Disponibles.
            """);
    }
    public static void mostrarColumnasVendedor(){
        System.out.println("""
            
            -------------------------------------
            Seleccione un atributo del vendedor:
            
            1.- Direccion.
            2.- Codigo Postal.
            3.- Ciudad.
            4.- Telefono.
            5.- Correo.
            6.- Usuario.
            7.- Contrasena.
            """);
    }
    /**
     * Cabecera: public static void mostrarMenu()
     *
     * Descripcion: Este método se encarga de mostrar por pantalla el menú dle programa.
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Muestra el menú por pantalla
     *
     */
    public static void mostrarMensajeBienvenida(){
        System.out.println("""
                ----------------------------------------
                Bienvenido al programa de gestion de la base de datos Vivero
                Su creador, Pedro Pastor, le desea una buena experiencia.
                Por favor, inicie sesion para continuar
                ----------------------------------------""");
    }
    /**
     * Cabecera: public static void mostrarMenuVendedor()
     *
     * Descripcion: Este método se encarga de mostrar por pantalla el menú del programa si eres vendedor.
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Muestra el menú por pantalla
     *
     */
    public static void mostrarMenuVendedor(){
        System.out.println("""
                ----------------------------------------
                Bienvenido al menú de vendedor
                Que desea hacer:
                1.- Realizar Venta
                ____________________
                0.- Salir
                ----------------------------------------
                """);
    }
    /**
     * Cabecera: public static void mostrarMenuFactura()
     *
     * Descripcion: Este metdo se encarga de mostrar por pantalla el menu para hacer una factura.
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Muestra el menu por pantalla
     */
    public static void mostrarMenuFactura(){
        System.out.println("""
                ----------------------------------------
                1.- Anyadir Producto
                2.- Generar Factura
                ____________________
                0.- Salir
                ----------------------------------------
                """);
    }
    public static void indicarInformacionParaIntroducirCliente(){
        System.out.println("""
                Por favor, introduzca el DNI o el telefono del cliente al que desea asignar la venta.
                En caso de querer atribuirsela al invitado escriba:
                DNI: 30012456D o Telefono: 654070809
                """);
    }
    public static void mostrarMenuGestor(){
        System.out.println("""
                        
            ----------------------------------------
            ¡Bienvenido Gestor! ¿Qué desea hacer?
            
            1.- Insertar datos.
            2.- Modificar datos.
            3.- Eliminar datos.
            4.- Consultas y Otras operaciones
            0.- Salir.
            """);
    }
    public static void mostrarMenuInsertar(){
        System.out.println("""
                        
            ----------------------------------------
            ¡Bienvenido Gestor! ¿Qué desea insertar?
            
            1.- Insertar Vendedor.
            2.- Insertar Cliente.
            3.- Insertar Producto.
            4.- Insertar Gestor
            0.- Salir.
            """);
    }
    public static void mostrarMenuEliminar(){
        System.out.println("""
                        
            ----------------------------------------
            ¡Bienvenido Gestor! ¿Qué desea insertar?
            
            1.- Eliminar Vendedor.
            2.- Eliminar Cliente.
            3.- Eliminar Producto.
            4.- Eliminar Gestor.
            5.- Eliminar Factura.
            0.- Salir.
            """);
    }
    public static void mostrarMenuModificar(){
        System.out.println("""
                        
            ----------------------------------------
            ¡Bienvenido Gestor! ¿Qué desea insertar?
            
            1.- Modificar Vendedor.
            2.- Modificar Cliente.
            3.- Modificar Producto.
            4.- Modificar Gestor
            0.- Salir.
            """);
    }
    public static void mostrarMenuConsultas(){
        System.out.println("""
            Qué desea consultar:\s
            1. Informe de ventas del mes.
            2. Informe de ventas del anho.
            3. Productos.
            4. Clientes.
            5. Vendedores.
            6. Gestores.
            7. Facturas de un cliente.
            0. Salir.""");
    }
    /**
     * Cabecera: public static void mostrarString(String string)
     *
     * Descripción: Este metodo se encarga de mostrar por pantalla una string
     * que le pase por parámetro.
     *
     * Precondiciones:Ninguna
     * Postcondiciones:Muestra por pantalla la string.
     *
     * @param string String
     */
    public static void mostrarString(String string){
        System.out.println(string);
    }

    public static void errorInesperado(){
        System.out.println("Ha ocurrido un error inesperado, contacte con su Antonio mas cercano");
    }
    /**
     * <b>Cabecera: </b>private static void mostrarInformeMensual(String consulta)</br>
     * <b>Description: </b>Metodo para mostrar el informe por pantalla</br>
     *
     * @param consulta
     */
    public static void mostrarInformeMensual(String consulta){
        String [] atributos;

        atributos = consulta.split("_");
        System.out.println("Informe del mes de " + getMonth(Integer.parseInt(atributos[0])));
        System.out.println("Informe de ventas de productos plantas: " + atributos[1]);
        System.out.println("Informe de ventas de productos jardineria: " + atributos[2]);
        System.out.println("Informe de ventas totales: " + atributos[3]);
        System.out.println("\n");
    }
    /**
     *  <b>Cabecera: </b> private static String getMonth(int mes)</br>
     *  <b>Description: </b>Metodo para mostrar el mes con letras </br>
     * @param mes
     * @return
     */
    private static String getMonth(int mes){
        String cadenaMes = " ";

        switch (mes){
            case 1 -> cadenaMes = "Enero";
            case 2 -> cadenaMes = "Febrero";
            case 3 -> cadenaMes = "Marzo";
            case 4 -> cadenaMes = "Abril";
            case 5 -> cadenaMes = "Mayo";
            case 6 -> cadenaMes = "Junio";
            case 7 -> cadenaMes = "Julio";
            case 8 -> cadenaMes = "Agosto";
            case 9 -> cadenaMes = "Septiembre";
            case 10 -> cadenaMes = "Octubre";
            case 11 -> cadenaMes = "Noviembre";
            case 12 -> cadenaMes = "Diciembre";
        }
        return cadenaMes;
    }
    /**
     * <b>Cabecera: </b>private static void mostrarInformeAnual(String consulta)</br>
     * <b>Description: </b>Metodo para mostrar el informe por pantalla</br>
     *
     * @param consulta
     */
    public static void mostrarInformeAnual(String consulta){
        String [] atributos;

        atributos = consulta.split("_");
        System.out.println("Informe del anual de " + atributos[0]);
        System.out.println("Informe de ventas de productos plantas: " + atributos[1]);
        System.out.println("Informe de ventas de productos jardineria: " + atributos[2]);
        System.out.println("Informe de ventas totales: " + atributos[3]);
        System.out.println("\n");
    }
    public static void mostrarListadoProductosJardineria(List<ProductoJardineria> listadoProductos){
        System.out.println("\n");
        System.out.println("Productos: ");
        for (ProductoJardineria p:listadoProductos) {
            System.out.println(p.toString());
        }
    }

    public static void mostrarListadoProductosPlanta(List<ProductoPlanta> listadoProductos){
        for (ProductoPlanta p:listadoProductos) {
            System.out.println(p.toString());
        }
        System.out.println("\n");
    }
    public static void mostrarListadoClientes(List<Cliente> listadoClientes){
        System.out.println("\n");
        System.out.println("Clientes: ");
        for (Cliente c:listadoClientes) {
            System.out.println(c.toString());
        }
        System.out.println("\n");
    }
    public static void mostrarListadoVendedores(List<Vendedor> listadoVendedores){
        System.out.println("\n");
        System.out.println("Vendedores: ");
        for (Vendedor uv:listadoVendedores) {
            System.out.println(uv.toString());
        }
        System.out.println("\n");
    }
    public static void mostrarListadoGestores(List<Gestor> listadoGestores){
        System.out.println("\n");
        System.out.println("Gestores: ");
        for (Gestor ug:listadoGestores) {
            System.out.println(ug.toString());
        }
        System.out.println("\n");
    }

    public static void mostrarFacturasClienteConcreto(List<Factura> listadoFacturas){
        System.out.println("\n");
        for (Factura factura:listadoFacturas) {
            System.out.println(factura.toString());
        }
        System.out.println("\n");
    }


    public static void mensajeMenuCliente() {
        System.out.println("""
                ----------------------------------------
                1.- Utilizar Cliente Invitado
                2.- Utilizar Cliente Personalizado
                ____________________
                0.- Salir
                ----------------------------------------
                """);
    }
    public static void mostrarFactura(int cliente, int vendedor, ArrayList<FacturaProducto> lista){
        System.out.println("Id de Cliente: "+cliente+".\n" +
                "Id de Vendedor: "+vendedor+".\n");
        for (int i=0; i<lista.size();i++){
            System.out.println("Codigo del producto: "+ lista.get(i).getCode()+"\n" +
                    "Cantidad: "+lista.get(i).getCantidad()+"\n" +
                    "Precio del producto: "+lista.get(i).getValorPrecio()+"\n" +
                    "Coste total: "+lista.get(i).getCoste()+"\n");
        }
    }
}
