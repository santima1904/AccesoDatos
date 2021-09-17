package clasesbasicas;

import java.io.File;

public class FileAccess {

    public static File fichero;



    public static boolean crearFichero(String nombre){

        boolean existe;

        fichero = new File(nombre);
        existe = fichero.exists();

        return existe;

    }


}
