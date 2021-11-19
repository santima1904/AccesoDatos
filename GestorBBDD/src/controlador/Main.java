package controlador;

import modelo.conexionBBdd.ConexionBBdd;
import modelo.conexionBBdd.ConexionDDL;
import modelo.conexionBBdd.ConexionDML;
import modelo.conexionBBdd.MiConexion;
import vista.Menu;
import vista.Validacion;

public class Main {
    public static void main(String[] args) {

        MiConexion miConexion = new MiConexion();
        int opcion = 1;

        while (opcion != 0) {
            opcion = Validacion.pedirOpcion();
            switch (opcion) {
                case 1:
                    System.out.println(ConexionDML.getSelectBBDD(ConexionBBdd.abrirConexion(miConexion), "SELECT * FROM Cliente WHERE Nombre = 'Albert'"));
                    break;

                case 2:
                    ConexionDML.insertarDatos(ConexionBBdd.abrirConexion(miConexion), "INSERT INTO Cliente " +
                     "Values ('Chicken', 'Little', 1)");
                    break;

                case 3:
                    ConexionDDL.addTable(ConexionBBdd.abrirConexion(miConexion), Validacion.pedirConsulta());
                    ConexionDDL.addColumn(ConexionBBdd.abrirConexion(miConexion), "ALTER TABLE Cliente \n" +
                            "ADD id int");
                    break;

                case 4:
                    //Configuracion
                    break;

            }
        }
        Menu.salir();
    }
}
