package controlador;

import modelo.FileAccessText;
import vista.Menu;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        //Variables
        File fichero = null;
        int opcion = 1;

        while(opcion != 4){

            Menu.mostrarMenu();

            opcion = Menu.pedirOpcion();

            switch (opcion){
                case 1:
                    fichero = FileAccessText.generarFichero(Menu.pedirNombre());
                    FileAccessText.escribirBuffer(fichero, Menu.pedirTexto());
                    FileAccessText.escribirBuffer(fichero, Menu.pedirTexto());
                    break;

                case 2:
                    FileAccessText.escribirBuffer(fichero, Menu.pedirTexto());
                    break;

                case 3:
                    Menu.mostrarLista(FileAccessText.leerContenido(fichero));
                    break;

            }
            Menu.espacioEntreOpciones();
        }

        Menu.salida();

    }
}
