package controlador;

import modelo.clasesBasicas.Cliente;
import modelo.ficheros.FileAccessBinaryRead;
import modelo.ficheros.FileAccessBinaryWrite;
import modelo.ficheros.FileAccessText;
import vista2.Menu;
import vista2.Validacion;

public class Main {
    public static void main(String[] args) {

        boolean salir = false;
        String dniBorrado;
        FileAccessText.escribirCodificacionFichero("UTF-8");

        while(!salir){
            Menu.menu();
            switch (Validacion.pedirOpcion()){

                case 1:
                    Menu.insertarCliente();
                    FileAccessBinaryWrite.escribirCliente(new Cliente(Validacion.pedirNombre(), Validacion.pedirApellidos(), Validacion.pedirDni(), Validacion.pedirTlfn(), Validacion.pedirDireccion()));
                    break;

                case 2:
                    Menu.mostrarCliente(FileAccessBinaryRead.buscarClientePorPosicion(FileAccessBinaryRead.buscarPosicionFicheroIndice(Validacion.pedirDni())));
                    break;

                case 3:
                    dniBorrado = Validacion.pedirDni();
                    FileAccessBinaryRead.leerClientesFicheroIndiceEnAuxiliar();
                    FileAccessBinaryRead.leerClientesFicheroAux(dniBorrado);
                    Menu.mostrarMensajeComprobacionPersonaBorrada(comprobarPersonaBorrada(FileAccessBinaryRead.buscarPosicionFicheroIndice(dniBorrado)));
                    break;

                case 4:
                    FileAccessText.escribirCodificacionFichero(Validacion.pedirFormato());
                    break;

                case 5:
                    FileAccessBinaryRead.exportarFicheroCliente();
                    break;

                case 0:
                    Menu.salir();
                    salir = Validacion.pedirSalir();
                    break;
            }
        }
    }


    /**
     * <h1>Cabecera: </h1>private static String comprobarPersonaBorrada(int posicion)<br/>
     * <h1>Descripción: </h1> Método para comprobar si se ha realizado con éxito la función de borrar un cliente del fichero<br/>
     * <br/>
     * @param posicion
     * @return mensaje
     */
    private static String comprobarPersonaBorrada(int posicion){
        String mensaje = "Se ha borrado correctamente";
        if (posicion != -1){
            mensaje = "Ha ocurrido un error";
        }
        return mensaje;
    }
}
