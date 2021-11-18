package controlador;

import modelo.conexionBBdd.ConexionBBdd;
import modelo.conexionBBdd.MiConexion;
import vista.Menu;
import vista.Validacion;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//
//        try {
//        Connection connexionBaseDatos = ConexionBBdd.abrirConexion(conexion1);
//        Statement s = connexionBaseDatos.createStatement();
//        ResultSet rs = s.executeQuery("SELECT * FROM Cliente");
//        System.out.println("Conexión realizada.");
//        while ((rs.next())) {
//            System.out.println(rs.getString(1) +" "+ rs.getString(2));
//        }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        Connection conexion = ConexionBBdd.abrirConexion(new MiConexion());
        Statement statement = (Statement) ConexionBBdd.crearStatement(conexion);
        int opcion = 1;

        while (opcion != 0) {
            opcion = Validacion.pedirOpcion();
            switch (opcion) {
                case 1:
                    //Ejecutar consulta
                    break;

                case 2:
                    //Ejecutar DML
                    break;

                case 3:
                    //Ejecutar DDL
                    break;

                case 4:
                    //Configuracion
                    break;

            }
        }
        Menu.salir();
    }
}
