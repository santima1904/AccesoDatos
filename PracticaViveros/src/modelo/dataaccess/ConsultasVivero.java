package modelo.dataaccess;

import modelo.clasesBasicas.productos.ProductoPlanta;
import modelo.enums.TipoPlanta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultasVivero {
    //Constantes
    public static final String LISTA_PRODUCTOS_PLANTA_TIPO = "SELECT P.codigo, P.descripcion, P.precioUnitario, P.unidades, TP.nombre FROM Producto AS P\n" +
            "INNER JOIN ProductoPlanta AS PP ON P.codigo = PP.codigo\n" +
            "INNER JOIN TipoPlanta AS TP ON PP.idTipoPlanta = TP.Id";
    public static final String LISTA_PRODUCTOS_JARDINERIA = "SELECT * FROM Producto";
    public static final String LISTA_CLIENTES = "SELECT * FROM Cliente";
    public static final String LISTA_VENDEDORES = "SELECT * FROM UsuarioVendedor";
    public static final String LISTA_GESTORES = "SELECT * FROM UsuarioGestor";
    public static final String CLIENTE_CONCRETO = "SELECT * FROM Cliente \n" +
            "WHERE Id = @id";

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
                listadoPlantas.add(crearPlanta(rs));
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
     * <b>Cabecera: </b>private static ProductoPlanta crearPlanta(ResultSet rs) throws SQLException</br>
     * <b>Description: </b>Metodo para leer una planta de la base de datos</br>
     *
     * @param rs
     * @return
     */
    private static ProductoPlanta crearPlanta(ResultSet rs) throws SQLException {
       ProductoPlanta planta;
       String consulta = "";

        ResultSetMetaData rsm = rs.getMetaData();
        for (int i = 1; i <= rsm.getColumnCount(); i++) {
            consulta += rs.getString(i) + " ";
        }
        planta = generarPlanta(consulta);

        return planta;
    }

    /**
     * <b>Cabecera: </b>private static ProductoPlanta generarPlanta(String consulta)</br>
     * <b>Description: </b>Metodo para crear una planta de la base de datos en nuestro programa</br>
     *
     * @param consulta
     * @return
     */
    private static ProductoPlanta generarPlanta(String consulta){
        ProductoPlanta plantaAux = null;
        String [] atributos;

        atributos = consulta.split(" ");
        plantaAux.setCodigo(Integer.parseInt(atributos[0]));
        plantaAux.setDescripcion(atributos[1]);
        plantaAux.setPrecioUnitario(Integer.parseInt(atributos[2]));
        plantaAux.setUnidades(Integer.parseInt(atributos[3]));
        plantaAux.setTipo(getTipo(atributos[4]));

        return plantaAux;
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

