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
    public static final String FACTURAS_CLIENTE_CONCRETO = "SELECT F.Id, F.fecha, F.importe, F.idVendedor, C.Id FROM Cliente AS C\n" +
            "INNER JOIN Factura AS F ON C.Id = F.idCliente\n" +
            "WHERE C.Id = ";
    public static final String INFORME_MENSUAL = "EXEC GetInformeMensual ?";
    public static final String INFORME_ANUAL = "EXEC GetInformeAnual ?";

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
            consulta += rs.getString(i) + "_";
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
        Factura facturaAux = new Factura();
        String [] atributos;
        String [] fecha;

        atributos = consulta.split("_");
        facturaAux.setId(Integer.parseInt(atributos[0]));
        fecha = atributos[1].split(" ");
        facturaAux.setFecha(LocalDate(fecha[0]));
        facturaAux.setImporte(Double.parseDouble(atributos[2]));
        facturaAux.setCliente(ConsultasCliente.getClienteConcreto(Integer.parseInt(atributos[4])));
        facturaAux.setVendedor(ConsultasUsuarios.getVendedorConcreto(Integer.parseInt(atributos[3])));

        return facturaAux;
    }

    /**
     *  <b>Cabecera: </b>private static LocalDate LocalDate (String fecha)</br>
     *  <b>Description: </b>Metodo para castear la fecha </br>
     * @param fecha
     * @return
     */
    private static LocalDate LocalDate (String fecha){
        String [] partesFecha = fecha.split("-");
        return LocalDate.of(Integer.parseInt(partesFecha[0]), Integer.parseInt(partesFecha[1]), Integer.parseInt(partesFecha[2]));
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

        try(PreparedStatement st = connection.prepareStatement(INFORME_MENSUAL)){
            st.setInt(1, mes);
            st.execute();
            ResultSet rs = st.getResultSet();
            recogerInforme(rs, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

        try(PreparedStatement st = connection.prepareStatement(INFORME_ANUAL)){
            st.setInt(1, anho);
            st.execute();
            ResultSet rs = st.getResultSet();
            recogerInforme(rs, false);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

        rs.next();
        ResultSetMetaData rsm = rs.getMetaData();
        for (int i = 1; i <= rsm.getColumnCount(); i++) {
            consulta += rs.getString(i) + "_";
        }
        if (esMes){
            mostrarInformeMensual(consulta);
        }else{
            mostrarInformeAnual(consulta);
        }
    }

    /**
     * <b>Cabecera: </b>private static void mostrarInformeMensual(String consulta)</br>
     * <b>Description: </b>Metodo para mostrar el informe por pantalla</br>
     *
     * @param consulta
     */
    private static void mostrarInformeMensual(String consulta){
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
    private static void mostrarInformeAnual(String consulta){
        String [] atributos;

        atributos = consulta.split("_");
        System.out.println("Informe del anual de " + atributos[0]);
        System.out.println("Informe de ventas de productos plantas: " + atributos[1]);
        System.out.println("Informe de ventas de productos jardineria: " + atributos[2]);
        System.out.println("Informe de ventas totales: " + atributos[3]);
        System.out.println("\n");
    }
}
