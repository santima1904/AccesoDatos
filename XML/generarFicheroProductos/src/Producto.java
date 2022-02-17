public class Producto {

    //Atributos
    private int id;
    private int stock;
    private String caracteristicas;
    private String color;
    private int peso;

    //Constructor
    public Producto(int id, int stock, String caracteristicas, String color, int peso) {
        this.id = id;
        this.stock = stock;
        this.caracteristicas = caracteristicas;
        this.color = color;
        this.peso = peso;
    }

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
