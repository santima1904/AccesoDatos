package modelo.dataaccess.consultas;

import modelo.clasesBasicas.personas.Cliente;
import modelo.clasesBasicas.personas.UsuarioGestor;
import modelo.clasesBasicas.personas.UsuarioVendedor;
import modelo.dataaccess.ConexionBBDD;
import modelo.dataaccess.MiConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultasUsuarios {

    //Constantes
    public static final String LISTA_VENDEDORES = "SELECT * FROM UsuarioVendedor";
    public static final String LISTA_GESTORES = "SELECT * FROM UsuarioGestor";
    public static final String VENDEDOR_CONCRETO = "SELECT * FROM UsuarioVendedor " +
            "WHERE Id = ";

    //Metodos
    /**
     * <b>Cabecera: </b>public static List<UsuarioVendedor> getListadoVendedores()</br>
     * <b>Description: </b>Metodo para obtener un listado con todos los vendedores de la base de datos</br>
     * <b>Precondiciones: </b>Ninguna</br>
     * <b>Postcondiciones: </b>Lista rellena con los vendedores</br>
     *
     * @return
     */
    public static List<UsuarioVendedor> getListadoVendedores(){
        List<UsuarioVendedor> listadoVendedores = new ArrayList<>();
        Connection connection = ConexionBBDD.abrirConexion(new MiConexion());
        Statement statement = ConexionBBDD.crearStatement(connection);
        try(ResultSet rs = statement.executeQuery(LISTA_VENDEDORES)){
            while (rs.next()) {
                listadoVendedores.add(crearVendedor(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConexionBBDD.cerrarStatement(statement);
            ConexionBBDD.cerrarConexion(connection);
        }
        return listadoVendedores;
    }

    /**
     * <b>Cabecera: </b>public static UsuarioVendedor getVendedorConcreto(int id)</br>
     * <b>Description: </b>Metodo para obtener un vendedor de la base de datos con el id dado</br>
     * <b>Precondiciones: </b>Ninguna</br>
     * <b>Postcondiciones: </b>vendedor actualizado</br>
     *
     * @return
     */
    public static UsuarioVendedor getVendedorConcreto(int id){
        UsuarioVendedor vendedor = new UsuarioVendedor();
        Connection connection = ConexionBBDD.abrirConexion(new MiConexion());
        Statement statement = ConexionBBDD.crearStatement(connection);
        try(ResultSet rs = statement.executeQuery(VENDEDOR_CONCRETO+id)){
            vendedor = crearVendedor(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConexionBBDD.cerrarStatement(statement);
            ConexionBBDD.cerrarConexion(connection);
        }
        return vendedor;
    }

    /**
     * <b>Cabecera: </b>private static UsuarioVendedor crearVendedor(ResultSet rs) throws SQLException</br>
     * <b>Description: </b>Metodo para leer un vendedor de la base de datos</br>
     *
     * @param rs
     * @return
     */
    private static UsuarioVendedor crearVendedor(ResultSet rs) throws SQLException {
        UsuarioVendedor vendedor;
        String consulta = "";

        ResultSetMetaData rsm = rs.getMetaData();
        for (int i = 1; i <= rsm.getColumnCount(); i++) {
            consulta += rs.getString(i) + "_";
        }
        vendedor = generarVendedor(consulta);

        return vendedor;
    }

    /**
     * <b>Cabecera: </b>private static UsuarioVendedor generarVendedor(String consulta)</br>
     * <b>Description: </b>Metodo para crear un vendedor</br>
     *
     * @param consulta
     * @return
     */
    private static UsuarioVendedor generarVendedor(String consulta){
        UsuarioVendedor vendedorAux = new UsuarioVendedor();
        String [] atributos;

        atributos = consulta.split("_");
        vendedorAux.setId(Integer.parseInt(atributos[0]));
        vendedorAux.setNombre(atributos[1]);
        vendedorAux.setDni(atributos[2]);
        vendedorAux.setCodigoPostal(atributos[3]);
        vendedorAux.setCiudad(atributos[4]);
        vendedorAux.setTelefono(atributos[5]);
        vendedorAux.setCorreo(atributos[6]);
        vendedorAux.setUsuario(atributos[7]);
        vendedorAux.setContrasenha(atributos[8]);

        return vendedorAux;
    }

    /**
     * <b>Cabecera: </b>public static List<UsuarioGestor> getListadoGestores()</br>
     * <b>Description: </b>Metodo para obtener un listado con todos los gestores de la base de datos</br>
     * <b>Precondiciones: </b>Ninguna</br>
     * <b>Postcondiciones: </b>Lista rellena con los gestores</br>
     *
     * @return
     */
    public static List<UsuarioGestor> getListadoGestores(){
        List<UsuarioGestor> listadoGestores = new ArrayList<>();
        Connection connection = ConexionBBDD.abrirConexion(new MiConexion());
        Statement statement = ConexionBBDD.crearStatement(connection);
        try(ResultSet rs = statement.executeQuery(LISTA_GESTORES)){
            while (rs.next()) {
                listadoGestores.add(crearGestor(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConexionBBDD.cerrarStatement(statement);
            ConexionBBDD.cerrarConexion(connection);
        }
        return listadoGestores;
    }

    /**
     * <b>Cabecera: </b>private static UsuarioGestor crearGestor(ResultSet rs) throws SQLException</br>
     * <b>Description: </b>Metodo para leer un gestor de la base de datos</br>
     *
     * @param rs
     * @return
     */
    private static UsuarioGestor crearGestor(ResultSet rs) throws SQLException {
        UsuarioGestor gestor;
        String consulta = "";

        ResultSetMetaData rsm = rs.getMetaData();
        for (int i = 1; i <= rsm.getColumnCount(); i++) {
            consulta += rs.getString(i) + "_";
        }
        gestor = generarGestor(consulta);

        return gestor;
    }

    /**
     * <b>Cabecera: </b>private static UsuarioGestor generarGestor(String consulta)</br>
     * <b>Description: </b>Metodo para crear un gestor</br>
     *
     * @param consulta
     * @return
     */
    private static UsuarioGestor generarGestor(String consulta){
        UsuarioGestor gestorAux = new UsuarioGestor();
        String [] atributos;

        atributos = consulta.split("_");
        gestorAux.setId(Integer.parseInt(atributos[0]));
        gestorAux.setNombre(atributos[1]);
        gestorAux.setDni(atributos[2]);
        gestorAux.setCodigoPostal(atributos[3]);
        gestorAux.setCiudad(atributos[4]);
        gestorAux.setTelefono(atributos[5]);
        gestorAux.setCorreo(atributos[6]);
        gestorAux.setUsuario(atributos[7]);
        gestorAux.setContrasenha(atributos[8]);

        return gestorAux;
    }
}
