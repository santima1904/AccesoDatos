package controlador;

import modelo.clasesBasicas.personas.Cliente;
import modelo.dataaccess.consultas.ConsultasCliente;
import vista.Menu;
import vista.Validaciones;

import java.util.List;

public class Gestora {

    /**
     * <b>Cabecera: </b>public static int getIdClientePorDni(String dni)</br>
     * <b>Description: </b>Metodo para obtener el id de un cliente a partir de un dni dado</br>
     * <b>Precondiciones: </b>dni distinto de null</br>
     * <b>Postcondiciones: </b>id devuelto. Si es -1, el cliente no existe.</br>
     *
     * @param dni
     * @return int id
     */
    private static int getIdClientePorDni(String dni){
        int id = -1;
        List<Cliente> listadoClientes = ConsultasCliente.getListadoClientes();

        for (int i = 0;i<listadoClientes.size();i++){
            if (listadoClientes.get(i).getDni().equals(dni)){
                id = listadoClientes.get(i).getId();
            }
        }

        return id;
    }

    public static int validarIdCliente(){
        int id = 0;

        do{
            id = getIdClientePorDni(Menu.menuPedirDniCliente());
        }while(!Validaciones.validarIdClientePorDni(id));

        return id;
    }
}
