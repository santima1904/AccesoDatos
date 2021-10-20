import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Errores {

    //Atributos
    private String nombre;

    //Propiedades estáticas
    private static File fichero;
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    //Constructor
    public Errores(String nombre) {
        this.nombre = nombre;
        fichero = new File(nombre);
    }

    /**
     * Cabecera: public void escribirError(String mensaje)
     * Descripción: Método para registrar el error en el fichero
     * Precondiciones: fichero creado
     * Postcondiciones: error registrado en fichero
     *
     * @param mensaje
     */
    public void escribirError(String mensaje) {

        try (FileWriter fw = new FileWriter(fichero, true)) {
            fw.write(DTF.format(LocalDateTime.now()) + " Error: " + mensaje);
            fw.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Cabecera: public void escribirError(String mensaje)
     * Descripción: Método para registrar el error en el fichero
     * Precondiciones: fichero creado
     * Postcondiciones: error registrado en fichero
     *
     * @param mensaje
     */
    public void escribirAdvertencia(String mensaje) {

        try (FileWriter fw = new FileWriter(fichero, true)) {
            fw.write(DTF.format(LocalDateTime.now()) + " Advertencia: " + mensaje);
            fw.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Cabecera: public void escribirError(String mensaje)
     * Descripción: Método para registrar el error en el fichero
     * Precondiciones: fichero creado
     * Postcondiciones: error registrado en fichero
     *
     * @param mensaje
     */
    public void escribirInformación(String mensaje) {

        try (FileWriter fw = new FileWriter(fichero, true)) {
            fw.write(DTF.format(LocalDateTime.now()) + " Inforamcion: " + mensaje);
            fw.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
