public class ClaseBasica implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("Se ha cerrao");
    }
}
