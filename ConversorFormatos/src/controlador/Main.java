package controlador;

import modelo.FileAccess;
import vista.Menu;

import java.io.File;

public class Main{

    public static void main(String[] args) {

        int opcion = 1;
        File fichero;

        while(opcion != 0){

            Menu.menuPrincipal();
            opcion = Menu.pedirInt();

            switch (opcion){

                case 1:
                    fichero = FileAccess.crearFichero(Menu.nombre());
                    FileAccess.escribir(Menu.texto(), fichero, Menu.pedirFormato());
                    break;

                case 2:
                    do {

                        Menu.mostrarLista(FileAccess.leerLinea(FileAccess.crearFichero(Menu.nombre()), Menu.pedirFormato()));

                        Menu.cambioFormato();

                    }while (Menu.pedirInt() == 1);
            }
        }
    }

}
