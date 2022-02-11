public class Producto {
    //Atributos
    private int id;
    private String descripcion;
    private double precio;

    //Constructores
    public Producto(){

    }
    public Producto(int id, String descripcion, double precio){
        this.id = id;
        this.descripcion=descripcion;
        this.precio=precio;
    }

    //Getters & Setters
    public int getId() {return id;}
    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
