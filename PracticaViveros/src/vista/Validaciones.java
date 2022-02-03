/**
 * Clase para pedir por teclado y validar los datos necesarios
 */
package vista;

import java.util.Scanner;

public class Validaciones {

    public static Scanner teclado = new Scanner(System.in);

    /**
     * Metodo para pedir una cadena por teclado al usuario
     * @return
     */
    public String pedirString(){
        return teclado.nextLine();
    }


}
