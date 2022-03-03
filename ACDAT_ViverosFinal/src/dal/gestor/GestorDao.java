package dal.gestor;

import dal.Conexion;
import entidades.Gestor;
import mensaje.Salida;
import validacion.Validacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorDao {
    /**
     * <b>Cabecera: </b>public static List<UsuarioGestor> getListadoGestores()</br>
     * <b>Description: </b>Metodo para obtener un listado con todos los gestores de la base de datos</br>
     * <b>Precondiciones: </b>Ninguna</br>
     * <b>Postcondiciones: </b>Lista rellena con los gestores</br>
     *
     * @return
     */
    public static List<Gestor> getListadoGestores(){
        List<Gestor> listadoGestores = new ArrayList<>();
        String url = "SELECT * FROM UsuarioGestor";

        try(Connection conexion = Conexion.realizarConexion()){
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery(url);
            while (rs.next()) {
                listadoGestores.add(crearGestor(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listadoGestores;
    }
    /**
     * <b>Cabecera: </b>private static UsuarioGestor crearGestor(ResultSet rs) throws SQLException</br>
     * <b>Description: </b>Metodo para leer un gestor de la base de datos</br>
     *
     * @param rs
     * @return
     */
    private static Gestor crearGestor(ResultSet rs) throws SQLException {
        Gestor gestor;
        String consulta = "";

        ResultSetMetaData rsm = rs.getMetaData();
        for (int i = 1; i <= rsm.getColumnCount(); i++) {
            consulta += rs.getString(i) + "_";
        }
        gestor = generarGestor(consulta);
        return gestor;
    }
    /**
     * <b>Cabecera: </b>private static UsuarioGestor generarGestor(String consulta)</br>
     * <b>Description: </b>Metodo para crear un gestor</br>
     *
     * @param consulta
     * @return
     */
    private static Gestor generarGestor(String consulta){
        Gestor gestorAux = new Gestor();
        String [] atributos;

        atributos = consulta.split("_");
        gestorAux.setId(Integer.parseInt(atributos[0]));
        gestorAux.setNombre(atributos[1]);
        gestorAux.setDni(atributos[2]);
        gestorAux.setCodigoPostal(atributos[3]);
        gestorAux.setCiudad(atributos[4]);
        gestorAux.setTelefono(atributos[5]);
        gestorAux.setCorreo(atributos[6]);
        gestorAux.setUsuario(atributos[7]);
        gestorAux.setContrasena(atributos[8]);
        return gestorAux;
    }
    public static void insertarGestor() {
        Gestor empleado= crearEmpleado();
        String insercion= "INSERT INTO UsuarioGestor VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexion = Conexion.realizarConexion()) {
            PreparedStatement s = conexion.prepareStatement(insercion);
            System.out.println("Insertando en tabla...");
            System.out.println();
            s.setString(1, empleado.getNombre());
            s.setString(2, empleado.getDni());
            s.setString(3, empleado.getDireccion());
            s.setString(4, empleado.getCodigoPostal());
            s.setString(5, empleado.getCiudad());
            s.setString(6, empleado.getTelefono());
            s.setString(7, empleado.getCorreo());
            s.setString(8, empleado.getUsuario());
            s.setString(9, empleado.getContrasena());
            s.executeUpdate(); //para los insert y alter
        } catch (SQLException throwables) {
            Salida.errorInesperado();
        }
    }
    public static void modificarGestor() {
        int id= Validacion.validarId();
        String columna= Validacion.seleccionarColumnaVendedor();
        String valor= Validacion.pedirValor();
        String modificar= "UPDATE UsuarioGestor SET "+ columna +" = (?) WHERE id = (?)";

        try (Connection conexion = Conexion.realizarConexion()) {
            PreparedStatement s = conexion.prepareStatement(modificar);
            System.out.println("Modificando...");
            System.out.println();
            s.setString(1, valor);
            s.setInt(2, id);
            s.executeUpdate();
        } catch (SQLException throwables) {
            Salida.errorInesperado();
        }
    }
    public static void eliminarGestor() {
        int id= Validacion.validarId();
        String eliminar= "DELETE FROM UsuarioGestor WHERE id= (?)";

        try (Connection conexion = Conexion.realizarConexion()) {
            PreparedStatement s = conexion.prepareStatement(eliminar);
            System.out.println("Eliminando...");
            System.out.println();
            s.setString(1, String.valueOf(id));
            s.executeUpdate(); //para los insert y alter
        } catch (SQLException throwables) {
            Salida.errorInesperado();
        }
    }
    private static Gestor crearEmpleado() {
        return new Gestor(Validacion.validarNombre(), Validacion.validarDni(), Validacion.validarDireccion(),
                Validacion.validarCodigoPostal(), Validacion.validarCiudad(), Validacion.validarTelefono(),
                Validacion.validarCorreo(), Validacion.validarUsuario(), Validacion.validarContrasena());
    }
}
