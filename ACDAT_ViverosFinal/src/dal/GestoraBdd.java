package dal;

import mensaje.Salida;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class GestoraBdd {
    /**
     * Cabecera: public static void ejecutarScript(String rutaFichero)
     *
     * Descripcion: Este metodo se encarga de ejecutar el script que se encuentre en la ruta especificada.
     *
     * Precondiciones: Que la ruta sea valida
     * Postcondiciones: Ejecuta el script de la ruta especificada
     * @param rutaFichero String
     */
    public static void ejecutarScript(String rutaFichero){
        String instruccionLeida,instruccionCreacion;
        StringBuilder instruccionCompleta= new StringBuilder();

        try(BufferedReader bRead = new BufferedReader(new FileReader(rutaFichero))){
            try(Connection conexion = Conexion.realizarConexion()){
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
                Salida.errorInesperado();
            }
        }catch(IOException e){
            Salida.errorInesperado();
        }
    }
    /**
     * Cabecera: public static void creacionBbd()
     *
     * Descripcion: Este metodo se encarga de ejecutar los scripts iniciales para crear la base de datos
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Creas la base de datos y sobreescribes el fichero properties.
     */
    public static void creacionBdd(){
        if(!isBddExistente()){
            ejecutarScript(".\\viveros.sql");
            ejecutarScript(".\\procedimientos.sql");
            ejecutarScript(".\\procedimientos2.sql");
            ejecutarScript(".\\procedimientos3.sql");
            ejecutarScript(".\\inserts.sql");
        }
        Conexion.sobreescribirPropiedadesConexion();
    }
    /**
     * Cabecera: private static boolean isBddExistente()
     *
     * Descripcion: Este metodo se encarga de comprobar si la base de datos existe.
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Devuelve un boolean indicando si existe o no la base de datos.
     * @return boolean bddExistente
     */
    private static boolean isBddExistente(){
        String consulta = "SELECT name FROM sysdatabases WHERE name = '"+Conexion.NOMBRE_BBDD+"'";
        boolean bddExistente=false;

        try(Connection conexion = Conexion.realizarConexion()){
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            bddExistente = rs.isBeforeFirst();
            rs.close();
            st.close();
        }catch(SQLException e){
            Salida.errorInesperado();
        }
        return bddExistente;
    }
}
