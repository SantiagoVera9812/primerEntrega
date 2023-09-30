package hello;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {

    private static final int PUERTO = 1234;
    private static final String HOST = "localhost";

    protected ServerSocket ss;
    protected Socket cs;

    public Conexion(String tipo) throws IOException{

        if(tipo.equalsIgnoreCase("servidor")){

        ss = new ServerSocket(PUERTO);
        cs = new Socket();
        }else{

            cs = new Socket(HOST, PUERTO);
        }
    }


    
}
