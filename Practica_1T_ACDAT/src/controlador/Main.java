package controlador;

import modelo.Cliente;
import modelo.ficheros.FileAccessObject;
import modelo.ficheros.FileAccessText;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Santi", "PATATATAT", "AFSPAPAPAP", "SDGDDGSDGDASG", "SDFSFAFSDFF");
        Cliente c2 = new Cliente("SI", "SI", "SI", "SI", "SI");
        List<String>lista = new ArrayList<>();
//
////
       FileAccessObject.escribirCliente(c1);
        FileAccessObject.escribirFicheroIndice(c1.getDni(), FileAccessObject.getLongitudFichero());
////
       FileAccessObject.escribirCliente(c2);
        FileAccessObject.escribirFicheroIndice(c2.getDni(), FileAccessObject.getLongitudFichero());

//
//        System.out.println(FileAccessObject.buscarPosicionFicheroIndice(c1.getDni()));
//
//
//        lista = FileAccessObject.leerClientes();
//
//        /*
//        FileAccessText.inicializarFichero();
//        FileAccessText.escribirClientesFichero(lista, Validacion.pedirFormato());
//         */
//
        System.out.println(FileAccessObject.buscarClientePorPosicion(FileAccessObject.buscarPosicionFicheroIndice(c2.getDni())));
//

    }
}
