public class Main {
    public static void main(String[] args) {

        String cadena = "cadena prueba";
        int numero = 37;
        double decimales = 37.5;
        char caracter = 'a';


        System.out.println(String.format("La cadena escrita es: %s", cadena));
        System.out.println(String.format("El numero es: %1$d y el decimal es %2$2.1f", numero, decimales));
        System.out.println(String.format("El caracter es: %c", caracter));

    }
}
