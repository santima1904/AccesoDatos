package dal;

import mensaje.Salida;
import validacion.Validacion;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    private static final String USER_KEY="user";
    private static final String PASSWORD_KEY="password";
    private static final String HOST_KEY="host";
    private static final String PUERTO_KEY="puerto";
    private static final String NOMBRE_BBDD_KEY="nombreBbDd";
    private static final String NOMBRE_BBDD_MASTER="master";
    private static final String RUTA_FICHERO_CONFIGURACION =".\\configuracion.properties";
    public static final String NOMBRE_BBDD = "MartinezAralViveros";

    /**
     * Cabecera: public static void escribirPropiedadesConexion()
     *
     * Descripcion: Este metodo se encarga de escribir las propiedas necesarias para realizar
     * la conexion con la base de datos en un fichero properties
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Escribe el fichero properties con los datos indicados por el usuario.
     */
    public static void escribirPropiedadesConexion(String usuario,String contrasenya,
                                                   String host,String puerto){
        Properties propiedadesConexion = new Properties();

        propiedadesConexion.put(USER_KEY,usuario);
        propiedadesConexion.put(PASSWORD_KEY,contrasenya);
        propiedadesConexion.put(HOST_KEY, host);
        propiedadesConexion.put(NOMBRE_BBDD_KEY, NOMBRE_BBDD_MASTER);
        propiedadesConexion.put(PUERTO_KEY, puerto);
        propiedadesConexion.put("useUnicode","true");
        propiedadesConexion.put("characterEncoding","utf8");
        try{
            propiedadesConexion.store(new FileWriter(RUTA_FICHERO_CONFIGURACION), "");
        }catch(IOException e){
            Salida.errorInesperado();
        }
    }
    /**
     * Cabecera:  private static Properties leerPropiedadesConexion()
     *
     * Descripcion: Este metodo se encarga de comprobar si el fichero properties existe, en caso afirmativo no hace
     * nada, en caso negativo, lo rellena.
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Hace que el fichero properties tenga datos y luego lo carga
     *
     * @return Properties propiedadesConexion
     */
    public static Properties leerPropiedadesConexion(){
        Properties propiedadesConexion = new Properties();
        File ficheroConfiguracion = new File(RUTA_FICHERO_CONFIGURACION);

        if(!ficheroConfiguracion.exists()){
            escribirPropiedadesConexion(Validacion.pedirUsuario(),Validacion.pedirContrasenya(),
                    Validacion.pedirServidorBbDd(),Validacion.pedirPuerto());
        }
        cargarFichero(propiedadesConexion);
        return propiedadesConexion;
    }
    /**
     * Cabecera: private static void cargarFichero(Properties propiedadesConexion)
     *
     * Descripcion: Este metodo se encarga de cargar el fichero properties pasado por parametros con los datos
     * guardados en el fichero del programa.
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Carga el fichero properties pasado por parametros
     *
     * @param propiedadesConexion Properties
     */
    private static void cargarFichero(Properties propiedadesConexion){
        try{
            propiedadesConexion.load(new FileReader(RUTA_FICHERO_CONFIGURACION));
        }catch(IOException e){
            Salida.errorInesperado();
        }
    }
    /**
     * Cabecera: private static void sobreescribirPropiedadesConexion()
     *
     * Descripcion: Este metodo se encarga sobreescribir el fichero properties con el nombre de la
     * base de datos
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Sobreescribir el nombre de la base de datos
     */
    public static void sobreescribirPropiedadesConexion(){
        Properties propiedadesConexion = leerPropiedadesConexion();
        propiedadesConexion.replace(NOMBRE_BBDD_KEY, NOMBRE_BBDD);

        try{
            propiedadesConexion.store(new FileWriter(RUTA_FICHERO_CONFIGURACION), "");
        }catch(IOException e){
            Salida.errorInesperado();
        }
    }
    /**
     * Cabecera: public static Connection realizarConexion()
     *
     * Descripcion: Este metodo se encarga de realizar la conexion a la base de datos con los datos del
     * fichero properties.
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Devuelve el objeto conexion
     * @return Connection conexion
     */
    public static Connection realizarConexion(){
        Properties propiedadesConexion = Conexion.leerPropiedadesConexion();
        String url = "jdbc:sqlserver://"+propiedadesConexion.getProperty(HOST_KEY)+":"
                +propiedadesConexion.getProperty(PUERTO_KEY) +";database="
                +propiedadesConexion.getProperty(NOMBRE_BBDD_KEY);
        Connection conexion = null;

        try{
            conexion = DriverManager.getConnection(url+";allowMultiQueries=true", propiedadesConexion);
        } catch (SQLException e) {
            Salida.errorInesperado();
        }
        return conexion;
    }
    /**
     * Cabecera: public static void cerrarConexion(Connection connection)
     *
     * Descripcion: Este metodo se encarga de cerrar el objeto Connection pasado por parametros.
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Cierra la conexion
     * @param connection Connection
     */
    public static void cerrarConexion(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
