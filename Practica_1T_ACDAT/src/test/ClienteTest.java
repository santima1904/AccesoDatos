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
     * Test de caja negra para probar la función del método getNombre()
     */
    @Test
    void getNombre() {
        assertEquals(rellenarEspacios("nombre", Cliente.LONGITUD_MAX_NOMBRE), cliente.getNombre());
    }

    /**
     * Test de caja negra para probar la función del método setNombre()
     */
    @Test
    void setNombre() {
        String nombre = "cambio";
        cliente.setNombre(nombre);
        assertEquals(nombre, cliente.getNombre());
    }

    /**
     * Test de caja negra para probar la función del método getApellidos()
     */
    @Test
    void getApellidos() {
        assertEquals(rellenarEspacios("apellidos", Cliente.LONGITUD_MAX_NOMBRE), cliente.getApellidos());
    }

    /**
     * Test de caja negra para probar la función del método setApellidos()
     */
    @Test
    void setApellidos() {
        String apellido = "cambio";
        cliente.setApellidos(apellido);
        assertEquals(apellido, cliente.getApellidos());
    }

    /**
     * Test de caja negra para probar la función del método getDni()
     */
    @Test
    void getDni() {
        assertEquals(rellenarEspacios("dni", Cliente.LONGITUD_MAX_TELEFONO_DNI), cliente.getDni());
    }

    /**
     * Test de caja negra para probar la función del método getNumTelefono()
     */
    @Test
    void getNumTelefono() {
        assertEquals(rellenarEspacios("numTelefono", Cliente.LONGITUD_MAX_TELEFONO_DNI), cliente.getNumTelefono());
    }

    /**
     * Test de caja negra para probar la función del método setNumTelefono()
     */
    @Test
    void setNumTelefono() {
        String numTelefono = "cambio";
        cliente.setNumTelefono(numTelefono);
        assertEquals(numTelefono, cliente.getNumTelefono());
    }

    /**
     * Test de caja negra para probar la función del método getDireccion()
     */
    @Test
    void getDireccion() {
        assertEquals(rellenarEspacios("direccion", Cliente.LONGITUD_MAX_DIRECCION), cliente.getDireccion());
    }

    /**
     * Test de caja negra para probar la función del método setDireccion()
     */
    @Test
    void setDireccion() {
        String direccion = "cambio";
        cliente.setDireccion(direccion);
        assertEquals(direccion, cliente.getDireccion());
    }


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