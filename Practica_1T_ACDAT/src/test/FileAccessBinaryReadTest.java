package test;

import modelo.clasesBasicas.Cliente;
import modelo.ficheros.FileAccessBinaryRead;
import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileAccessBinaryReadTest {

    static final String FICHERO_CLIENTES = "clientes.bin";
    static final String FICHERO_INDICE = "indice_clientes.bin";
    static final String FICHERO_AUX = "fichero_aux.bin";
    static final String FICHERO_EXPORTADO = "listado_clientes.bin";
    static final String PRUEBA_INDICE = "1,77866084K";

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

    @AfterAll
    static void afterAll() {
        ficheroAux.delete();
        ficheroExportado.delete();
        ficheroClientes.delete();
        ficheroIndice.delete();
    }

    /**
     * Test de caja negra para probar la funcion del metodo testleerClientesFicheroIndiceEnAuxiliar()
     */
    @Test
    void testleerClientesFicheroIndiceEnAuxiliar() {
        escribirFichero(PRUEBA_INDICE, ficheroIndice);
        FileAccessBinaryRead.leerClientesFicheroIndiceEnAuxiliar();
        assertEquals(PRUEBA_INDICE, leerFichero(ficheroAux));
    }

    /**
     * Test de caja blanca para no entrar en el if del metodo
     */
    @Test
    void testleerClientesFicheroIndiceEnAuxiliarContenidoNulo() {
        FileAccessBinaryRead.leerClientesFicheroIndiceEnAuxiliar();
        assertEquals(null, leerFichero(ficheroAux));
    }

    /**
     * Test de caja negra para probar la funcion del metodo testleerClientesFicheroAux()
     */
    @Test
     void testleerClientesFicheroAux() {
        escribirFichero(PRUEBA_INDICE, ficheroAux);
        FileAccessBinaryRead.leerClientesFicheroAux(PRUEBA_INDICE);
        assertEquals(PRUEBA_INDICE, leerFichero(ficheroIndice));
    }

    /**
     * Test de caja blanca para no entrar en el if
     */
    @Test
    void testleerClientesFicheroAuxContenidoNulo() {
        FileAccessBinaryRead.leerClientesFicheroAux(PRUEBA_INDICE);
        assertEquals(null, leerFichero(ficheroIndice));
    }

    /**
     * Test de caja negra para probar la función del método testgetLongitudFichero()
     */
    @Test
    void testgetLongitudFichero() {
        escribirFichero( new Cliente("nombre", "apellidos", "dni", "numTelefono", "direccion").toString(), ficheroClientes);
        assertEquals(0,FileAccessBinaryRead.getLongitudFichero());
    }


    /**
     * Test de caja negra para probar la función del método testbuscarPosicionFicheroIndice()
     */
    @Test
    void testbuscarPosicionFicheroIndice() {
        escribirFichero(PRUEBA_INDICE, ficheroIndice);
        assertEquals(1, FileAccessBinaryRead.buscarPosicionFicheroIndice("77866084K"));
    }

    /**
     * Test de caja negra para probar la función del método testbuscarClientePorPosicion()
     */
    @Test
    void testbuscarClientePorPosicion() {
        escribirFichero( new Cliente("nombre", "apellidos", "dni", "numTelefono", "direccion").toString(), ficheroClientes);
        assertEquals("nombre                    , apellidos                 , dni       , numTelefono , direccion                   ", FileAccessBinaryRead.buscarClientePorPosicion(FileAccessBinaryRead.getLongitudFichero()));
    }

    /**
     * Test de caja blanca para que se cumple la condicion if del metodo
     */
    @Test
    void testbuscarClientePorPosicionPosicionMenosUno() {
        escribirFichero( new Cliente("nombre", "apellidos", "dni", "numTelefono", "direccion").toString(), ficheroClientes);
        assertEquals("No encontrado", FileAccessBinaryRead.buscarClientePorPosicion(-1));
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