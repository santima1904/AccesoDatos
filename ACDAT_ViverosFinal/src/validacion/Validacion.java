package validacion;

import dal.cliente.ClienteDao;
import gestion.Gestora;
import mensaje.Salida;

import java.util.Scanner;


public class Validacion {
    static Scanner teclado = new Scanner(System.in);
    static Scanner tecladoInt=new Scanner(System.in);

    /**
     * <b>Cabecera:</b> public static String validarNombre() <br>
     * <b>Descripcion:</b> este metodo pide por teclado una cadena mayor a 1 caracter para validarla.
     * <b>Precondiciones:</b> ninguna. <br>
     * <b>Postcondiciones:</b> se pasa un nombre con una longitud de 25. <br>
     *
     * @return nombre String
     */
    public static String validarNombre(){
        String nombre;
        boolean valido= false;

        do {
            Salida.mostrarString(Salida.PEDIR_NOMBRE);
            nombre= teclado.nextLine();

            if (nombre.length()>1)
                valido= true;
            else
                Salida.mostrarString(Salida.ERROR);
        }while(!valido);

        return nombre;
    }

    /**
     * <b>Cabecera:</b> public static String validarDNI() <br>
     * <b>Descripcion:</b> este metodo pide por teclado una un DNI y lo valida.
     * <b>Precondiciones:</b> ninguna. <br>
     * <b>Postcondiciones:</b> se pasa un dni valid. <br>
     *
     * @return dni String
     */
    public static String validarDni(){
        String dni;
        boolean valido= false;

        do {
            Salida.mostrarString(Salida.PEDIR_DNI);
            dni= teclado.nextLine();

            if (dni.length()>1 && validar(dni))
                valido= true;
            else
                Salida.mostrarString(Salida.ERROR);
        }while(!valido);

        return dni;
    }

    /**
     * <b>Cabecera:</b> public static String validarTelefono() <br>
     * <b>Descripcion:</b> este metodo pide por teclado una cadena mayor a 1 caracter para validarla.
     * <b>Precondiciones:</b> ninguna. <br>
     * <b>Postcondiciones:</b> se pasa un telefono con una longitud de 9. <br>
     *
     * @return telefono String
     */
    public static String validarTelefono(){
        String telefono;
        boolean valido= false;

        do {
            Salida.mostrarString(Salida.PEDIR_TELEFONO);
            telefono= teclado.nextLine();

            if (telefono.length()>1)
                valido= true;
            else
                Salida.mostrarString(Salida.ERROR);
        }while(!valido);

        return telefono;
    }

    /**
     * <b>Cabecera:</b> public static String validarDireccion() <br>
     * <b>Descripcion:</b> este metodo pide por teclado una cadena mayor a 1 caracter para validarla.
     * <b>Precondiciones:</b> ninguna. <br>
     * <b>Postcondiciones:</b> se pasa una direccion con una longitud de 30. <br>
     *
     * @return direccion String
     */
    public static String validarDireccion(){
        String direccion;
        boolean valido= false;

        do {
            Salida.mostrarString(Salida.PEDIR_DIRECCION);
            direccion= teclado.nextLine();

            if (direccion.length()>1)
                valido= true;
            else
                Salida.mostrarString(Salida.ERROR);
        }while(!valido);

        return direccion;
    }


    private static boolean validar(String dni) {
        String letraMayuscula;
        if(dni.length() != 9 || !Character.isLetter(dni.charAt(8))) {
            return false;
        }
        letraMayuscula = (dni.substring(8)).toUpperCase();

        return soloNumeros(dni) && letraDNI(dni).equals(letraMayuscula);
    }

    private static boolean soloNumeros(String dni) {
        int i, j;
        String numero;
        StringBuilder miDNI = new StringBuilder();
        String[] unoNueve = {"0","1","2","3","4","5","6","7","8","9"};

        for(i = 0; i < dni.length() - 1; i++) {
            numero = dni.substring(i, i+1);

            for(j = 0; j < unoNueve.length; j++) {
                if(numero.equals(unoNueve[j])) {
                    miDNI.append(unoNueve[j]);
                }
            }
        }

        return miDNI.length() == 8;
    }

    private static String letraDNI(String dni) {
        int miDNI = Integer.parseInt(dni.substring(0,8));
        int resto;
        String miLetra;
        String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

        resto = miDNI % 23;
        miLetra = asignacionLetra[resto];

        return miLetra;
    }

    public static String validarCodigoPostal() {
        String codigoPostal;
        boolean valido= false;

        do {
            Salida.mostrarString(Salida.PEDIR_CODIGO_POSTAL);
            codigoPostal= teclado.nextLine();

            if (codigoPostal.length()>1)
                valido= true;
            else
                Salida.mostrarString(Salida.ERROR);
        }while(!valido);

        return codigoPostal;
    }

    public static String validarCiudad() {
        String ciudad;
        boolean valido= false;

        do {
            Salida.mostrarString(Salida.PEDIR_CIUDAD);
            ciudad= teclado.nextLine();

            if (ciudad.length()>1)
                valido= true;
            else
                Salida.mostrarString(Salida.ERROR);
        }while(!valido);

        return ciudad;
    }

    public static String validarCorreo() {
        String correo;
        boolean valido= false;

        do {
            Salida.mostrarString(Salida.PEDIR_CORREO);
            correo= teclado.nextLine();

            if (correo.length()>1)
                valido= true;
            else
                Salida.mostrarString(Salida.ERROR);
        }while(!valido);

        return correo;
    }

    public static int validarId() {
        int id;
        boolean valido= false;

        do {
            Salida.mostrarString(Salida.PEDIR_ID);
            id= tecladoInt.nextInt();

            if (id>1)
                valido= true;
            else
                Salida.mostrarString(Salida.ERROR);
        }while(!valido);

        return id;
    }
    public static String validarDescripcion() {
        String descripcion;
        boolean valido= false;

        do {
            Salida.mostrarString(Salida.PEDIR_DESCRIPCION);
            descripcion= teclado.nextLine();

            if (descripcion.length()>1)
                valido= true;
            else
                Salida.mostrarString(Salida.ERROR);
        }while(!valido);

        return descripcion;
    }

    public static String validarCodigo() {
        String codigo;
        boolean valido= false;

        do {
            Salida.mostrarString(Salida.PEDIR_CODIGO);
            codigo= teclado.next();

            if (!codigo.isEmpty()&&!codigo.isBlank())
                valido= true;
            else
                Salida.mostrarString(Salida.ERROR);
        }while(!valido);
        return codigo;
    }


    public static double validarPrecioUnitario() {
        double precio;
        boolean valido= false;

        do {
            Salida.mostrarString(Salida.PEDIR_PRECIO);
            precio= tecladoInt.nextInt();

            if (precio>1)
                valido= true;
            else
                Salida.mostrarString(Salida.ERROR);
        }while(!valido);

        return precio;
    }

    public static int validarUnidadesDisponibles() {
        int unidades;
        boolean valido= false;

        do {
            Salida.mostrarString(Salida.PEDIR_UNIDADES);
            unidades= tecladoInt.nextInt();

            if (unidades>1)
                valido= true;
            else
                Salida.mostrarString(Salida.ERROR);
        }while(!valido);

        return unidades;
    }

    public static String pedirValor() {
        String valor;
        boolean valido= false;

        do {
            Salida.mostrarString(Salida.PEDIR_VALOR);
            valor= teclado.nextLine();

            if (valor.length()>1)
                valido= true;
            else
                Salida.mostrarString(Salida.ERROR);
        }while(!valido);

        return valor;
    }
    public static String validarUsuario() {
        String usuario;
        boolean valido= false;

        do {
            Salida.mostrarString(Salida.LOGIN_PEDIR_NOMBREUSUARIO);
            usuario= teclado.nextLine();

            if (usuario.length()>1)
                valido= true;
            else
                Salida.mostrarString(Salida.ERROR);
        }while(!valido);
        return usuario;
    }

    public static String validarContrasena() {
        String contrasena;
        boolean valido= false;

        do {
            Salida.mostrarString(Salida.LOGIN_PEDIR_CONTRASENYA);
            contrasena= teclado.nextLine();

            if (contrasena.length()>1)
                valido= true;
            else
                Salida.mostrarString(Salida.ERROR);
        }while(!valido);
        return contrasena;
    }
    public static String seleccionarColumnaCliente() {
        boolean valido= false;
        String columna= "";

        do {
            Salida.mostrarColumnasCliente();
            switch (teclado.nextLine()){
                case "1" -> {columna="Direccion"; valido= true;}
                case "2" -> {columna="CodigoPostal"; valido= true;}
                case "3" -> {columna="Ciudad"; valido= true;}
                case "4" -> {columna="Telefono"; valido= true;}
                case "5" -> {columna="Correo"; valido= true;}
                default -> Salida.mostrarString(Salida.ERROR);
            }
        }while (!valido);

        return columna;
    }
    public static String seleccionarColumnaProducto() {
        boolean valido= false;
        String columna= "";

        do {
            Salida.mostrarColumnasProducto();
            switch (teclado.nextLine()){
                case "1" -> {columna="Descripcion"; valido= true;}
                case "2" -> {columna="PrecioUnitario"; valido= true;}
                case "3" -> {columna="UnidadesDisponibles"; valido= true;}
                default -> Salida.mostrarString(Salida.ERROR);
            }
        }while (!valido);

        return columna;
    }
    public static String seleccionarColumnaVendedor() {
        boolean valido= false;
        String columna= "";

        do {
            Salida.mostrarColumnasVendedor();
            switch (teclado.nextLine()){
                case "1" -> {columna="Direccion"; valido= true;}
                case "2" -> {columna="CodigoPostal"; valido= true;}
                case "3" -> {columna="Ciudad"; valido= true;}
                case "4" -> {columna="Telefono"; valido= true;}
                case "5" -> {columna="Correo"; valido= true;}
                case "6" -> {columna="Usuario"; valido= true;}
                case "7" -> {columna="Contrasena"; valido= true;}
                default -> Salida.mostrarString(Salida.ERROR);
            }
        }while (!valido);
        return columna;
    }
    public static String pedirContrasenyaLogin(){
        Salida.mostrarString(Salida.LOGIN_PEDIR_CONTRASENYA);
        return teclado.nextLine();
    }

    public static String pedirNombreUsuarioLogin(){
        Salida.mostrarString(Salida.LOGIN_PEDIR_NOMBREUSUARIO);
        return teclado.nextLine();
    }

    public static String pedirUsuario(){
        Salida.mostrarString(Salida.MENSAJE_PEDIR_USUARIO);
        return teclado.nextLine();
    }

    public static String pedirContrasenya(){
        Salida.mostrarString(Salida.LOGIN_PEDIR_CONTRASENYA);
        return teclado.nextLine();
    }

    public static String pedirServidorBbDd(){
        Salida.mostrarString(Salida.MENSAJE_PEDIR_SERVIDOR_BBDD);
        return teclado.nextLine();
    }

    public static String pedirPuerto(){
        String puerto= "";
        boolean puertoNoValido=true;

        do{
            Salida.mostrarString(Salida.MENSAJE_PEDIR_PUERTO);
            try{
                puerto=teclado.nextLine();
                Integer.parseInt(puerto);
                puertoNoValido = false;
            }catch(NumberFormatException e){
                Salida.mostrarString(Salida.MENSAJE_ERROR_NUMERO_NO_VALIDO);
            }
        }while(puertoNoValido);
        return puerto;
    }

    public static int pedirIdPedido(){
        String idPedido;
        int idPedidoNumerico = -1;

        do{
            Salida.mostrarString(Salida.MENSAJE_PEDIR_IDPEDIDO);
            try{
                idPedido=teclado.nextLine();
                idPedidoNumerico = Integer.parseInt(idPedido); //Si no son números lo que hay dentro, saltara una excepcion
            }catch(NumberFormatException e){
                Salida.mostrarString(Salida.MENSAJE_ERROR_NUMERO_NO_VALIDO);
            }
        }while(idPedidoNumerico==-1);
        return idPedidoNumerico;
    }
    /**
     * Cabecera: public static int validarNumero0al1()
     *
     * Descripcion: Este metodo se encarga de validar un numero insertado por el usuario.
     * Este debe ser 0 o 1.
     *
     * Precondiciones: Ninguna
     * Postcondciones: Te devuelve un numero que es un 0 o un 1
     * @return int respuesta
     */
    public static int validarNumero0al1(){
        int respuesta;

        do{
            Salida.mostrarString(Salida.INSERTE_NUMERO_DEL_0_AL_1);
            respuesta=tecladoInt.nextInt();
        }while((respuesta!=1)&&(respuesta!=0));
        return respuesta;
    }
    /**
     * Cabecera: public static String validarDniOTelefonoCliente()
     *
     * Descripcion: Este metodo te devuelve el dni o el telefono del cliente
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Devuelve una cadena
     * @return String dniOTelefono
     */
    public static String validarDniOTelefonoCliente(){
        Salida.indicarInformacionParaIntroducirCliente();
        return teclado.next();
    }
    /**
     * Cabecera: public static int validarNumero0al2()
     *
     * Descripcion: Este metodo se encarga de validar un numero insertado por el usuario.
     * Este debe ser 0,1 o 2.
     *
     * Precondiciones: Ninguna
     * Postcondciones: Te devuelve un numero que es un 0, 1 o un 2
     * @return int respuesta
     */
    public static int validarNumero0al2(){
        int respuesta=-1;

        do{
            Salida.mostrarString(Salida.INSERTE_NUMERO_DEL_0_AL_2);
            try{
                respuesta=tecladoInt.nextInt();
            }catch(Exception e){
                tecladoInt.next();
                System.out.println("Numero de mierda mi rey");
            }
        }while((respuesta!=1)&&(respuesta!=2)&&(respuesta!=0));
        return respuesta;
    }

    /**
     * Cabecera: public static void validarCliente()
     *
     * Descripcion: Este metodo se encarga de pedir un cliente hasta que sea valido.
     *
     * Precondiciones: Ninguna
     * Postcondiciones: Devuelve el id del cliente
     * @return int id
     */
    public static int validarCliente(){
        int id = -1,opcion;

        do{
            Salida.mensajeMenuCliente();
            opcion = Validacion.validarNumero0al2();
            switch(opcion){
                case 1 -> id=0;
                case 2 -> id = ClienteDao.comprobarSiExisteCliente();
                case 0 -> id = -2;
            }
        }while (id==-1);
        return id;
    }
    /**
     * Cabecera: public static int validarNumero0al2()
     *
     * Descripcion: Este metodo se encarga de validar un numero insertado por el usuario.
     * Este debe ser 0,1 o 2.
     *
     * Precondiciones: Ninguna
     * Postcondciones: Te devuelve un numero que es un 0, 1 o un 2
     * @return int respuesta
     */
    public static int validarNumero0al3(){
        int respuesta=-1;

        do{
            Salida.mostrarString(Salida.INSERTE_NUMERO_DEL_0_AL_3);
            try{
                respuesta=tecladoInt.nextInt();
            }catch(Exception e){
                tecladoInt.next();
                System.out.println("Numero de mierda mi rey");
            }
        }while((respuesta!=1)&&(respuesta!=2)&&(respuesta!=3)&&(respuesta!=0));
        return respuesta;
    }
    /**
     * Cabecera: public static int validarNumero0al4()
     *
     * Descripcion: Este metodo se encarga de validar un numero insertado por el usuario.
     * Este debe ser 0,1 o 2.
     *
     * Precondiciones: Ninguna
     * Postcondciones: Te devuelve un numero que es un 0, 1, 2, 3 o 4
     * @return int respuesta
     */
    public static int validarNumero0al4(){
        int respuesta=-1;

        do{
            Salida.mostrarString(Salida.INSERTE_NUMERO_DEL_0_AL_4);
            try{
                respuesta=tecladoInt.nextInt();
            }catch(Exception e){
                tecladoInt.next();
                System.out.println("Numero de mierda mi rey");
            }
        }while((respuesta!=1)&&(respuesta!=2)&&(respuesta!=3)&&(respuesta!=4)&&(respuesta!=0));
        return respuesta;
    }
    /**
     * Cabecera: public static int validarNumero0al4()
     *
     * Descripcion: Este metodo se encarga de validar un numero insertado por el usuario.
     * Este debe ser 0,1 o 2.
     *
     * Precondiciones: Ninguna
     * Postcondciones: Te devuelve un numero que es un 0, 1, 2, 3 o 4
     * @return int respuesta
     */
    public static int validarNumero0al5(){
        int respuesta=-1;

        do{
            Salida.mostrarString(Salida.INSERTE_NUMERO_DEL_0_AL_4);
            try{
                respuesta=tecladoInt.nextInt();
            }catch(Exception e){
                tecladoInt.next();
                System.out.println("Numero de mierda mi rey");
            }
        }while((respuesta!=1)&&(respuesta!=2)&&(respuesta!=3)&&(respuesta!=4)&&(respuesta!=5)&&(respuesta!=0));
        return respuesta;
    }
    /**
     * Cabecera: public static int validarNumero0al4()
     *
     * Descripcion: Este metodo se encarga de validar un numero insertado por el usuario.
     * Este debe ser 0,1 o 2.
     *
     * Precondiciones: Ninguna
     * Postcondciones: Te devuelve un numero que es un 0, 1, 2, 3, 4, 5, 6 y 7
     * @return int respuesta
     */
    public static int validarNumero0al7(){
        int respuesta=-1;

        do{
            Salida.mostrarString(Salida.INSERTE_NUMERO_DEL_0_AL_7);
            try{
                respuesta=tecladoInt.nextInt();
            }catch(Exception e){
                tecladoInt.next();
                System.out.println("Numero de mierda mi rey");
            }
        }while((respuesta!=1)&&(respuesta!=2)&&(respuesta!=3)&&(respuesta!=4)&&
                (respuesta!=5)&&(respuesta!=6)&&(respuesta!=7)&&(respuesta!=0));
        return respuesta;
    }
    public static int validarMes(){
        int mes;

        do{
            Salida.mostrarString(Salida.PEDIR_MES);
            mes = pedirInt();
        }while (mes<=1&&mes>=12);

        return mes;
    }
    public static int validarAnyo(){
        Salida.mostrarString(Salida.PEDIR_ANYO);
        return pedirInt();
    }
    public static int pedirInt(){
        String cadena_entero;
        int entero = 0;
        boolean valido = false;

        while(!valido){
            cadena_entero = teclado.nextLine();
            try{
                entero = Integer.parseInt(cadena_entero);
                valido = true;
            }catch (NumberFormatException ignored){
            }
        }
        return entero;
    }
    public static int validarIdCliente(){
        int id;

        do{
            id = Gestora.getIdClientePorDni(Validacion.validarDni());
        }while(id==-1);
        return id;
    }
    public static int validarCantidad(){
        int cantidad;
        do {
            Salida.mostrarString(Salida.PEDIR_CANTIDAD_PRODUCTO);
            try{
                cantidad=teclado.nextInt();
            }catch (Exception e){
                cantidad = 0;
                tecladoInt.nextInt();
                Salida.mostrarString(Salida.MENSAJE_ERROR_NUMERO_NO_VALIDO);
            }
        }while (cantidad<=0);
        return cantidad;
    }

    public static String validarIdProducto() {
        String id;
        boolean valido= false;

        do {
            Salida.mostrarString(Salida.PEDIR_VALOR);
            id= teclado.nextLine();

            if (id.length()>1)
                valido= true;
            else
                Salida.mostrarString(Salida.ERROR);
        }while(!valido);

        return id;
    }

    public static int validarFacturaValida() {
        int opcion=0;

        do{
            Salida.mostrarString(Salida.PEDIR_CONFIRMACION_FACTURA);
            try{
                opcion = tecladoInt.nextInt();
            }catch (Exception e){
                Salida.mostrarString(Salida.MENSAJE_ERROR_NUMERO_NO_VALIDO);
                tecladoInt.next();
            }
        }while(opcion!=1&&opcion!=2);
        return opcion;
    }
}
