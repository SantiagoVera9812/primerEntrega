package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Servidor extends Conexion{

    public Servidor() throws IOException{super("servidor");}

    public String startServer() throws IOException{


    System.out.println("Esperando............");

    cs = ss.accept();

    System.out.println("Cliente en linea");

    BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));

    PrintWriter out = new PrintWriter(cs.getOutputStream(),true);

    out.println("Peticion recibida y aceptada");
    String mensajeCliente = "";

    String status ="";
    
    Float numeroRecibido = new Float(0.0f);
    
    while((mensajeCliente = entrada.readLine()) != null){
       if(mensajeCliente.equals("FIN")){

        break;
       }
    
    try{

        numeroRecibido = Float.parseFloat(mensajeCliente);
        System.out.println(mensajeCliente);
        if(Util.estaEnRango(numeroRecibido, 89f, 68f)){
          status = "Correcto";

        }else if(Util.estaEnRango(numeroRecibido, 67f, 0f)){
            status = "Fuera de rango";
        }
        else if(Util.estaEnRango(numeroRecibido, -1f, -68f)){
            status = "Invalido";
        }

        
    }catch(NumberFormatException e){
        System.err.println("Float invalido");
    }
    }
    

    return status;
}
    
}
