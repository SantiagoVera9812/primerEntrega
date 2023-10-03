package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Util {

    public static boolean estaEnRango(float numero1, float numeroSuperios, float numeroInferior){


        return numero1 >= numeroInferior && numero1 <= numeroSuperios;
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

    public static ArrayList<String> splitSentence(String sentence) {
        
        String[] wordsArray = sentence.split(" ");
        
        
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(wordsArray));

        return wordsList;
    }
    
}
