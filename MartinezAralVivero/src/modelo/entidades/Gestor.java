package modelo.entidades;

public class Gestor {

    private int id;
    private String nombre;
    private String dni;
    private String direccion;
    private String codigoPostal;
    private String ciudad;
    private String telefono;
    private String correo;
    private String usuario;
    private String contrasena;


    public Gestor(String nombre, String dni, String direccion, String codigoPostal, String ciudad, String telefono, String correo, String usuario, String contrasena) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    public Gestor() {

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //toString
    @Override
    public String toString() {
        return "Nombre: " + nombre +", dni: "+ dni +", CP: "+ codigoPostal +", ciudad: "+ ciudad +", telefono: "+ telefono +", correo: "+ correo+", usuario: "+ usuario +", contraseña: "+ contrasena;
    }
}
