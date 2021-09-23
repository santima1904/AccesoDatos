package vista;

import clasesBasicas.FileAccess;

import java.io.File;
import java.util.Scanner;

public class Mensajes {
    //En esta clase va a haber tanto entradas como salidas por teclado

    public static final String pedirRuta = "Indique la ruta por favor: ";
    public static final String esDierctorio = "+---";

    public static Scanner teclado = new Scanner(System.in);


    public static String pedirRuta(){

        System.out.println(pedirRuta);

        return teclado.next();
    }



    public static void escribirListado(File[] ficheros){

        for(File f: ficheros) {

            if (f.isFile()) {
                System.out.println(String.format("-%1s%2s%3s", FileAccess.puedeLeer(f), FileAccess.puedeEscribir(f), FileAccess.puedeEjecutar(f) ));
            }
            else{
                System.out.println(esDierctorio+f.getName());
                escribirListado(FileAccess.listarDirectorio(f.getPath()));
            }
        }


    }
}
