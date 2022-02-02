package modelo.clasesBasicas.personas;

public class Cliente extends Persona{

    //Constructor
    //Con parámetros
    public Cliente(int id, String nombre, String dni, String codigoPostal, String ciudad, String telefono, String correo) {
        super(id, nombre, dni, codigoPostal, ciudad, telefono, correo);
    }

    //Por defecto
    public Cliente() {
    }
}
