package controlador;

import modelo.clasesBasicas.Cliente;
import modelo.ficheros.FileAccessObject;
import modelo.ficheros.FileAccessText;
import vista2.Menu;
import vista2.Validacion;

public class Main {
    public static void main(String[] args) {

        boolean salir = false;
        FileAccessText.inicializarFichero();

        while(!salir){
            Menu.menu();
            switch (Validacion.pedirOpcion()){

                case 1:
                    Menu.insertarCliente();
                    FileAccessObject.escribirCliente(new Cliente(Validacion.pedirNombre(), Validacion.pedirApellidos(), Validacion.pedirDni(), Validacion.pedirTlfn(), Validacion.pedirDireccion()));
                    break;

                case 2:
                    Menu.mostrarCliente(FileAccessObject.buscarClientePorPosicion(FileAccessObject.buscarPosicionFicheroIndice(Validacion.pedirDni())));
                    break;

                case 3:
                    FileAccessObject.borrarClienteFicheroIndice(Validacion.pedirDni(), FileAccessObject.leerClientes(false));
                    break;

                case 4:
                    FileAccessText.escribirCodificacionFichero(Validacion.pedirFormato());
                    break;

                case 5:
                    FileAccessText.escribirClientesFichero(FileAccessObject.leerClientes(true));
                    break;

                case 0:
                    Menu.salir();
                    salir = Validacion.pedirSalir();
                    break;

            }
        }
    }
}
