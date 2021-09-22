package gestion;

import clasesBasicas.FileAccess;
import vista.Mensajes;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        Mensajes.escribirListado(FileAccess.listarDirectorio(Mensajes.pedirRuta()));

    }
}
