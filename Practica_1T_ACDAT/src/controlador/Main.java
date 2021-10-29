package controlador;

import modelo.Cliente;
import modelo.ficheros.FileAccessObject;
import modelo.ficheros.FileAccessText;
import vista.Validacion;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        List<String>lista = new ArrayList<>();

        FileAccessObject.escribirCliente(c1);
        FileAccessObject.escribirCliente(c2);
        lista = FileAccessObject.leerClientes();

        FileAccessText.inicializarFichero();
        FileAccessText.escribirClientesFichero(lista, Validacion.pedirFormato());


        /*
        FileAccessObject.escribirFicheroIndice(c1.getDni(), FileAccessObject.buscarPosicion(c1.getDni()));
        System.out.println(FileAccessObject.buscarClientePorPosicion(FileAccessObject.buscarPosicionFicheroIndice(c1.getDni())));

         */
    }
}
