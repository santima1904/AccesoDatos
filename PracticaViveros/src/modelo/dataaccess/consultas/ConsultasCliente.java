package modelo.dataaccess.consultas;

import modelo.clasesBasicas.personas.Cliente;
import modelo.dataaccess.ConexionBBDD;
import modelo.dataaccess.MiConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultasCliente {

    //Constantes
    public static final String LISTA_CLIENTES = "SELECT * FROM Cliente";
    public static final String CLIENTE_CONCRETO = "SELECT * FROM Cliente " +
            "WHERE Id = ";

    //Metodos

    /**
     * <b>Cabecera: </b>public static List<Cliente> getListadoClientes()</br>
     * <b>Description: </b>Metodo para obtener un listado con todos los clientes de la base de datos</br>
     * <b>Precondiciones: </b>Ninguna</br>
     * <b>Postcondiciones: </b>Lista rellena con los clientes</br>
     *
     * @return
     */
    public static List<Cliente> getListadoClientes(){
        List<Cliente> listadoClientes = new ArrayList<>();
        Connection connection = ConexionBBDD.abrirConexion(new MiConexion());
        Statement statement = ConexionBBDD.crearStatement(connection);
        try(ResultSet rs = statement.executeQuery(LISTA_CLIENTES)){
            while (rs.next()) {
                listadoClientes.add(crearCliente(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConexionBBDD.cerrarStatement(statement);
            ConexionBBDD.cerrarConexion(connection);
        }
        return listadoClientes;
    }

    /**
     * <b>Cabecera: </b>public static Cliente getClienteConcreto(int id)</br>
     * <b>Description: </b>Metodo para obtener un cliente de la base de datos con el id dado</br>
     * <b>Precondiciones: </b>Ninguna</br>
     * <b>Postcondiciones: </b>cliente actualizado</br>
     *
     * @return
     */
    public static Cliente getClienteConcreto(int id){
        Cliente cliente = new Cliente();
        Connection connection = ConexionBBDD.abrirConexion(new MiConexion());
        Statement statement = ConexionBBDD.crearStatement(connection);
        try(ResultSet rs = statement.executeQuery(CLIENTE_CONCRETO+id)){
                rs.next();
                cliente = crearCliente(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConexionBBDD.cerrarStatement(statement);
            ConexionBBDD.cerrarConexion(connection);
        }
        return cliente;
    }

    /**
     * <b>Cabecera: </b>private static Cliente crearCliente(ResultSet rs) throws SQLException</br>
     * <b>Description: </b>Metodo para leer un cliente de la base de datos</br>
     *
     * @param rs
     * @return
     */
    private static Cliente crearCliente(ResultSet rs) throws SQLException {
        Cliente cliente;
        String consulta = "";

        ResultSetMetaData rsm = rs.getMetaData();
        for (int i = 1; i <= rsm.getColumnCount(); i++) {
            consulta += rs.getString(i) + "_";
        }
        cliente = generarCliente(consulta);

        return cliente;
    }

    /**
     * <b>Cabecera: </b>private static Cliente generarCliente(String consulta)</br>
     * <b>Description: </b>Metodo para crear un cliente</br>
     *
     * @param consulta
     * @return
     */
    private static Cliente generarCliente(String consulta){
        Cliente clienteAux = new Cliente();
        String [] atributos;

        atributos = consulta.split("_");
        clienteAux.setId(Integer.parseInt(atributos[0]));
        clienteAux.setNombre(atributos[1]);
        clienteAux.setDni(atributos[2]);
        clienteAux.setCodigoPostal(atributos[3]);
        clienteAux.setCiudad(atributos[4]);
        clienteAux.setTelefono(atributos[5]);
        clienteAux.setCorreo(atributos[6]);

        return clienteAux;
    }

}
