package controlador;

import modelo.clasesBasicas.Cliente;
import modelo.ficheros.FileAccessBinary;
import modelo.ficheros.FileAccessText;
import vista2.Menu;
import vista2.Validacion;

public class Main {
    public static void main(String[] args) {
        //TODO Hacer todos los sumaries, revisar los hechos que hay que cambiarlos

        boolean salir = false;
        String dniBorrado;
        FileAccessText.inicializarFichero();

        while(!salir){
            Menu.menu();
            switch (Validacion.pedirOpcion()){

                case 1:
                    Menu.insertarCliente();
                    FileAccessBinary.escribirCliente(new Cliente(Validacion.pedirNombre(), Validacion.pedirApellidos(), Validacion.pedirDni(), Validacion.pedirTlfn(), Validacion.pedirDireccion()));
                    break;

                case 2:
                    Menu.mostrarCliente(FileAccessBinary.buscarClientePorPosicion(FileAccessBinary.buscarPosicionFicheroIndice(Validacion.pedirDni())));
                    break;

                case 3:
                    dniBorrado = Validacion.pedirDni();
                    FileAccessBinary.leerClientesFicheroIndice();
                    FileAccessBinary.leerClientesFicheroAux(dniBorrado);
                    Menu.mostrarMensajeComprobacionPersonaBorrada(comprobarPersonaBorrada( FileAccessBinary.buscarPosicionFicheroIndice(dniBorrado)));
                    break;

                case 4:
                    FileAccessText.escribirCodificacionFichero(Validacion.pedirFormato());
                    break;

                case 5:
                    FileAccessBinary.exportarFicheroCliente();
                    break;

                case 0:
                    Menu.salir();
                    salir = Validacion.pedirSalir();
                    break;
            }
        }
    }


    private static String comprobarPersonaBorrada(int posicion){
        String mensaje = "Se ha borrado correctamente";
        if (posicion != -1){
            mensaje = "Ha ocurrido un error";
        }
        return mensaje;
    }
}
