package dal.cliente;

import dal.conexion.Conexion;
import modelo.entidades.Cliente;
import vista.mensaje.Salida;
import vista.validacion.Validacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    /**
     * Cabecera: public static int comprobarSiExisteCliente()
     *
     * Descripcion: Este metodo se encarga de llamar a la bdd para ver si algun dni o telefono de los clientes
     * coincide con los introducidos por el usuario.
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Devuelve el id del cliente, -1 si no existe.
     * @return int id
     */
    public static int comprobarSiExisteCliente(){
        int id = -1;
        String consulta = "SELECT ID FROM Cliente WHERE DNI = ? OR Telefono = ?";
        String dniOTelefono = Validacion.validarDniOTelefonoCliente();

        try(Connection conexion = Conexion.realizarConexion()){
            PreparedStatement st = conexion.prepareStatement(consulta);
            st.setString(1, dniOTelefono);
            st.setString(2, dniOTelefono);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                id = rs.getInt("ID");
            }
            rs.close();
            st.close();
        }catch(SQLException e){
            Salida.errorInesperado();
        }
        return id;
    }
    public static void insertarCliente() {
        Cliente cliente= crearCliente();
        String insercion= "INSERT INTO Cliente VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.realizarConexion()) {
            PreparedStatement s = conexion.prepareStatement(insercion);
            System.out.println("Insertando en tabla...");
            System.out.println();
            s.setString(1, cliente.getNombre());
            s.setString(2, cliente.getDni());
            s.setString(3, cliente.getDireccion());
            s.setString(4, cliente.getCodigoPostal());
            s.setString(5, cliente.getCiudad());
            s.setString(6, cliente.getTelefono());
            s.setString(7, cliente.getCorreo());
            s.executeUpdate();
        } catch (SQLException throwables) {
            Salida.errorInesperado();
        }
    }

    public static void modificarCliente() {
        String dni = Validacion.validarDni();
        String columna= Validacion.seleccionarColumnaCliente();
        String valor = elegirMensajeValidacion(columna);
        String modificar= "UPDATE Cliente SET "+ columna +" = (?) WHERE DNI = (?)";

        try (Connection conexion = Conexion.realizarConexion()) {
            PreparedStatement s = conexion.prepareStatement(modificar);
            s.setString(1, valor);
            s.setString(2, dni);
            int resultado = s.executeUpdate();
            Validacion.validarResultadoModificar(resultado);
        } catch (SQLException throwables) {
            Salida.errorInesperado();
        }
    }

    private static String elegirMensajeValidacion(String columna){
        String valor = " ";
        switch (columna){
            case "Direccion", "Ciudad", "Correo" -> valor = Validacion.pedirValor();
            case "CodigoPostal" -> valor = Validacion.validarCodigoPostal();
            case "Telefono" -> valor = Validacion.validarTelefono();
        }
        return valor;
    }

    public static void eliminarCliente() {
        String dni = Validacion.validarDni();
        String eliminar= "DELETE FROM Cliente WHERE DNI= (?)";

        try (Connection conexion = Conexion.realizarConexion()) {
            PreparedStatement s = conexion.prepareStatement(eliminar);
            s.setString(1, dni);
            int resultado = s.executeUpdate();
            Validacion.validarResultadoEliminar(resultado);
        } catch (SQLException throwables) {
            Salida.errorInesperado();
        }
    }
    private static Cliente crearCliente() {
        return new Cliente(Validacion.validarNombre(), Validacion.validarDni(), Validacion.validarDireccion(),
                Validacion.validarCodigoPostal(), Validacion.validarCiudad(),
                Validacion.validarTelefono(), Validacion.validarCorreo());
    }
    public static List<Cliente> getListadoClientes(){
        List<Cliente> listadoClientes = new ArrayList<>();
        String url = "SELECT * FROM Cliente";

        try(Connection conexion = Conexion.realizarConexion()){
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery(url);
            while (rs.next()) {
                listadoClientes.add(crearCliente(rs));
            }
        } catch (SQLException e) {
            Salida.errorInesperado();
        }
        return listadoClientes;
    }
    private static Cliente crearCliente(ResultSet rs) throws SQLException {
        Cliente cliente;
        String consulta = "";

        ResultSetMetaData rsm = rs.getMetaData();
        for (int i = 1; i <= rsm.getColumnCount(); i++) {
            consulta += rs.getString(i) + "_";
        }
        cliente = generarCliente(consulta);

        return cliente;
    }
    private static Cliente generarCliente(String consulta){
        Cliente clienteAux = new Cliente();
        String [] atributos;

        atributos = consulta.split("_");
        clienteAux.setId(Integer.parseInt(atributos[0]));
        clienteAux.setNombre(atributos[1]);
        clienteAux.setDni(atributos[2]);
        clienteAux.setDireccion(atributos[3]);
        clienteAux.setCodigoPostal(atributos[4]);
        clienteAux.setCiudad(atributos[5]);
        clienteAux.setTelefono(atributos[6]);
        clienteAux.setCorreo(atributos[7]);

        return clienteAux;
    }
    public static Cliente getClienteConcreto(int id){
        Cliente cliente = new Cliente();
        String url = "SELECT * FROM Cliente WHERE Id = " +id;

        try(Connection conexion = Conexion.realizarConexion()){
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery(url);
            rs.next();
            cliente = crearCliente(rs);
        } catch (SQLException e) {
            Salida.errorInesperado();
        }
        return cliente;
    }
}
