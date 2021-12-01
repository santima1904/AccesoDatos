package test;

import modelo.ficheros.FileAccessBinaryRead;
import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileAccessBinaryReadTest {

    static final String FICHERO_CLIENTES = "clientes.bin";
    static final String FICHERO_INDICE = "indice_clientes.bin";
    static final String FICHERO_AUX = "fichero_aux.bin";
    static final String FICHERO_EXPORTADO = "listado_clientes.bin";
    static final String PRUEBA_INDICE = "1,prueba";


    static File ficheroClientes;
    static File ficheroIndice;
    static File ficheroAux;
    static File ficheroExportado;


    @BeforeAll
    static void beforeAll() {
        ficheroClientes = new File(FICHERO_CLIENTES);
        ficheroIndice = new File(FICHERO_INDICE);
        ficheroAux = new File(FICHERO_AUX);
        ficheroExportado = new File(FICHERO_EXPORTADO);
    }

    @BeforeEach
    void setUp() {
        inicializarFichero(ficheroClientes);
        inicializarFichero(ficheroIndice);
        inicializarFichero(ficheroAux);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void leerClientesFicheroIndiceEnAuxiliar() {
        escribirFichero(PRUEBA_INDICE, ficheroIndice);
        FileAccessBinaryRead.leerClientesFicheroIndiceEnAuxiliar();
        assertEquals(PRUEBA_INDICE, leerFichero(ficheroAux));
    }

    @Test
    void exportarFicheroCliente() {
        escribirFichero(PRUEBA_INDICE, ficheroIndice);
        FileAccessBinaryRead.exportarFicheroCliente();
        assertEquals(PRUEBA_INDICE,leerFichero(ficheroExportado));
    }

    @Test
    void leerClientesFicheroAux() {
    }

    @Test
    void getLongitudFichero() {
    }

    @Test
    void buscarPosicionFicheroIndice() {
    }

    @Test
    void buscarClientePorPosicion() {
    }

    //Métodos privados para los tests
    /**
     * Metodo para los test
     * Lee el contenido de un fichero
     * @param fichero
     * @return
     */
    private static String leerFichero(File fichero){
        String contenido = " ";
        try(BufferedReader br = new BufferedReader(new FileReader(fichero))){
            contenido = br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido;
    }

    /**
     * Metodo para los test
     * Inicializa el fichero escribiendo un espacio vacio
     *
     * @param fichero
     */
    static void inicializarFichero(File fichero){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, false))){
            bw.write("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para los test
     * Inicializa el fichero escribiendo un espacio vacio
     *
     * @param fichero
     * @param linea
     */
    static void escribirFichero(String linea,File fichero){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, false))){
            bw.write(linea);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}