package modelo.dataaccess;

import java.io.Serializable;

public class MiConexion implements Serializable {

    //Atributos
    private String host;
    private String bbdd;
    private String usuario;
    private String contasenha;
    private String puerto;

    //Constructores
    public MiConexion(String url, String bbdd, String usuario, String contasenha, String puerto) {
        this.host = url;
        this.bbdd = bbdd;
        this.usuario = usuario;
        this.contasenha = contasenha;
        this.puerto = puerto;
    }

    public MiConexion() {
        this.host = "107-12";
        this.bbdd = "MartinezAral";
        this.usuario = "santi";
        this.contasenha = "mitesoro";
        this.puerto = "49676";
    }

    //Getters and setters

    public String getUrl() {
        return host;
    }

    public void setUrl(String url) {
        this.host = url;
    }

    public String getBbdd() {
        return bbdd;
    }

    public void setBbdd(String bbdd) {
        this.bbdd = bbdd;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContasenha() {
        return contasenha;
    }

    public void setContasenha(String contasenha) {
        this.contasenha = contasenha;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getHost() {
        return host;
    }

    //toString

    @Override
    public String toString() {
        return
                "Url=" + host + '\'' +
                        "Bbdd=" + bbdd + '\'' +
                        "Usuario=" + usuario + '\'' +
                        "Contasenha=" + contasenha + '\'' +
                        "Puerto=" + puerto;
    }
}