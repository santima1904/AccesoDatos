package controlador;

import modelo.clasesBasicas.personas.Cliente;
import modelo.dataaccess.consultas.ConsultasCliente;
import modelo.dataaccess.consultas.ConsultasInforme;
import modelo.dataaccess.consultas.ConsultasProductos;
import modelo.dataaccess.consultas.ConsultasUsuarios;
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
        boolean salir = false;
        List<Cliente> listadoClientes = ConsultasCliente.getListadoClientes();

        for (int i = 0;i<listadoClientes.size()&&!salir;i++){
            if (listadoClientes.get(i).getDni().equals(dni)){
                id = listadoClientes.get(i).getId();
                salir = true;
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

    public static boolean menuConsultas(){
        boolean salir = false;
        switch (Menu.menu_consultas()){
            case 1 -> ConsultasInforme.getInformeMensual(Menu.pedirMes());
            case 2 -> ConsultasInforme.getInformeAnual(Menu.pedirAnho());
            case 3 -> {
                Menu.mostrarListadoProductosJardineria(ConsultasProductos.getListadoProductosJardineria());
                Menu.mostrarListadoProductosPlanta(ConsultasProductos.getListadoPlantasConTipo());
            }
            case 4 -> Menu.mostrarListadoClientes(ConsultasCliente.getListadoClientes());
            case 5 -> Menu.mostrarListadoVendedores(ConsultasUsuarios.getListadoVendedores());
            case 6 -> Menu.mostrarListadoGestores(ConsultasUsuarios.getListadoGestores());
            case 7 -> Menu.mostrarFacturasClienteConcreto(ConsultasInforme.getFacturasCliente(validarIdCliente()));
            case 0 -> salir = true;
        }

        return salir;
    }
}
