package clasesbasicas;

import java.io.File;

public class FileAccess {

    public static File fichero;

    private boolean comprobarFichero (String nombre) {
        File ficheroAuxiliar = new File(nombre);
        boolean existe = false;

        if (ficheroAuxiliar.exists()) {
            existe = true;
        }

        return existe;
    }

    public static void crearFichero(String nombre){

    }


}
