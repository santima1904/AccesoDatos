package dal.producto;

import dal.Conexion;
import entidades.FacturaProducto;
import entidades.Producto;
import entidades.ProductoJardineria;
import entidades.ProductoPlanta;
import enums.TipoPlanta;
import mensaje.Salida;
import validacion.Validacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao {
    public static Producto obtenerProductoPorCodigo(String code){
        Producto producto = new Producto();
        String selectSql = "SELECT * FROM Producto WHERE Codigo = ?";

        try(Connection conexion = Conexion.realizarConexion()) {
            PreparedStatement st = conexion.prepareStatement(selectSql);
            st.setString(1,code);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setPrecioUnitario(rs.getDouble("PrecioUnitario"));
                producto.setCodigo(rs.getString("Codigo"));
                producto.setUnidadesDisponibles(rs.getInt("UnidadesDisponibles"));
            }
        } catch (SQLException e) {
            Salida.errorInesperado();
        }
        return producto;
    }

    public static void insertarProducto() {
        Producto producto= crearProducto();
        String insercion= "INSERT INTO Producto VALUES (?, ?, ?, ?)";

        try (Connection conexion = Conexion.realizarConexion()) {
            PreparedStatement s = conexion.prepareStatement(insercion);
            System.out.println("Insertando en tabla...");
            System.out.println();
            s.setString(1, producto.getCodigo());
            s.setString(2, producto.getDescripcion());
            s.setDouble(3, producto.getPrecioUnitario());
            s.setInt(4, producto.getUnidadesDisponibles());
            s.executeUpdate();
        } catch (SQLException throwables) {
            Salida.errorInesperado();
        }
    }
    public static void modificarProducto() {
        String id= Validacion.validarIdProducto();
        String columna= Validacion.seleccionarColumnaProducto();
        String valor= Validacion.pedirValor();
        String modificar;
        if (columna.equals("Descripcion"))
            modificar= "UPDATE Producto SET "+columna+" = '"+valor+"' WHERE Codigo = '"+ id +"'";
        else
            modificar= "UPDATE Producto SET "+columna+" = "+valor+" WHERE Codigo = '"+ id +"'";
        try (Connection conexion = Conexion.realizarConexion()) {
            PreparedStatement s = conexion.prepareStatement(modificar);
            System.out.println("Modificando...");
            System.out.println();
            s.executeUpdate(); //para los insert y alter
        } catch (SQLException throwables) {
            Salida.errorInesperado();
        }
    }
    public static void eliminarProducto() {
        String id= Validacion.validarIdProducto();
        String eliminar= "DELETE FROM Producto WHERE Codigo= (?)";
        try (Connection conexion = Conexion.realizarConexion()) {
            PreparedStatement s = conexion.prepareStatement(eliminar);
            System.out.println("Eliminando...");
            System.out.println();
            s.setString(1, String.valueOf(id));
            s.executeUpdate();
        } catch (SQLException throwables) {
            Salida.errorInesperado();
        }
    }
    private static Producto crearProducto() {
        return new Producto(Validacion.validarDescripcion(), Validacion.validarCodigo(),
                Validacion.validarPrecioUnitario(), Validacion.validarUnidadesDisponibles());
    }
    /**
     * <b>Cabecera: </b>public static List<ProductoJardineria> getListadoProductosJardineria()</br>
     * <b>Description: </b>Metodo para obtener un listado con todas los productos de jardineria de la base de datos</br>
     * <b>Precondiciones: </b>Ninguna</br>
     * <b>Postcondiciones: </b>Lista rellena con los productos de jardineria</br>
     *
     * @return
     */
    public static List<ProductoJardineria> getListadoProductosJardineria(){
        List<ProductoJardineria> listadoJardineria = new ArrayList<>();
        String url = "SELECT * FROM Producto AS P\n" +
                "\tINNER JOIN ProductoJardineria AS PJ ON P.codigo = PJ.codigo";

        try(Connection conexion = Conexion.realizarConexion()){
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery(url);
            while (rs.next()) {
                listadoJardineria.add(crearProductoJardineria(rs));
            }
        } catch (SQLException throwables) {
            Salida.errorInesperado();
        }
        return listadoJardineria;
    }
    /**
     * <b>Cabecera: </b>private static ProductoPlanta crearProducto(ResultSet rs) throws SQLException</br>
     * <b>Description: </b>Metodo para leer un producto de la base de datos</br>
     *
     * @param rs
     * @return
     */
    private static ProductoJardineria crearProductoJardineria(ResultSet rs) throws SQLException {
        ProductoJardineria producto;
        String consulta = "";

        ResultSetMetaData rsm = rs.getMetaData();
        for (int i = 1; i <= rsm.getColumnCount(); i++) {
            consulta += rs.getString(i) + "_";
        }
        producto = generarProductoJardineria(consulta);

        return producto;
    }
    /**
     * <b>Cabecera: </b>private static Producto generarProducto(String consulta)</br>
     * <b>Description: </b>Metodo para crear una planta o un producto de jardineria</br>
     *
     * @param consulta
     * @return
     */
    private static ProductoJardineria generarProductoJardineria(String consulta){
        ProductoJardineria productoAux = new ProductoJardineria();
        String [] atributos;

        atributos = consulta.split("_");
        productoAux.setCodigo(atributos[0]);
        productoAux.setDescripcion(atributos[1]);
        productoAux.setPrecioUnitario(Double.parseDouble(atributos[2]));

        return productoAux;
    }
    /**
     * <b>Cabecera: </b>public static List<ProductoPlanta> getListadoPlantasConTipo()</br>
     * <b>Description: </b>Metodo para obtener un listado con todas las plantas de la base de datos</br>
     * <b>Precondiciones: </b>Ninguna</br>
     * <b>Postcondiciones: </b>Lista rellena con las plantas</br>
     *
     * @return
     */
    public static List<ProductoPlanta> getListadoPlantasConTipo(){
        List<ProductoPlanta> listadoPlantas = new ArrayList<>();
        String url = "SELECT P.codigo, P.descripcion, P.precioUnitario, P.unidadesDisponibles, TP.nombre FROM Producto " +
                "AS P INNER JOIN ProductoPlanta AS PP ON P.codigo = PP.codigo INNER JOIN Categoria AS TP ON PP.IDCategoria= TP.ID";

        try(Connection conexion = Conexion.realizarConexion()){
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(url);
            while (rs.next()) {
                listadoPlantas.add(crearProductoPlanta(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listadoPlantas;
    }
    /**
     * <b>Cabecera: </b>private static ProductoPlanta crearProducto(ResultSet rs) throws SQLException</br>
     * <b>Description: </b>Metodo para leer un producto de la base de datos</br>
     *
     * @param rs
     * @return
     */
    private static ProductoPlanta crearProductoPlanta(ResultSet rs) throws SQLException {
        ProductoPlanta producto;
        String consulta = "";

        ResultSetMetaData rsm = rs.getMetaData();
        for (int i = 1; i <= rsm.getColumnCount(); i++) {
            consulta += rs.getString(i) + "_";
        }
        producto = generarProductoPlanta(consulta);

        return producto;
    }
    /**
     * <b>Cabecera: </b>private static Producto generarProducto(String consulta)</br>
     * <b>Description: </b>Metodo para crear una planta o un producto de jardineria</br>
     *
     * @param consulta
     * @return
     */
    private static ProductoPlanta generarProductoPlanta(String consulta){
        ProductoPlanta productoAux = new ProductoPlanta();
        String [] atributos;

        atributos = consulta.split("_");
        productoAux.setCodigo(atributos[0]);
        productoAux.setDescripcion(atributos[1]);
        productoAux.setPrecioUnitario(Double.parseDouble(atributos[2]));
        productoAux.setUnidadesDisponibles(Integer.parseInt(atributos[3]));
        productoAux.setTipo(getTipo(atributos[4]));

        return productoAux;
    }
    /**
     * <b>Cabecera: </b>private static TipoPlanta getTipo(String tipo)</br>
     * <b>Description: </b>Metodo para obtener el tipo de la planta</br>
     *
     * @param tipo
     * @return
     */
    private static TipoPlanta getTipo(String tipo){
        TipoPlanta tipoPlanta = null;
        switch (tipo){
            case "Plantas de Interior" -> tipoPlanta = TipoPlanta.INTERIOR;
            case "Plantas de Exterior" -> tipoPlanta = TipoPlanta.EXTERIOR;
            case "Árboles Ornamentales" -> tipoPlanta = TipoPlanta.ARBOLES_ORNAMENTALES;
            case "Árboles Frutales" -> tipoPlanta = TipoPlanta.ARBOLES_FRUTALES;
        }
        return tipoPlanta;
    }
    public static void actualizarBBDD(FacturaProducto pf){
        String updateSql = " UPDATE Producto SET UnidadesDisponibles = (UnidadesDisponibles - ?) WHERE Codigo = ?";
        try(Connection conexion = Conexion.realizarConexion()){
            PreparedStatement ps = conexion.prepareStatement(updateSql);
            ps.setInt(1,pf.getCantidad());
            ps.setString(2,pf.getCode());
        } catch (SQLException throwables) {
            Salida.errorInesperado();
        }
    }
}
