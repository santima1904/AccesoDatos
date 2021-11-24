package modelo.conexionBBdd;

import java.sql.Connection;
import java.sql.Statement;

public class ConexionDDL {

    /**
     * Cabecera: public static boolean ejecutarSentenciaDDL(Connection connection, String sentencia)
     * Descripcion: Metodo para ejecutar una sentencia DDL en la base de datos
     *
     * @param connection
     * @param sentencia
     * @return
     */
    public static boolean ejecutarSentenciaDDL(Connection connection, String sentencia){
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
