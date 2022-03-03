package gestion;

import dal.Conexion;
import dal.GestoraBdd;
import dal.cliente.ClienteDao;
import dal.factura.FacturaDao;
import dal.gestor.GestorDao;
import dal.producto.ProductoDao;
import dal.usuario.UsuarioDao;
import dal.vendedor.VendedorDao;
import entidades.*;
import enums.TipoPlanta;
import mensaje.Salida;
import validacion.Validacion;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gestora {
    /**
     * Cabecera: private static void empezar()
     *
     * Descripcion: Este metodo se encarga de mostrar el mensaje de bienvenida y crear la base de datos junto
     * al fichero de propiedades.
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Crea todos los datos necesarios para la ejecucion del programa correctamente.
     */
    private static void empezar(){
        Salida.mostrarMensajeBienvenida();
        if(Conexion.leerPropiedadesConexion().isEmpty()){
            Conexion.escribirPropiedadesConexion(Validacion.pedirUsuario(),Validacion.pedirContrasenya(),
                    Validacion.pedirServidorBbDd(),Validacion.pedirPuerto());
        }
        GestoraBdd.creacionBdd();
    }

    /**
     * Cabecera: public static void menuInicial()
     *
     * Descripcion: Este metodo se encarga de ejecutar el metodo inicial y hacer que el usuario inicie sesion.
     *
     * Precondiciones: Ninguna
     * Postcondiciones: El usuario inicia sesion en el programa.
     */
    public static void menuInicial(){
        boolean continuar;
        empezar();
        do{
            continuar = logIn();
        }while (continuar);
    }

    /**
     * Cabecera: public static boolean logIn()
     *
     * Descripcion: Este metodo se encarga de controlar si el usuario que intenta iniciar sesion es correcto,
     * y en caso afirmativo, de que tipo es.
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Muestra al usuario el mensaje correspondiente.
     * @return boolean usuarioNoEncontrado
     */
    public static boolean logIn(){
        int idVendedor;
        boolean usuarioNoEncontrado = false;
        String nombreUsuario = Validacion.pedirNombreUsuarioLogin();
        String contrasenyaUsuario = Validacion.pedirContrasenyaLogin();

        if(UsuarioDao.logInGestor(nombreUsuario,contrasenyaUsuario) != -1){
            controlarMenuGestor();
        }else{
            idVendedor = UsuarioDao.logInVendedor(nombreUsuario,contrasenyaUsuario);
            if (idVendedor != -1){
                controlarMenuVendedor(idVendedor);
            }else{
                Salida.mostrarString(Salida.USUARIO_NO_ENCONTRADO);
                usuarioNoEncontrado = true;
            }
        }
        return usuarioNoEncontrado;
    }
    /**
     * Cabecera:  public static void controlarMenuVendedor()
     *
     * Descripcion: Este metodo se encarga de controlar el menu correspondiente al Vendedor.
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Controla el menu del vendedor.
     */
    public static void controlarMenuVendedor(int idVendedor){
        int respuesta;

        do{
            Salida.mostrarMenuVendedor();
            respuesta = Validacion.validarNumero0al1();
            if(respuesta == 1){
                VendedorDao.generarFactura(idVendedor);
            }
        }while(respuesta !=0);
    }
    public static void controlarMenuGestor() {
        boolean seguir = true;
        int opcion;

        do {
            Salida.mostrarMenuGestor();
            opcion = Validacion.validarNumero0al4();
            switch (opcion) {
                case 1 -> menuIntroducir();
                case 2 -> menuModificar();
                case 3 -> menuEliminar();
                case 4 -> menuConsultasYOperaciones();
                case 0 -> seguir = false;
            }
        } while (seguir);
    }

    private static void menuConsultasYOperaciones() {
        boolean seguir = true;
        int opcion;

        do {
            Salida.mostrarMenuConsultas();
            opcion = Validacion.validarNumero0al7();
            switch (opcion) {
                case 1 -> informeMes(Validacion.validarMes());
                case 2 -> informeAnyo(Validacion.validarAnyo());
                case 3 -> {Salida.mostrarListadoProductosJardineria(ProductoDao.getListadoProductosJardineria());
                Salida.mostrarListadoProductosPlanta(ProductoDao.getListadoPlantasConTipo());}
                case 4 -> Salida.mostrarListadoClientes(ClienteDao.getListadoClientes());
                case 5 -> Salida.mostrarListadoVendedores(VendedorDao.getListadoVendedores());
                case 6 -> Salida.mostrarListadoGestores(GestorDao.getListadoGestores());
                case 7 -> Salida.mostrarFacturasClienteConcreto(FacturaDao.getFacturasCliente(Validacion.validarIdCliente()));
                case 0 -> seguir = false;
            }
        } while (seguir);
    }

    /**
     * <b>Cabecera: </b>public static int getIdClientePorDni(String dni)</br>
     * <b>Description: </b>Metodo para obtener el id de un cliente a partir de un dni dado</br>
     * <b>Precondiciones: </b>dni distinto de null</br>
     * <b>Postcondiciones: </b>id devuelto. Si es -1, el cliente no existe.</br>
     *
     * @param dni
     * @return int id
     */
    public static int getIdClientePorDni(String dni){
        int id = -1;
        boolean salir = false;
        List<Cliente> listadoClientes = ClienteDao.getListadoClientes();

        for (int i = 0;i<listadoClientes.size()&&!salir;i++){
            if (listadoClientes.get(i).getDni().equals(dni)){
                id = listadoClientes.get(i).getId();
                salir = true;
            }
        }
        return id;
    }

    private static void informeAnyo(int anyo) {
        String url = "EXEC GetInformeAnual ?";

        try(Connection conexion = Conexion.realizarConexion()){
            PreparedStatement st = conexion.prepareStatement(url);
            st.setInt(1, anyo);
            st.execute();
            ResultSet rs = st.getResultSet();
            recogerInforme(rs, false);
        } catch (SQLException e) {
            Salida.errorInesperado();
        }
    }

    private static void informeMes(int mes) {
        String url = "EXEC GetInformeMensual ?";

        try(Connection conexion = Conexion.realizarConexion()){
            PreparedStatement st = conexion.prepareStatement(url);
            st.setInt(1, mes);
            st.execute();
            ResultSet rs = st.getResultSet();
            recogerInforme(rs, true);
        } catch (SQLException e) {
            Salida.errorInesperado();
        }
    }

    /**
     * <b>Cabecera: </b>private static void recogerInforme(ResultSet rs, boolean esMes) throws SQLException</br>
     * <b>Description: </b>Metodo para leer un informe de la base de datos</br>
     *
     * @param rs
     * @param esMes
     * @return
     */
    private static void recogerInforme(ResultSet rs, boolean esMes) throws SQLException {
        String consulta = "";

        rs.next();
        ResultSetMetaData rsm = rs.getMetaData();
        for (int i = 1; i <= rsm.getColumnCount(); i++) {
            consulta += rs.getString(i) + "_";
        }
        if (esMes){
            Salida.mostrarInformeMensual(consulta);
        }else{
            Salida.mostrarInformeAnual(consulta);
        }
    }

    private static void menuIntroducir() {
        boolean seguir = true;
        int opcion;
        do {
            Salida.mostrarMenuInsertar();
            opcion = Validacion.validarNumero0al4();
            switch (opcion) {
                case 1 -> VendedorDao.insertarVendedor();
                case 2 -> ClienteDao.insertarCliente();
                case 3 -> ProductoDao.insertarProducto();
                case 4 -> GestorDao.insertarGestor();
                case 0 -> seguir = false;
            }
        } while (seguir);
    }

    private static void menuModificar() {
        boolean seguir = true;
        int opcion;
        do {
            Salida.mostrarMenuModificar();
            opcion = Validacion.validarNumero0al4();
            switch (opcion) {
                case 1 -> VendedorDao.modificarVendedor();
                case 2 -> ClienteDao.modificarCliente();
                case 3 -> ProductoDao.modificarProducto();
                case 4 -> GestorDao.modificarGestor();
                case 0 -> seguir = false;
            }
        } while (seguir);
    }

    private static void menuEliminar() {
        boolean seguir = true;
        int opcion;

        do {
            Salida.mostrarMenuEliminar();
            opcion = Validacion.validarNumero0al5();
            switch (opcion) {
                case 1 -> VendedorDao.eliminarVendedor();
                case 2 -> ClienteDao.eliminarCliente();
                case 3 -> ProductoDao.eliminarProducto();
                case 4 -> GestorDao.eliminarGestor();
                case 5 -> FacturaDao.eliminarFactura();
                case 0 -> seguir = false;
            }
        } while (seguir);
    }
}
