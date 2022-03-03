package dal.usuario;

import dal.Conexion;
import mensaje.Salida;

import java.sql.*;

public class UsuarioDao {
    public static int logInVendedor(String nombreUsuario, String contrasenya){
        int id=-1;
        String consulta = "SELECT ID FROM UsuarioVendedor WHERE NombreUsuario = ? AND Contrasenya = ?";

        try(Connection conexion = Conexion.realizarConexion()){
            PreparedStatement st = conexion.prepareStatement(consulta);
            st.setString(1, nombreUsuario);
            st.setString(2, contrasenya);
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
    public static int logInGestor(String nombreUsuario, String contrasenya){
        int id=-1;
        String consulta = "SELECT ID FROM UsuarioGestor WHERE NombreUsuario = ? AND Contrasenya = ?";

        try(Connection conexion = Conexion.realizarConexion()){
            PreparedStatement st = conexion.prepareStatement(consulta);
            st.setString(1, nombreUsuario);
            st.setString(2, contrasenya);
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
}
