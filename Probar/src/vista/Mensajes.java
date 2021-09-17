package vista;

public class Mensajes {

    public static final String PREGUNTA_INICIAL = "En que fichero desea guardar el texto";
    public static final String PREGUNTA_CONTENIDO = "Que desea escribir";

    /**
     * Prototipo: public static void preguntaInicial()
     * Descripcion: muestra un mensaje al usuario con la pregunta inicial del programa
     */
    public static void preguntaInicial(){
        System.out.println(PREGUNTA_INICIAL);
    }

    /**
     * Prototipo: public static void preguntaContenido()
     * Descripcion: muestra un mensaje al usuario pidiendo el contenido del fichero
     */
    public static void preguntaContenido(){
        System.out.println(PREGUNTA_CONTENIDO);
    }

}
