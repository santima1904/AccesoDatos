package vista;

import java.io.File;
import java.util.Scanner;

public class Mensajes {
    //En esta clase va a haber tanto entradas como salidas por teclado

    public static final String pedirRuta = "Indique la ruta por favor: ";
    public static final String esFichero = "-___";
    public static final String esDierctorio = "+---";

    public static Scanner teclado = new Scanner(System.in);


    public static String pedirRuta(){

        System.out.println(pedirRuta);

        return teclado.next();
    }

    public static void escribirListado(File[] ficheros){
        String cadenaFichero = esFichero;

        for(File f: ficheros) {

            if (f.isFile()) {

            }
            else{
            System.out.println(String.format(esDierctorio+f.getName()));


            }
        }


    }
}
