/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> campos = new HashMap<>();

        campos.put("DNI", 9);
        campos.put("NOMBRE", 32);
        campos.put("CP", 5);

            FciheroAccesoAleatorio faa = new FciheroAccesoAleatorio("fic_acceso_aleat.dat", campos);

            HashMap registro = new HashMap();
            registro.put("DNI", "56789012B");
            registro.put("NOMBRE", "SAMPER");
            registro.put("CP", "29730");
            faa.insertar(registro);
            registro.clear();
            registro.put("DNI", "89012345E");
            registro.put("NOMBRE", "ROJAS");
            faa.insertar(registro);
            registro.clear();
            registro.put("DNI", "23456789D");
            registro.put("NOMBRE", "DORCE");
            registro.put("CP", "13700");
            faa.insertar(registro);
            registro.clear();
            registro.put("DNI", "78901234X");
            registro.put("NOMBRE", "NADALES");
            registro.put("CP", "44126");
            faa.insertar(registro, 1);

    }
}

 */


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antonio
 */
public class Main implements Closeable {

    private static final String NOMBRE_FICHERO = "registros.txt";

    private static final int LONGITUD_REGISTRO = 25;
    private static final int NUMERO_RESGISTROS = 4;
    private static final String REGISTRO_ESTANDAR = "Un registro estándar";

    private static final int POSICION_A_MODIFICAR = 2;
    private static final String REGISTRO_ALTERNATIVO = "***Registro alternativo";

    private static final boolean ALINEAR_REGISTROS_IZQUIERDA = true;

    private final RandomAccessFile ficheroAccesoAleatorio;


    public static void main(String[] args) throws FileNotFoundException {
        try (Main accesoAleatorio = new Main();) { //Creo un objeto main en los recursos para que se cierre automaticamente

            accesoAleatorio.escribirRegistrosEstandar();
            accesoAleatorio.sustituirRegistroEstandarPorAlternativo();
            accesoAleatorio.leerContenido();


        } catch (IOException ex) {

            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Main() throws FileNotFoundException {

        eliminarFicheroAleatorioSiExiste();
        ficheroAccesoAleatorio = new RandomAccessFile(new File(NOMBRE_FICHERO), "rws"); //creao un objeto RandomAccessFile con un file y con permisos de escritura, lectura y sincronizacion
    }

    private void eliminarFicheroAleatorioSiExiste() {
        File fichero = new File(NOMBRE_FICHERO);

        if (fichero.exists()) {//si existe

            fichero.delete();//elimina el fichero
        }
    }

    @Override
    public void close() throws IOException {

        if (ficheroAccesoAleatorio != null) {// Si el fichero es diferente de nulo, se cierra

            ficheroAccesoAleatorio.close();
        }
    }

    public void escribirRegistrosEstandar() throws IOException {

        for (int i = 0; i < NUMERO_RESGISTROS; i++) {

            escribir(REGISTRO_ESTANDAR);
            //muestra el mensaje de registro estandar por cada registro estandar encontrado
        }
    }

    public void sustituirRegistroEstandarPorAlternativo() throws IOException {

        ficheroAccesoAleatorio.seek(POSICION_A_MODIFICAR * LONGITUD_REGISTRO);
        escribir(REGISTRO_ALTERNATIVO);
    }

    private void escribir(String cadena) throws IOException {

        ficheroAccesoAleatorio.write(formatearCadena(cadena).getBytes(),
                0, LONGITUD_REGISTRO);
    }

    private String formatearCadena(String cadena) {

        return String.format(obtenerFormatoPredefinido(), cadena);
    }

    private String obtenerFormatoPredefinido() {

        StringBuilder formato = new StringBuilder("%");

        if (ALINEAR_REGISTROS_IZQUIERDA) {

            formato.append('-');
        }

        formato.append(LONGITUD_REGISTRO);
        formato.append('s');

        return formato.toString();
    }

        /**
         * Cabecera: public static List<String> leerContenido(File fichero)
         * Precondiciones: fichero creado
         * Entradas: File fichero
         * Salida: Lista con el contenido del fichero
         * Postcondiciones: Devuelve una lista con el contenido del fichero
         */

        public void leerContenido(){

            BufferedReader br = null;
            String linea = null;
            List<String> lista = new ArrayList<>();

            try {
                br = new BufferedReader(new FileReader(new File(NOMBRE_FICHERO)));

                do{
                    linea = (String) br.readLine();

                    if(linea!=null){
                        lista.add(linea);
                    }

                }while(linea!=null);

            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            for (String contenido:lista) {

                System.out.println(linea);

            }

        }






}
