/**
 * <h1>Clase:</h1> Cliente <br/>
 * <h1>Descripción:</h1> Clase para instanciar objetos del tipo Cliente, con los atributos especificados <br/>
 *
 * <h1>Atributos: </h1> <br/>
 * - nombre: cadena, consultable, modificable
 * - apellidos: cadena, consultable, modificable
 * - dni: cadena, consultable
 * - numTelefono: cadena, consultable, modificable
 * - direccion: cadena, consultable, modificable
 *
 * <h1>Métodos: </h1> <br/>
 * - public String getNombre()
 * - public void setNombre(String nombre)
 * - public String getApellidos()
 * - public void setApellidos(String apellidos)
 * - public String getDni()
 * - public String getNumTelfono()
 * - public void setNumTelefono(String numTelefono)
 * - public String getDireccion()
 * - public void setDireccion(String direccion)
 * - public void toString()
 */

package modelo;

public class Cliente {

    //Atributos
    private String nombre;
    private String apellidos;
    private String dni;
    private String numTelefono;
    private String direccion;

    //Constantes
    public final static int LONGITUD_MAX = 30;
    //Constructor
    //Constructor con parámetros
    public Cliente(String nombre, String apellidos, String dni, String numTelefono, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.numTelefono = numTelefono;
        this.direccion = direccion;
    }

    //Constructor por defecto
    public Cliente() {
        this.nombre = "Santi";
        this.apellidos = "PATATA";
        this.dni = "12345678T";
        this.numTelefono = "123456789";
        this.direccion = "PATATATTATATTA";
    }

    //Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    //Métodos de la clase Object

    /**
     * <h1>Cabecera: </h1>public String toString()<br/>
     * <h1>Descripción :</h1> Método para convertir a String todos los atributos de la clase
     *
     * @return String
     */
    @Override
    public String toString() {
        return  nombre + "," + apellidos + "," + dni + "," + numTelefono + "," + direccion;
    }
}