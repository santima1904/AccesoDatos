package controlador;

import modelo.dataaccess.DataAccessScript;

public class Main {
    public static void main(String[] args) {
//        DataAccessScript dataAccessScript = new DataAccessScript();
//        dataAccessScript.ejecutarScript("./Vivero.sql");

        boolean salir = false;

        while(!salir){
           salir = Gestora.menuConsultas();
        }

        System.out.println("Ha sido unplacer mamahuevo");
    }
}
