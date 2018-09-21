package cr.ac.ucr.if400.tarea1.Utilidades;

import static java.lang.System.exit;

public class Utilidades {
      public static long binaryDecimal(long binary) {
        long aux, digit, decimal;
        int exponent;
        boolean isBinario;

        do {
            isBinario = true;
            aux = binary;
            while (aux != 0) {
                digit = aux % 10;
                if (digit != 0 && digit != 1) {                 
                    System.err.println("El numero ingresado no es binario");
                    exit(0);
                }
                aux = aux / 10;
            }
        } while (!isBinario);

        exponent = 0;
        decimal = 0; 
        while (binary != 0) {
            digit = binary % 10;
            decimal = decimal + digit * (int) Math.pow(2, exponent);
            exponent++;
            binary = binary / 10;
        }
        return decimal;
    }

    public static long decimalBinary(long number) {

        String binary = "";
        while (number > 0) {
            binary = (number % 2) + binary;
            number /= 2;
        }
        long binaryFinal = Long.parseLong(binary);
        return binaryFinal;
    }
}
