import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public class FciheroAccesoAleatorio {

    //Propiedades
    private File fichero;
    private HashMap<String, Integer> campos;
    private long longitudRegistros;
    private long numeroRegistro = 0;

    //Constructor
    public FciheroAccesoAleatorio(String nombreFichero, HashMap<String, Integer> campos){
        this.campos = campos;
        this.fichero = new File(nombreFichero);
        longitudRegistros = 0;

        for (Map.Entry<String, Integer> campo : campos.entrySet()) {
            this.longitudRegistros += campo.getValue();
        }

        if (fichero.exists()) {
            this.numeroRegistro = fichero.length() / this.longitudRegistros;
        }
    }

    //Get de numeroRegistro
    public long getNumeroRegistro() {
        return numeroRegistro;
    }


    public void anhadir(HashMap<String, String> registro){
        insertar(registro, this.numeroRegistro++);
    }

    public void insertar(HashMap<String, String> registro, long posicion){

        try (RandomAccessFile faa = new RandomAccessFile(fichero, "rws")) {
            faa.seek(posicion * this.longitudRegistros);
            for (Map.Entry<String, Integer> campo : this.campos.entrySet()) {

                String nombreCampo = campo.getKey();
                Integer longCampo = campo.getValue();
                String valorCampo = registro.get(nombreCampo);

                if (valorCampo == null) {
                    valorCampo
                            = "";
                }
                String valorCampoForm = String.format("%1$- " + longCampo + "s", valorCampo);
                faa.write(valorCampoForm.getBytes("UTF-8"), 0, longCampo);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
