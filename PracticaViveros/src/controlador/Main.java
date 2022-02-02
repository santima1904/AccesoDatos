package controlador;

import modelo.dataaccess.DataAccessScript;

public class Main {
    public static void main(String[] args) {
        DataAccessScript dataAccessScript = new DataAccessScript();
        dataAccessScript.ejecutarScript("./Vivero.sql");
    }
}
