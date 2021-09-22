package vista;

import java.io.File;
import java.util.Scanner;

public class Mensajes {
    //En esta clase va a haber tanto entradas como salidas por teclado

    public static final String pedirRuta = "Indique la ruta por favor: ";
    public static final String esFichero = "es un fichero ";
    public static final String esDierctorio = "es un directorio ";

    public static Scanner teclado = new Scanner(System.in);


    public static String pedirRuta(){

        System.out.println(pedirRuta);

        return teclado.next();
    }

    public static void escribirListado(File[] ficheros){

        if (ficheros == null) {
            System.out.println(esFichero);

        }else{
            System.out.println(esDierctorio);
            for(File f: ficheros) {
                String textoDescr=f.isDirectory() ? "/":f.isFile() ? "_": "?";
                System.out.println("("+textoDescr+") "+f.getName());
            }
        }


    }
}
