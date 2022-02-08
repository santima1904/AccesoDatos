package modelo.clasesBasicas.personas;

public abstract class Persona {

    //Atributos
    private int id;
    private String nombre;
    private String dni;
    private String codigoPostal;
    private String ciudad;
    private String telefono;
    private String correo;

    //Constructor
    //Con parámetros
    public Persona(int id, String nombre, String dni, String codigoPostal, String ciudad, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.correo = correo;
    }

    //Por defecto
    public Persona() {
        this.id = 0;
        this.nombre = " ";
        this.dni = " ";
        this.codigoPostal = " ";
        this.ciudad = " ";
        this.telefono = " ";
        this.correo = " ";
    }

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getCodigoPostal() {
        return codigoPostal;
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
}
