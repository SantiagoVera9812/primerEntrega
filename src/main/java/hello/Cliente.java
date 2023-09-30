package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;

public class Cliente extends Conexion {

    public Cliente() throws IOException{super("cliente");}

    public void startClient(float numeroConfiguracion)
    {

        try{

        BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        PrintWriter out = new PrintWriter(cs.getOutputStream(), true);

        String respuesta = in.readLine();
        System.out.println("Respuesta del servidor: "+ respuesta);
        

        out.println(numeroConfiguracion);


        out.println("FIN");

        String resultado = in.readLine();

        System.out.println(resultado);

        cs.close();

        }catch (ConnectException e2){

            System.out.println("No hay servidor disponible");
        }catch(IOException e){

            System.out.println(e.getMessage());
        }




    }
    
}
