public class Main {
    public static void main(String[] args) {
        Errores registro = new Errores("registro.txt");

        //Pruebas
        try{
            if (7/0 == 1){
                System.out.println("A");
            }
        }catch (Exception e){
            registro.escribirError(e.getMessage());
        }

        String [] lista = null;

        try{
            String cadena = null;
            lista[0] = cadena;
        }catch (Exception e){
            registro.escribirError(e.getMessage());
        }

        registro.escribirAdvertencia("Cuidado");

        registro.escribirInformación("Últimas noticias: Eres guapísimo");


    }
}
