package modelo.ficheros;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutPutStream extends ObjectOutputStream{
    protected MyObjectOutPutStream() throws IOException {
        super();
    }

    public MyObjectOutPutStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException
    {
        // No hacer nada.
    }


}
