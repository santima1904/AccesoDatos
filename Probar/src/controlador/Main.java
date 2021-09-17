package controlador;

import clasesbasicas.FileAccess;
import vista.Mensajes;
import vista.Validacion;


public class Main {
    public static void main(String[] args) {
        String nombre = null, cadena = null;

        Mensajes.preguntaInicial();
        nombre = Validacion.pedirString();
        Mensajes.preguntaContenido();
        cadena = Validacion.pedirString();

        FileAccess.escribirFichero(FileAccess.crearFichero(nombre), cadena);

    }
}
