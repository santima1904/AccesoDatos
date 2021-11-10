import java.sql.*;

public class Main {
    public static void main(String[] args) {

        //Para comprobar la conexion
        /*
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         */

        String driver = "jdbc:sqlserver://";
        String host = "localhost";
        String puerto = "1433";
        String baseDatos = "Javamon";
        String usuario = "santi";
        String contraseña = "mitesoro";
        String url = driver + host + ":" + puerto + ";databaseName=" + baseDatos;

        String mostrarTablas = "SELECT * FROM information_schema.tables;";

        try (
                Connection conexión = DriverManager.getConnection(url, usuario, contraseña);
                Statement s = conexión.createStatement();
                ResultSet rs = s.executeQuery(mostrarTablas)) {
            System.out.println("Conexión realizada.");
            while ((rs.next())) {
                System.out.println("Tabla: " + rs.getString(3));
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
