package controlador;

import modelo.conexionBBdd.ConexionBBdd;
import modelo.conexionBBdd.MiConexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        MiConexion conexion1 = new MiConexion();

        try {
        Connection connexionBaseDatos = ConexionBBdd.abrirConexion(conexion1);
        Statement s = connexionBaseDatos.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM Clientes");
        System.out.println("Conexión realizada.");
        while ((rs.next())) {
            System.out.println("Tabla: " + rs.getString(3));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
