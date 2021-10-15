package controlador;

import modelo.FileAccess;
import vista.Menu;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        final String NOMBRE = "numerostlf.txt";

        int opcion = 0;
        List <Integer> lista = new ArrayList<>();
        File fichero = FileAccess.crearFichero(NOMBRE);

        while(opcion != 3){

            lista = FileAccess.leerNumeros(fichero);
            Menu.mostrarMovilesGuardados(lista);

            Menu.mostrarMenu();
            opcion = Menu.pedirOpcion();

            switch (opcion) {
                case 1 -> FileAccess.escribirFichero(fichero, Menu.pedirNumeroTlf());
                case 2 -> Menu.mostrarMovilBuscado(buscarNumeroEnLista(Menu.pedirIndice(), lista));
            }
        }
        Menu.salida();
    }

    /**
     * Cabecera: private static int buscarNumeroEnLista(int indice, List<Integer> lista)
     * Precondiciones: lista diferente de null
     * Entradas: int indice, List<Integer> lista
     * Salida: int
     * Postcondiciones: Devuelve el entero que ocupa la posicion dada en la lista
     */
    private static int buscarNumeroEnLista(int indice, List<Integer> lista){
        int numero = 0;

        numero = lista.get(indice);

        return numero;
    }
}
