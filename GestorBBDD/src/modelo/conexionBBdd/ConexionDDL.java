package modelo.conexionBBdd;

import java.sql.Connection;
import java.sql.Statement;

public class ConexionDDL {

    public static boolean addTable(Connection connection, String sentencia){
        boolean realizado = false;
        Statement statement = ConexionBBdd.crearStatement(connection);
        try {
            realizado = statement.execute(sentencia);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConexionBBdd.cerrarStatement(statement);
            ConexionBBdd.cerrarConexion(connection);
        }
        return realizado;
    }

    public static boolean addColumn(Connection connection,String sentencia){
        boolean realizado = false;
        Statement statement = ConexionBBdd.crearStatement(connection);
        try {
            realizado = statement.execute(sentencia);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConexionBBdd.cerrarStatement(statement);
            ConexionBBdd.cerrarConexion(connection);
        }
        return realizado;
    }

}
