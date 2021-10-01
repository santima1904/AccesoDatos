package modelo;

import java.io.*;

public class FileAccess {

    //Constatne nombre fichero
    public static final String NOMBRE_FICHERO = "config.bin";

    //Creo el fichero
    public static File fichero = new File(NOMBRE_FICHERO, ".");



    /**
     * Cabecera: public static void InicializarFichero()
     * Precondiciones: fichero creado
     * Entradas: nada
     * Salida: niunguna
     * Postcondiciones: Inserta en el fichero los datos pedidos al principio del programa
     */
    public static void InicializarFichero() {
        char caracter = 'a';
        double numero = 37.00;
        String cadena ="diezletras";

        try (DataOutputStream oos = new DataOutputStream(new FileOutputStream(fichero, false))){

            oos.writeBoolean(true);
            oos.writeChar(caracter);
            oos.writeDouble(numero);
            oos.writeBytes(cadena);


        } catch (IOException e) {//si salta la excepcion  IOException
            e.printStackTrace();//muestro la excepcion
        }

    }

    /**
     * Cabecera: public static void leerFichero()
     * Precondiciones: fichero creado
     * Entradas: ninguno
     * Salida: booleano
     * Postcondiciones: Devuelve el valor del booleano del fichero
     */
    public static boolean leerBooleano(){
        boolean booleano  = false, finFichero = false;


        try (DataInputStream ois = new DataInputStream(new FileInputStream(fichero))){

            while(!finFichero){
                try {

                    if (ois.readBoolean()) {
                        booleano = true;
                    }

                }catch(EOFException eof){

                    finFichero = true;
                }
            }


        }catch (IOException e) {
            e.printStackTrace();
        }

        return booleano;
    }

    /**
     * Cabecera: public static char leerChar()
     * Precondiciones: fichero creado
     * Entradas: ninguno
     * Salida: char
     * Postcondiciones: Devuelve el valor del char del fichero
     */
    public static char leerChar(){
        char caracter = ' ';
        boolean finFichero = false;

        try (DataInputStream ois = new DataInputStream(new FileInputStream(fichero))){

            while(!finFichero){
                try{
                    caracter = ois.readChar();

                }catch (IOException e){
                    finFichero = true;
                }

            }

        }catch (IOException e) {
            e.printStackTrace();

        }

        return caracter;
    }

    /**
     * Cabecera: public static double leerDouble()
     * Precondiciones: fichero creado
     * Entradas: ninguno
     * Salida: double
     * Postcondiciones: Devuelve el valor del double del fichero
     */
    public static double leerDouble(){
        double numero = 0;
        boolean finFichero = false;

        try (DataInputStream ois = new DataInputStream(new FileInputStream(fichero))){

            while(!finFichero){
                try{
                    numero = ois.readDouble();

                }catch (IOException e){
                    finFichero = true;
                }

            }
        }catch (IOException e) {
            e.printStackTrace();

        }

        return numero;
    }

    /**
     * Cabecera: public static String  leerString()
     * Precondiciones: fichero creado
     * Entradas: ninguno
     * Salida: String
     * Postcondiciones: Devuelve el valor del String del fichero
     */
    public static String  leerString(){
        String cadena = null;
        boolean finFichero = false;

        try (DataInputStream ois = new DataInputStream(new FileInputStream(fichero))){

            while(!finFichero){
                try{
                    cadena = ois.readUTF();

                }catch (IOException e){
                    finFichero = true;
                }

            }

        }catch (IOException e) {
            e.printStackTrace();

        }

        return cadena;
    }





}
