package dal.vendedor;

import dal.conexion.Conexion;
import dal.factura.FacturaDao;
import dal.facturaProducto.FacturaProductoDao;
import dal.producto.ProductoDao;
import modelo.entidades.FacturaProducto;
import modelo.entidades.Producto;
import modelo.entidades.Vendedor;
import vista.mensaje.Salida;
import vista.validacion.Validacion;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendedorDao {
    /**
     * Cabecera: public static void generarFactura()
     *
     * Descripcion: Este metodo se encarga de controlar el menu para generar una factura.
     *
     * Precondiciones: Ninguna
     * Postcondiciones: El usuario introduce los productos deseados y genera la factura.
     */
    public static void generarFactura(int idVendedor){
        boolean continuar;
        ArrayList<FacturaProducto> lineasDePedido = new ArrayList<>();

        int idCliente = Validacion.validarCliente();
        if(idCliente != -2){
            do{
                continuar = false;
                Salida.mostrarMenuFactura();
                switch(Validacion.validarNumero0al2()){
                    case 1 ->{
                        generarProducto(lineasDePedido);
                        continuar = true;
                    }
                    case 2 -> mostrarFacturaYGuardar(lineasDePedido,idVendedor,idCliente);
                    case 0 -> Salida.mostrarString(Salida.CANCELAR_FACTURA);
                }
            }while(continuar);
        }
    }

    private static void mostrarFacturaYGuardar(ArrayList<FacturaProducto> lineasDePedido,int idVendedor, int idCliente) {
        Salida.mostrarFactura(idCliente,idVendedor,lineasDePedido);
        if(Validacion.validarFacturaValida()==1){
            int idFactura = FacturaDao.crearFacturaYDevolverSuId(LocalDate.now().toString(),
                    calcularTotalFactura(lineasDePedido,idCliente!=0), idCliente,idVendedor);
            FacturaProductoDao.facturaLineaPedidos(idFactura,lineasDePedido);
        }else{
            Salida.mostrarString(Salida.FACTURA_CANCELADA);
        }
    }

    private static double calcularTotalFactura(ArrayList<FacturaProducto> lineasPedido,boolean desc) {
        double total = 0;
        for (FacturaProducto linea:lineasPedido) {
            total += linea.getCoste();
        }
        if(desc){
            total -= total*0.05;
        }
        return total;
    }

    private static void generarProducto(ArrayList<FacturaProducto> lineasDePedido) {
        int cantidad;
        String codigo = Validacion.validarCodigo();
        if(productoRepetido(lineasDePedido,codigo)){
            Producto producto = ProductoDao.obtenerProductoPorCodigo(codigo);
            if(producto != null){
                cantidad = Validacion.validarCantidad();
                if ((producto.getUnidadesDisponibles() - cantidad) > 0) {
                    lineasDePedido.add(new FacturaProducto(codigo,cantidad,producto.getPrecioUnitario(),
                            cantidad*producto.getPrecioUnitario()));
                } else {
                    Salida.mostrarString(Salida.FALLO_CANTIDAD);
                }
            }
        }
    }
    private static boolean productoRepetido(ArrayList<FacturaProducto> lista, String code){
        boolean valido = true;
        for (int i=0;i<lista.size() && valido;i++){
            if (lista.get(i).getCode().equals(code)){
                valido=false;
            }
        }
        return valido;
    }

    public static void insertarVendedor() {
        Vendedor empleado= crearVendedor();
        String insercion= "INSERT INTO UsuarioVendedor VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.realizarConexion()) {
            PreparedStatement s = conexion.prepareStatement(insercion);
            System.out.println("Insertando en tabla...");
            System.out.println();
            s.setString(1, empleado.getNombre());
            s.setString(2, empleado.getDni());
            s.setString(3, empleado.getDireccion());
            s.setString(4, empleado.getCodigoPostal());
            s.setString(5, empleado.getCiudad());
            s.setString(6, empleado.getTelefono());
            s.setString(7, empleado.getCorreo());
            s.setString(8, empleado.getUsuario());
            s.setString(9, empleado.getContrasena());
            s.executeUpdate(); //para los insert y alter
        } catch (SQLException throwables) {
            Salida.errorInesperado();
        }
    }

    public static void modificarVendedor() {
        String dni= Validacion.validarDni();
        String columna= Validacion.seleccionarColumnaVendedor();
        String valor= elegirMensajeValidacion(columna);
        String modificar= "UPDATE UsuarioVendedor SET "+ columna +" = (?) WHERE DNI = (?)";

        try (Connection conexion = Conexion.realizarConexion()) {
            PreparedStatement s = conexion.prepareStatement(modificar);
            s.setString(1, valor);
            s.setString(2, dni);
            int resultado = s.executeUpdate();
            Validacion.validarResultadoModificar(resultado);
        } catch (SQLException throwables) {
            Salida.errorInesperado();
        }
    }

    private static String elegirMensajeValidacion(String columna){
        String valor = " ";
        switch (columna){
            case "Direccion", "Ciudad", "Correo" -> valor = Validacion.pedirValor();
            case "CodigoPostal" -> valor = Validacion.validarCodigoPostal();
            case "Telefono" -> valor = Validacion.validarTelefono();
        }
        return valor;
    }

    public static void eliminarVendedor() {
        String dni= Validacion.validarDni();
        int resultado;
        String eliminar= "DELETE FROM UsuarioVendedor WHERE DNI= (?)";

        try (Connection conexion = Conexion.realizarConexion()) {
            PreparedStatement s = conexion.prepareStatement(eliminar);
            s.setString(1, dni);
            resultado= s.executeUpdate();
            Validacion.validarResultadoEliminar(resultado);
        } catch (SQLException throwables) {
            Salida.errorInesperado();
        }
    }
    private static Vendedor crearVendedor() {
        return new Vendedor(Validacion.validarNombre(), Validacion.validarDni(), Validacion.validarDireccion(),
                Validacion.validarCodigoPostal(), Validacion.validarCiudad(), Validacion.validarTelefono(),
                Validacion.validarCorreo(), Validacion.pedirUsuario(), Validacion.validarContrasena());
    }
    public static List<Vendedor> getListadoVendedores(){
        List<Vendedor> listadoVendedores = new ArrayList<>();
        String url = "SELECT * FROM UsuarioVendedor";

        try(Connection conexion = Conexion.realizarConexion()){
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery(url);
            while (rs.next()) {
                listadoVendedores.add(crearVendedor(rs));
            }
        } catch (SQLException e) {
            Salida.errorInesperado();
        }
        return listadoVendedores;
    }
    private static Vendedor crearVendedor(ResultSet rs) throws SQLException {
        Vendedor vendedor;
        String consulta = "";


        ResultSetMetaData rsm = rs.getMetaData();
        for (int i = 1; i <= rsm.getColumnCount(); i++) {
            consulta += rs.getString(i) + "_";
        }
        vendedor = generarVendedor(consulta);

        return vendedor;
    }
    private static Vendedor generarVendedor(String consulta){
        Vendedor vendedorAux = new Vendedor();
        String [] atributos;

        atributos = consulta.split("_");
        vendedorAux.setId(Integer.parseInt(atributos[0]));
        vendedorAux.setNombre(atributos[1]);
        vendedorAux.setDni(atributos[2]);
        vendedorAux.setDireccion(atributos[3]);
        vendedorAux.setCodigoPostal(atributos[4]);
        vendedorAux.setCiudad(atributos[5]);
        vendedorAux.setTelefono(atributos[6]);
        vendedorAux.setCorreo(atributos[7]);
        vendedorAux.setUsuario(atributos[8]);
        vendedorAux.setContrasena(atributos[9]);

        return vendedorAux;
    }
    public static Vendedor getVendedorConcreto(int id){
        Vendedor vendedor = new Vendedor();
        String url = "SELECT * FROM UsuarioVendedor WHERE Id = " +id;

        try(Connection conexion = Conexion.realizarConexion()){
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery(url);
            while(rs.next()){
                vendedor = crearVendedor(rs);
            }
        } catch (SQLException e) {
            Salida.errorInesperado();
        }
        return vendedor;
    }
}
