package controlador;

import modelo.FileAccess;
import vista.Menu;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File fichero = new File(Menu.pedirRuta());
        File [] ficheros = FileAccess.listarDirectorio(fichero);

        Menu.escribirListado(ficheros, 1);
        FileAccess.contarFicheros(ficheros);
        FileAccess.NexoConMenu();

    }
}
