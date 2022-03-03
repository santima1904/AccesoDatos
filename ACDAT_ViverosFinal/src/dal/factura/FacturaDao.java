package dal.factura;

import dal.Conexion;
import dal.cliente.ClienteDao;
import dal.vendedor.VendedorDao;
import entidades.Factura;
import mensaje.Salida;
import validacion.Validacion;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FacturaDao {
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
        String url = "SELECT F.Id, F.fecha, F.importeTotal, F.idVendedor, C.Id FROM Cliente " +
                "AS C INNER JOIN Factura AS F ON C.Id = F.idCliente WHERE C.Id = " + id;

        try(Connection conexion = Conexion.realizarConexion()){
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery(url);
            while (rs.next()) {
                listadoFacturas.add(crearFactura(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        facturaAux.setCliente(ClienteDao.getClienteConcreto(Integer.parseInt(atributos[4])));
        facturaAux.setVendedor(VendedorDao.getVendedorConcreto(Integer.parseInt(atributos[3])));

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
    public static void eliminarFactura() {
        int id= Validacion.validarId();
        String eliminar= "DELETE FROM Facturas WHERE id= (?)";
        String eliminar2= "DELETE FROM FacturasProductos WHERE idFactura= (?)";

        try (Connection conexion = Conexion.realizarConexion()) {
            PreparedStatement s = conexion.prepareStatement(eliminar);
            PreparedStatement s2 = conexion.prepareStatement(eliminar2);
            System.out.println("Eliminando...");
            System.out.println();
            s.setString(1, String.valueOf(id));
            s2.setString(1, String.valueOf(id));
            s.executeUpdate();
            s2.executeUpdate();
        } catch (SQLException throwables) {
            Salida.errorInesperado();
        }
    }
    public static int crearFacturaYDevolverSuId(String fecha, double importe,int idCliente, int idVendedor){
        String insertSql = "{CALL insertFactura(?, ?, ?, ?, ?)}";
        int result=0;
        try(Connection conexion = Conexion.realizarConexion()) {
            CallableStatement s = conexion.prepareCall(insertSql);
            s.registerOutParameter(5,Types.INTEGER);
            s.setDate(1,(Date.valueOf(fecha)));
            s.setDouble(2,importe);
            s.setInt(3, idVendedor);
            s.setInt(4, idCliente);
            s.setInt(5, result);
            s.executeUpdate();
            result = s.getInt(5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
