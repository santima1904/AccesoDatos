package modelo.conexionBBdd;

import java.sql.*;

public class ConexionBBdd {

    /**
     * <b>Cabecera: </b> public static Connection abrirConexion(String url, String usuario, String contrasenha) </br>
     * <b>Precondiciones: </b> cadenas distintas de null </br>
     * <b>Entradas: </b> String url, String usuario, String contrasenha </br>
     * <b>Salida: </b> Connection conexionBaseDatos </br>
     * <b>Postcondiciones: </b> abre la conexion con la base de datos </br>
     *
     * @return
     */
    public static Connection abrirConexion(MiConexion conexion){
        Connection connexionBaseDatos = null;

        try {
            connexionBaseDatos = DriverManager.getConnection("jdbc:sqlserver://"+conexion.getUrl()+":"+conexion.getPuerto()+";database="+conexion.getBbdd(),conexion.getUsuario(),conexion.getContasenha());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connexionBaseDatos;
    }

}
