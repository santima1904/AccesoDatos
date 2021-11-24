package modelo.conexionBBdd;

import java.sql.*;

public class ConexionDML {

    /**
     * Cabecera: public static int insertarDatos(Connection connection, String sentencia)
     * Descripcion: Metodo para insertar datos en la base de datos
     *
     * @param connection
     * @param sentencia
     * @return
     */
    public static int insertarDatos(Connection connection, String sentencia){
        Statement statement = ConexionBBdd.crearStatement(connection);
        int resultado = 0;
        try {
            resultado =  statement.executeUpdate(sentencia);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    /*
    public static int getIntBBDD(Connection connection, String sentencia){
        int id = 0;
        Statement statement = ConexionBBdd.crearStatement(connection);
        try(ResultSet rs = statement.executeQuery(sentencia)){
            while (rs.next()){
                id = rs.getInt("id");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConexionBBdd.cerrarStatement(statement);
            ConexionBBdd.cerrarConexion(connection);
        }

        return id;
    }

     */

    /**
     * Cabecera: public static String getSelectBBDD(Connection connection, String sentencia)
     * Descripcion: Metodo para consultar datos en la base de datos
     *
     * @param connection
     * @param sentencia
     * @return
     */
    public static String getSelectBBDD(Connection connection, String sentencia){
        String consulta = "";
        ResultSetMetaData rsm;
        Statement statement = ConexionBBdd.crearStatement(connection);
        try(ResultSet rs = statement.executeQuery(sentencia)){
            while (rs.next()){
                rsm = rs.getMetaData();
                for(int i = 1; i <= rsm.getColumnCount();i++){
                     consulta += rs.getString(i)+" ";
                }
                consulta += "\n";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConexionBBdd.cerrarStatement(statement);
            ConexionBBdd.cerrarConexion(connection);
        }
        return consulta;
    }
}
