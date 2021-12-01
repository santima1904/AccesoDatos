package test;

import modelo.clasesBasicas.Cliente;
import modelo.ficheros.FileAccessBinaryWrite;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.*;

/*
    Con los tests de caja negra, quedan cubiertas las sentencias de cada método.
    No hace falta hacer los de caja blanca.
 */
class FileAccessBinaryWriteTest {

    static final String NOMBRE_FICHEROPRUEBA = "ficheroPruebaWrite";
    static File ficheroPrueba = new File(NOMBRE_FICHEROPRUEBA);
    static File ficheroCliente;
    static Cliente cliente;

    @BeforeAll
    static void beforeAll(){
        ficheroPrueba = new File("ficheroPruebaWrite");
        ficheroCliente = FileAccessBinaryWrite.ficheroClientes;
        cliente = new Cliente("nombre", "apellidos", "dni", "numTelefono", "direccion");
    }

    @BeforeEach
    void setUp() {
        testInicializarFichero(ficheroCliente);
        testInicializarFichero(ficheroPrueba);
    }

    @Test
    void testEscribirCliente() {
        FileAccessBinaryWrite.escribirCliente(cliente);
        assertEquals(cliente.toString(), leerFichero(ficheroCliente));
    }

    @Test
    void testEscribirFichero() {
        FileAccessBinaryWrite.escribirFichero(cliente.toString(),NOMBRE_FICHEROPRUEBA);
        assertEquals(cliente.toString(), leerFichero(ficheroPrueba));
    }

    @Test
    void testInicializarFichero() {
        FileAccessBinaryWrite.inicializarFichero(NOMBRE_FICHEROPRUEBA);
        assertEquals(null, leerFichero(ficheroPrueba));
    }

    //Métodos privados para los tests
    /**
     * Metodo para los test
     * Lee el contenido del fichero
     *
     * @param fichero
     * @return String
     */
    static String leerFichero(File fichero){
        String linea = " ";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fichero)))) {
            linea = br.readLine();
        }catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return linea;
    }

    /**
     * Metodo para los test
     * Inicializa el fichero escribiendo un espacio vacio
     *
     * @param fichero
     */
    static void testInicializarFichero(File fichero){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, false))){
            bw.write("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}