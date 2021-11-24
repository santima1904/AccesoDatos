package controlador;

import modelo.FileAccess;
import modelo.conexionBBdd.ConexionBBdd;
import modelo.conexionBBdd.ConexionDDL;
import modelo.conexionBBdd.ConexionDML;
import modelo.conexionBBdd.MiConexion;
import vista.Menu;
import vista.Validacion;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        File fichero = FileAccess.crearFichero();
        FileAccess.escribirFichero(fichero, new MiConexion());
        MiConexion miConexion = FileAccess.leerFichero(fichero);
        int opcion = 1, continuar = 1;

        while (opcion != 0) {
            Menu.menu();
            opcion = Validacion.pedirOpcion();
            switch (opcion) {
                case 1:
                    Menu.mostarConsulta(ConexionDML.getSelectBBDD(ConexionBBdd.abrirConexion(miConexion), Validacion.pedirConsulta()));
                    //System.out.println(ConexionDML.getSelectBBDD(ConexionBBdd.abrirConexion(miConexion), "SELECT * FROM Cliente WHERE Nombre = 'Albert'"));
                    break;

                case 2:
                    Menu.mostrarInt(ConexionDML.insertarDatos(ConexionBBdd.abrirConexion(miConexion), Validacion.pedirConsulta()));
                    //ConexionDML.insertarDatos(ConexionBBdd.abrirConexion(miConexion), "INSERT INTO Cliente " +
                    //"Values ('Chicken', 'Little', 1)");
                    break;

                case 3:
                    while(continuar == 1){
                        Menu.confirmarAccion(ConexionDDL.ejecutarSentenciaDDL(ConexionBBdd.abrirConexion(miConexion), Validacion.pedirConsulta()));
                        continuar = Validacion.pedirContinuar();
                    }
//                    ConexionDDL.addTable(ConexionBBdd.abrirConexion(miConexion), Validacion.pedirConsulta());
//                    ConexionDDL.addColumn(ConexionBBdd.abrirConexion(miConexion), "ALTER TABLE Cliente \n" +
//                            "ADD id int");
                    break;

                case 4:
                    Menu.mostarContenidoFichero(FileAccess.leerFichero(fichero));
                    break;

            }
        }
        Menu.salir();
    }
}
