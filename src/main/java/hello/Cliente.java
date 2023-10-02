package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;

public class Cliente extends Conexion {

    public Cliente() throws IOException{super("cliente");}

    public String startClient(float numeroConfiguracion)
    {
        String resultado = "";
        try{

            System.out.println(numeroConfiguracion);

        BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        PrintWriter out = new PrintWriter(cs.getOutputStream(), true);

        String respuesta = in.readLine();
        System.out.println("Respuesta del servidor: "+ respuesta);
        

        out.println(numeroConfiguracion);

         out.println("FIN");
        out.flush();

        resultado = in.readLine();

        System.out.println(resultado);

        
        cs.close();

        return resultado;

        }catch (ConnectException e2){

            System.out.println("No hay servidor disponible");
        }catch(IOException e){

            System.out.println(e.getMessage());
        }


     return resultado;

    }
    
}
