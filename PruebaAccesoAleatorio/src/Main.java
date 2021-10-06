import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> campos = new HashMap<>();

        campos.put("DNI", 9);
        campos.put("NOMBRE", 32);
        campos.put("CP", 5);

            FciheroAccesoAleatorio faa = new FciheroAccesoAleatorio("fic_acceso_aleat.dat", campos);
            
            HashMap registro = new HashMap();
            registro.put("DNI", "56789012B");
            registro.put("NOMBRE", "SAMPER");
            registro.put("CP", "29730");
            faa.insertar(registro);
            registro.clear();
            registro.put("DNI", "89012345E");
            registro.put("NOMBRE", "ROJAS");
            faa.insertar(registro);
            registro.clear();
            registro.put("DNI", "23456789D");
            registro.put("NOMBRE", "DORCE");
            registro.put("CP", "13700");
            faa.insertar(registro);
            registro.clear();
            registro.put("DNI", "78901234X");
            registro.put("NOMBRE", "NADALES");
            registro.put("CP", "44126");
            faa.insertar(registro, 1);

    }
}
