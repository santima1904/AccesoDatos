package modelo.dataaccess.consultas;

import modelo.clasesBasicas.Factura;
import modelo.dataaccess.ConexionBBDD;
import modelo.dataaccess.MiConexion;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ConsultasInforme {

    //Constantes
    public static final String FACTURAS_CLIENTE_CONCRETO = "SELECT F.Id, F.fecha, F.importe, F.idVendedor, C.nombre FROM Cliente AS C\n" +
            "INNER JOIN Factura AS F ON C.Id = F.idCliente\n" +
            "WHERE C.Id = ";
    public static final String INFORME_MENSUAL = "EXEC GetInformeMensual ";
    public static final String INFORME_ANUAL = "EXEC GetInformeAnual ";

    //Metodos
    /**
     * <b>Cabecera: </b> public static List<Factura> getFacturasCliente(int id)</br>
     * <b>Description: </b>Metodo para obtener un listado con todas los facturas de un cliente dado de la base de datos</br>
     * <b>Precondiciones: </b>Ninguna</br>
     * <b>Postcondiciones: </b>Lista rellena con las facturas</br>
     *
     * @return
     */
    public static List<Factura> getFacturasCliente(int id){
        List<Factura> listadoFacturas = new ArrayList<>();
        Connection connection = ConexionBBDD.abrirConexion(new MiConexion());
        Statement statement = ConexionBBDD.crearStatement(connection);
        try(ResultSet rs = statement.executeQuery(FACTURAS_CLIENTE_CONCRETO+id)){
            while (rs.next()) {
                listadoFacturas.add(crearFactura(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConexionBBDD.cerrarStatement(statement);
            ConexionBBDD.cerrarConexion(connection);
        }
        return listadoFacturas;
    }

    /**
     * <b>Cabecera: </b>private static Factura crearFactura(ResultSet rs) throws SQLException</br>
     * <b>Description: </b>Metodo para leer una factura de la base de datos</br>
     *
     * @param rs
     * @return
     */
    private static Factura crearFactura(ResultSet rs) throws SQLException {
        Factura factura;
        String consulta = "";

        ResultSetMetaData rsm = rs.getMetaData();
        for (int i = 1; i <= rsm.getColumnCount(); i++) {
            consulta += rs.getString(i) + " ";
        }
        factura = generarFactura(consulta);

        return factura;
    }

    /**
     * <b>Cabecera: </b>private static Factura generarFactura(String consulta)</br>
     * <b>Description: </b>Metodo para crear una factura</br>
     *
     * @param consulta
     * @return
     */
    private static Factura generarFactura(String consulta){
        Factura facturaAux = null;
        String [] atributos;

        atributos = consulta.split(" ");
        facturaAux.setId(Integer.parseInt(atributos[0]));
        facturaAux.setFecha(LocalDate.parse(atributos[1]));
        facturaAux.setImporte(Double.parseDouble(atributos[2]));
        facturaAux.setCliente(ConsultasCliente.getClienteConcreto(Integer.parseInt(atributos[3])));
        facturaAux.setVendedor(ConsultasUsuarios.getVendedorConcreto(Integer.parseInt(atributos[4])));

        return facturaAux;
    }

    /**
     * <b>Cabecera: </b> public static void getInformeMensual(int mes)</br>
     * <b>Description: </b>Metodo para obtener un informe de las ventas de todos los productos en un mes dado de la base de datos</br>
     * <b>Precondiciones: </b>mes positivo y diferente de 0</br>
     * <b>Postcondiciones: </b>consulta obtenida</br>
     *
     * @param mes
     */
    public static void getInformeMensual(int mes){
        Connection connection = ConexionBBDD.abrirConexion(new MiConexion());
        Statement statement = ConexionBBDD.crearStatement(connection);
        try(ResultSet rs = statement.executeQuery(INFORME_MENSUAL+mes)){
            recogerInforme(rs, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConexionBBDD.cerrarStatement(statement);
            ConexionBBDD.cerrarConexion(connection);
        }
    }

    /**
     * <b>Cabecera: </b> public static void getInformeAnual(int anho)</br>
     * <b>Description: </b>Metodo para obtener un informe de las ventas de todos los productos en un anho dado de la base de datos</br>
     * <b>Precondiciones: </b>anho positivo y diferente de 0</br>
     * <b>Postcondiciones: </b>consulta obtenida</br>
     *
     * @param anho
     */
    public static void getInformeAnual(int anho){
        Connection connection = ConexionBBDD.abrirConexion(new MiConexion());
        Statement statement = ConexionBBDD.crearStatement(connection);
        try(ResultSet rs = statement.executeQuery(INFORME_ANUAL+anho)){
            recogerInforme(rs, false);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConexionBBDD.cerrarStatement(statement);
            ConexionBBDD.cerrarConexion(connection);
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

        ResultSetMetaData rsm = rs.getMetaData();
        for (int i = 1; i <= rsm.getColumnCount(); i++) {
            consulta += rs.getString(i) + " ";
        }
        if (esMes){
            mostrarInformeMensual(consulta);
        }else{
            mostrarInformeAnual(consulta);
        }
        System.out.println(consulta);
    }

    /**
     * <b>Cabecera: </b>private static void mostrarInformeMensual(String consulta)</br>
     * <b>Description: </b>Metodo para mostrar el informe por pantalla</br>
     *
     * @param consulta
     */
    private static void mostrarInformeMensual(String consulta){
        String [] atributos;

        atributos = consulta.split(" ");
        System.out.println("Informe del mes de "+ Month.of(Integer.parseInt(atributos[0])).getDisplayName(TextStyle.FULL_STANDALONE, new Locale(Locale.ENGLISH.getLanguage())));
        System.out.println("Informe de ventas de productos plantas: " + atributos[1]);
        System.out.println("Informe de ventas de productos jardineria: " + atributos[2]);
        System.out.println("Informe de ventas totales: " + atributos[3]);
    }

    /**
     * <b>Cabecera: </b>private static void mostrarInformeAnual(String consulta)</br>
     * <b>Description: </b>Metodo para mostrar el informe por pantalla</br>
     *
     * @param consulta
     */
    private static void mostrarInformeAnual(String consulta){
        String [] atributos;

        atributos = consulta.split(" ");
        System.out.println("Informe del anual de " + atributos[0]);
        System.out.println("Informe de ventas de productos plantas: " + atributos[1]);
        System.out.println("Informe de ventas de productos jardineria: " + atributos[2]);
        System.out.println("Informe de ventas totales: " + atributos[3]);
    }
}
