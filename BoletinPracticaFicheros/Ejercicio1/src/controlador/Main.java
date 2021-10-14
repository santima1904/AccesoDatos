package controlador;

import modelo.FileAcccess;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        //Constantes
        final String NOMBRE_1 = "capoeira.txt";
        final String TEXTO_1 = "Arte marcial brasileño que se practica con musica";
        final String NOMBRE_2 = "vientre.txt";
        final String TEXTO_2 = "Danza muy elemental con movimientos de pelvis";
        final String MENSAJE_TIEMPO_CON = "Tiempo con buffer: ";
        final String MENSAJE_TIEMPO_SIN = "Tiempo sin buffer: ";

        //Variables
        File fichero1, fichero2;
        long inicio1, inicio2, fin1, fin2;

        //Ficheros generados
        fichero1 = FileAcccess.generarFichero(NOMBRE_1);
        fichero2 = FileAcccess.generarFichero(NOMBRE_2);


        //Inicio de programa
        inicio1 = System.currentTimeMillis();

        for (int i = 0; i <= 10000; i++){
            FileAcccess.escribirSinBuffer(fichero1, TEXTO_1);
        }

        fin1 = System.currentTimeMillis();

        inicio2 = System.currentTimeMillis();

        for (int i = 0; i <= 10000; i++){
            FileAcccess.escribirSinBuffer(fichero2, TEXTO_2);
        }

        fin2 = System.currentTimeMillis();

        //Muestra del resultado
        System.out.println(MENSAJE_TIEMPO_SIN+(fin1-inicio1));
        System.out.println(MENSAJE_TIEMPO_CON+(fin2-inicio2));

    }

}
