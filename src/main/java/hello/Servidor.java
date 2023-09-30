package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Servidor extends Conexion{

    public Servidor() throws IOException{super("servidor");}

    public Float startServer() throws IOException{


    System.out.println("Esperando............");

    cs = ss.accept();

    System.out.println("Cliente en linea");

    BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));

    PrintWriter out = new PrintWriter(cs.getOutputStream(),true);

    out.println("Peticion recibida y aceptada");
    String mensajeCliente = "";
    
    
    while((mensajeCliente = entrada.readLine()) != null){
       if(mensajeCliente.equals("FIN")){

        break;
       }
    
    try{

        Float numeroRecibido = Float.parseFloat(mensajeCliente);
        return numeroRecibido;
    }catch(NumberFormatException e){
        System.err.println("Float invalido");
    }
    }
    

    return null;
}
    
}
