public class Main {

    public static void main(String[] args) {

        try(ClaseBasica c1 = new ClaseBasica()){

            System.out.println(5/0);
            //System.out.println("Hola");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
