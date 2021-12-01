package test;

import modelo.clasesBasicas.Cliente;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteTest {

    static Cliente cliente;

    @BeforeEach
    void beforeEach() {
       cliente = new Cliente("nombre", "apellidos", "dni", "numTelefono", "direccion");
    }

    /**
     * Test de caja negra para probar la función del método testGetNombre()
     */
    @Test
    void testGetNombre() {
        assertEquals(rellenarEspacios("nombre", Cliente.LONGITUD_MAX_NOMBRE), cliente.getNombre());
    }

    /**
     * Test de caja negra para probar la función del método testSetNombre()
     */
    @Test
    void testSetNombre() {
        String nombre = "cambio";
        cliente.setNombre(nombre);
        assertEquals(nombre, cliente.getNombre());
    }

    /**
     * Test de caja negra para probar la función del método testGetApellidos()
     */
    @Test
    void testGetApellidos() {
        assertEquals(rellenarEspacios("apellidos", Cliente.LONGITUD_MAX_NOMBRE), cliente.getApellidos());
    }

    /**
     * Test de caja negra para probar la función del método testSetApellidos()
     */
    @Test
    void testSetApellidos() {
        String apellido = "cambio";
        cliente.setApellidos(apellido);
        assertEquals(apellido, cliente.getApellidos());
    }

    /**
     * Test de caja negra para probar la función del método testGetDni()
     */
    @Test
    void testGetDni() {
        assertEquals(rellenarEspacios("dni", Cliente.LONGITUD_MAX_TELEFONO_DNI), cliente.getDni());
    }

    /**
     * Test de caja negra para probar la función del método testGetNumTelefono()
     */
    @Test
    void testGetNumTelefono() {
        assertEquals(rellenarEspacios("numTelefono", Cliente.LONGITUD_MAX_TELEFONO_DNI), cliente.getNumTelefono());
    }

    /**
     * Test de caja negra para probar la función del método testSetNumTelefono()
     */
    @Test
    void testSetNumTelefono() {
        String numTelefono = "cambio";
        cliente.setNumTelefono(numTelefono);
        assertEquals(numTelefono, cliente.getNumTelefono());
    }

    /**
     * Test de caja negra para probar la función del método testGetDireccion()
     */
    @Test
    void testGetDireccion() {
        assertEquals(rellenarEspacios("direccion", Cliente.LONGITUD_MAX_DIRECCION), cliente.getDireccion());
    }

    /**
     * Test de caja negra para probar la función del método testSetDireccion()
     */
    @Test
    void testSetDireccion() {
        String direccion = "cambio";
        cliente.setDireccion(direccion);
        assertEquals(direccion, cliente.getDireccion());
    }

    //Métodos privados para los tests
    /**
     * Metodo para los test
     * Rellena la cadena insertada con los espacios requeridos
     *
     * @param atributo
     * @param longitudmax
     * @return String
     */
    static String rellenarEspacios(String atributo, int longitudmax){
        StringBuilder strb = new StringBuilder("%-");
        strb.append(longitudmax).append("s");

        return String.format(strb.toString(),atributo);
    }
}