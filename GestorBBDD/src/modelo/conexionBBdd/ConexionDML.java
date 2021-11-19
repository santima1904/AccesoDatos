package modelo.conexionBBdd;

import java.sql.*;

public class ConexionDML {

    public static void insertarDatos(Connection connection, String sentencia){
        Statement statement = ConexionBBdd.crearStatement(connection);
        try {
            statement.executeUpdate(sentencia);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
