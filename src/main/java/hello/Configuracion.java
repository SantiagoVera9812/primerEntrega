package hello;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Configuracion {
    public static void main(String[] args) {
        Options options = new Options();

        Option option1 = new Option("c", "arg1", true, "% correcto (float)");
        Option option2 = new Option("f", "arg2", true, "% fuera de rango (float)");
        Option option3 = new Option("i", "arg3", true, "% incorrecto(float)");

        options.addOption(option1);
        options.addOption(option2);
        options.addOption(option3);

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);

            float porcentajeCorrecto = Float.parseFloat(cmd.getOptionValue("c"));
            float porcentajeFueraRango = Float.parseFloat(cmd.getOptionValue("f"));
            float porcentajeIncorrecto = Float.parseFloat(cmd.getOptionValue("i"));

            if (isValidFloat(porcentajeCorrecto) && isValidFloat(porcentajeIncorrecto) && isValidFloat(porcentajeFueraRango)) {
                // Verificamos que la suma de los argumentos sea igual a 1 SE DEBERA CONTINUAR AQUI
                if (porcentajeCorrecto + porcentajeFueraRango + porcentajeIncorrecto == 1.0f) {
                    Random random = new Random();

                    List<Float> rangos = new ArrayList<>();
        
                    float rangoCienArg1 = porcentajeCorrecto*Constantes.CIEN;

                    float rangoCienArg2 = porcentajeFueraRango*Constantes.CIEN;

                    float rangoCienArg3 = porcentajeIncorrecto*Constantes.CIEN;

                    rangos.add(rangoCienArg1);
                    rangos.add(rangoCienArg2);
                    rangos.add(rangoCienArg3);
                 
                    Collections.sort(rangos,Collections.reverseOrder());

                    int numeroAleatorioEntre0y100 = random.nextInt(101);
                    
                    boolean flagBigBro = Util.estaEnRango(numeroAleatorioEntre0y100, 100, rangos.get(0));
                    boolean flagMiddleKid = Util.estaEnRango(numeroAleatorioEntre0y100, rangos.get(0), rangos.get(1));
                    boolean flagSmall = Util.estaEnRango(numeroAleatorioEntre0y100, rangos.get(1), rangos.get(2));
                    try{
                    Cliente cli = new Cliente();

                    if(flagBigBro){

                        Float valorEncontrado = Util.generarNumeroAleatorioEntreRango(68f, 89f);
                        cli.startClient(valorEncontrado);

                        
                    }else if(flagMiddleKid){

                        Float valorEncontrador = Util.generarNumeroAleatorioEntreRango(0.0f, 67.0f);
                        cli.startClient(valorEncontrador);

                        
                    }else{

                        Float valorEncontrado = Util.generarNumeroAleatorioEntreRango(-68f, -1f);
                        cli.startClient(valorEncontrado);
                        
                    }
                }catch(IOException e){

                    System.out.println(e.getMessage());
                }

                } else {
                    System.err.println("La suma de los argumentos debe ser igual a 1.");
                }
            } else {
                System.err.println("Los argumentos deben ser números en punto flotante válidos entre 0 y 1.");
            }
        } catch (ParseException e) {
            System.err.println("Error al procesar los argumentos: " + e.getMessage());
        }
    }

    
    private static boolean isValidFloat(float num) {
        return num >= 0.0f && num <= 1.0f;
    }

}

