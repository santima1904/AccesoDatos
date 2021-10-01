package controlador;

import modelo.FileAccess;
import vista.EntradaSalida;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        FileAccess.InicializarFichero();
        EntradaSalida.mostrarMenuConfiguracion(FileAccess.leerBooleano(), FileAccess.leerChar(), FileAccess.leerDouble(), FileAccess.leerString());
    }
}
