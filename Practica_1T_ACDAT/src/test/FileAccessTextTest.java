package test;

import modelo.ficheros.FileAccessText;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Con los tests de caja negra, quedan cubiertas las sentencias de cada método.
    No hace falta hacer los de caja blanca.
 */
class FileAccessTextTest {

    static File ficheroConfiguracion;
    static File ficheroListadoClientes;

    @BeforeAll
    static void beforeAll() {
       ficheroConfiguracion = FileAccessText.ficheroConfiguracion;
       ficheroListadoClientes = FileAccessText.ficheroText;
    }

    @AfterEach
     void afterEach() {
       FileAccessText.inicializarFicheroExportado();
    }

    /**
     * Test de caja negra para probar la función del método escribirCodificacionFichero()
     */
    @Test
    void escribirCodificacionFichero() {
        FileAccessText.escribirCodificacionFichero("UTF-8");
        assertEquals("UTF-8", leerFichero(ficheroConfiguracion));
    }

    /**
     * Test de caja negra para probar la función del método escribirClientesFicheroExportado()
     */
    @Test
    void escribirClientesFicheroExportado() {
        FileAccessText.escribirClientesFicheroExportado("cliente");
        assertEquals("cliente", leerFichero(ficheroListadoClientes));
    }

    /**
     * Test de caja negra para probar la función del método inicializarFicheroExportado()
     */
    @Test
    void inicializarFicheroExportado() {
        FileAccessText.inicializarFicheroExportado();
        assertEquals(null, leerFichero(ficheroListadoClientes));
    }


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
}