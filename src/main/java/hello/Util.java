package hello;

import java.util.Random;

public class Util {

    public static boolean estaEnRango(float numero1, float numeroSuperios, float numeroInferior){


        return numero1 > numeroInferior && numero1 <= numeroSuperios;
    }

    public static Float generarNumeroAleatorioEntreRango(Float minimo, Float maximo){
        
        Random random = new Random();


        return random.nextFloat()*(maximo-minimo+1)+minimo;

    }

    public static void wait(int ms)
    {
    
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
    
}
