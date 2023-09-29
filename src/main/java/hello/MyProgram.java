package hello;



import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class MyProgram {
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

            // Verificamos que los argumentos sean números válidos
            if (isValidFloat(porcentajeCorrecto) && isValidFloat(porcentajeIncorrecto) && isValidFloat(porcentajeFueraRango)) {
                // Verificamos que la suma de los argumentos sea igual a 1
                if (porcentajeCorrecto + porcentajeFueraRango + porcentajeIncorrecto == 1.0f) {
                    System.out.println("Primer argumento: " + porcentajeCorrecto);
                    System.out.println("Segundo argumento: " + porcentajeFueraRango);
                    System.out.println("Tercer argumento: " + porcentajeIncorrecto);
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

    // Función para verificar si un número en punto flotante es válido
    private static boolean isValidFloat(float num) {
        return num >= 0.0f && num <= 1.0f;
    }
}

