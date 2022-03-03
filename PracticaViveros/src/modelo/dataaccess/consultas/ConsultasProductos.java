package modelo.dataaccess.consultas;

import modelo.clasesBasicas.productos.Producto;
import modelo.clasesBasicas.productos.ProductoJardineria;
import modelo.clasesBasicas.productos.ProductoPlanta;
import modelo.dataaccess.ConexionBBDD;
import modelo.dataaccess.MiConexion;
import modelo.enums.TipoPlanta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultasProductos {
    //Constantes
    public static final String LISTA_PRODUCTOS_PLANTA_TIPO = "SELECT P.codigo, P.descripcion, P.precioUnitario, P.unidades, TP.nombre FROM Producto AS P\n" +
            "INNER JOIN ProductoPlanta AS PP ON P.codigo = PP.codigo " +
            "INNER JOIN TipoPlanta AS TP ON PP.idTipoPlanta = TP.Id";
    public static final String LISTA_PRODUCTOS_JARDINERIA = "SELECT * FROM Producto AS P\n" +
            "\tINNER JOIN ProductoJardineria AS PJ ON P.codigo = PJ.codigo";

    //Metodos

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
        Connection connection = ConexionBBDD.abrirConexion(new MiConexion());
        Statement statement = ConexionBBDD.crearStatement(connection);
        try(ResultSet rs = statement.executeQuery(LISTA_PRODUCTOS_PLANTA_TIPO)){
            while (rs.next()) {
                    listadoPlantas.add(crearProductoPlanta(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConexionBBDD.cerrarStatement(statement);
            ConexionBBDD.cerrarConexion(connection);
        }
        return listadoPlantas;
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
        Connection connection = ConexionBBDD.abrirConexion(new MiConexion());
        Statement statement = ConexionBBDD.crearStatement(connection);
        try(ResultSet rs = statement.executeQuery(LISTA_PRODUCTOS_JARDINERIA)){
            while (rs.next()) {
                listadoJardineria.add(crearProductoJardineria(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConexionBBDD.cerrarStatement(statement);
            ConexionBBDD.cerrarConexion(connection);
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
    private static ProductoPlanta generarProductoPlanta(String consulta){
        ProductoPlanta productoAux = new ProductoPlanta();
        String [] atributos;

        atributos = consulta.split("_");
        productoAux.setCodigo(Integer.parseInt(atributos[0]));
        productoAux.setDescripcion(atributos[1]);
        productoAux.setPrecioUnitario(Double.parseDouble(atributos[2]));
        productoAux.setUnidades(Integer.parseInt(atributos[3]));
        productoAux.setTipo(getTipo(atributos[4]));

        return productoAux;
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
        productoAux.setCodigo(Integer.parseInt(atributos[0]));
        productoAux.setDescripcion(atributos[1]);
        productoAux.setPrecioUnitario(Double.parseDouble(atributos[2]));

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
            case "interior" -> tipoPlanta = TipoPlanta.INTERIOR;
            case "exterior" -> tipoPlanta = TipoPlanta.EXTERIOR;
            case "árboles ornamentales" -> tipoPlanta = TipoPlanta.ARBOLES_ORNAMENTALES;
            case "árboles frutales" -> tipoPlanta = TipoPlanta.ARBOLES_FRUTALES;
        }
        return tipoPlanta;
    }
}

