package clasesBasicas;

import java.io.File;

public class FileAccess {

    public static File fich;


    public static File[] listarDirectorio (String ruta) {
        fich = new File(ruta);
        boolean fichero = false;
        File [] ficheros = null;

        if (!fich.isFile()) {
            ficheros = fich.listFiles();
        }
        return ficheros;
    }


}
