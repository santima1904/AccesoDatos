package modelo.clasesBasicas.personas;

public class UsuarioVendedor extends Persona{

    //Atributos
    private String usuario;
    private String contrasenha;

    //Constructor
    //Con parámetros
    public UsuarioVendedor(int id, String nombre, String dni, String codigoPostal, String ciudad, String telefono, String correo, String usuario, String contrasenha) {
        super(id, nombre, dni, codigoPostal, ciudad, telefono, correo);
        this.usuario = usuario;
        this.contrasenha = contrasenha;
    }

    //Por defecto
    public UsuarioVendedor() {
        this.usuario = " ";
        this.contrasenha = " ";
    }

    //Getters and setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() +" "+ usuario +" "+ contrasenha;
    }
}
