package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Servidor extends Conexion{

    private static Lock lock = new ReentrantLock();

    public Servidor() throws IOException{super("servidor");}


    public String startServer() throws IOException{


    System.out.println("Esperando............");

    while (true){

    cs = ss.accept();


    Thread clientThread = new Thread(new ClientHandler(cs));
    clientThread.start();
    System.out.println("Cliente en linea");

    }
    }
    private static class ClientHandler implements Runnable {

        private final Socket clientSocket;
    
        public ClientHandler(Socket clientSocket){
    
            this.clientSocket = clientSocket;
    
        }
    
        @Override
        public void run(){
            try{
    
                BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
        lock.lock();
        
        try{
        out.println("Peticion recibida y aceptada");
        
        String mensajeCliente = "";
    
        
        
        Float numeroRecibido = new Float(0.0f);

        
        while((mensajeCliente = entrada.readLine()) != null){
           if(mensajeCliente.equals("FIN")){
    
            //Terminado
            break;
           }
        
        try{
            
            ArrayList<String> respuestaCliente = Util.splitSentence(mensajeCliente);
            numeroRecibido = Float.parseFloat(respuestaCliente.get(0));
            System.out.println(numeroRecibido);
            if(respuestaCliente.get(1).equals(Constantes.TEMPERATURA)){
                String status ="";
            if(Util.estaEnRango(numeroRecibido, 89f, 68f)){
              status = "Correcto";
    
            }else if(Util.estaEnRango(numeroRecibido, 67f, 0f)){
                status = "Fuera de rango";
            }
            else if(Util.estaEnRango(numeroRecibido, -1f, -68f)){
                status = "Invalido";
            }

            out.println(status);

        }else if(respuestaCliente.get(1).equals(Constantes.PH)){
            String status ="";
            System.out.println(respuestaCliente.get(1));
            System.out.println(numeroRecibido);
            if(Util.estaEnRango(numeroRecibido, 8f, 6f)){
            
              status = "Correcto";
    
            }else if(Util.estaEnRango(numeroRecibido, 7.9f, 0f)){
                
                status = "Fuera de rango";
            }
            else if(Util.estaEnRango(numeroRecibido, -1f, -6f)){
               
                status = "Invalido";
            }
            System.out.println(status);
            out.println(status);
        }else if(respuestaCliente.get(1).equals(Constantes.OXIGENO)){
            System.out.println(numeroRecibido);

             String status ="";
            if(Util.estaEnRango(numeroRecibido, 11f, 2f)){
                
              status = "Correcto";
    
            }else if(Util.estaEnRango(numeroRecibido, 1.9f, 0f)){
                
                status = "Fuera de rango";
            }
            else if(Util.estaEnRango(numeroRecibido, -1f, -68f)){
                
                status = "Invalido";
            }
             System.out.println(status);
            out.println(status);


        }

        }
            
        catch(NumberFormatException e){
            System.err.println("Float invalido");
        }
        
    }}finally{

        lock.unlock();
    
    }
}catch(IOException e){
    e.printStackTrace();
}
    finally{

        try{
            clientSocket.close();
            
        }catch(IOException e){
        
            e.printStackTrace();
        
        }
    }
} 
}           
}
            
            
        
    
