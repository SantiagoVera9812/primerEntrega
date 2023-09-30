package hello;

import java.io.IOException;

public class MainServidor {

    public static void main(String[] args) throws IOException{

        Servidor serv = new Servidor();

        System.out.println("Iniciando servidor\n");

        String status = "";

        status = serv.startServer();
    }
    
}
