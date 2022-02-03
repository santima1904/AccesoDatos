/**
 * Clase para crear el script de la base de datos dada
 */

package modelo.dataaccess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccessScript {

    public void ejecutarScript(String rutaFichero){
        MiConexion miConexion = new MiConexion();
        String url = "jdbc:sqlserver://"+miConexion.getHost()+":"+miConexion.getPuerto() +";database="+miConexion.getBbdd();
        String instruccionLeida;
        StringBuilder instruccionCompleta= new StringBuilder();
        String instruccionCreacion=null;

        try(BufferedReader bRead = new BufferedReader(new FileReader(rutaFichero))){
            try(Connection conexion = DriverManager.getConnection(url+";allowMultiQueries=true",miConexion.getUsuario(),miConexion.getContasenha())){
                instruccionCreacion=bRead.readLine();
                while((instruccionLeida = bRead.readLine()) != null){
                    instruccionCompleta.append(instruccionLeida);
                }
                instruccionCompleta = new StringBuilder(instruccionCompleta.toString().replaceAll("GO", ";"));
                Statement st = conexion.createStatement();
                st.execute(instruccionCreacion);
                st.execute(instruccionCompleta.toString());
                st.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
