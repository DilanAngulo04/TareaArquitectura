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

    private static String flipNumber(String number) {
        String flipedNumber = "";
        for (int i = number.length() - 1; i >= 0; i--) {
            flipedNumber += "" + number.charAt(i);
        }
        return flipedNumber;
    }

    public static String twoComplement(long number) {
        String stringNumber = "" + number, stringNumberConcat = "";
        boolean firstOne = false, addOne = false;

        for (int i = stringNumber.length() - 1; i >= 0; i--) {
            char numberC = stringNumber.charAt(i);
            if (numberC == '1' && firstOne == false) {
                firstOne = true;
                stringNumberConcat += '1';
            }
            if (firstOne == true) {
                if (addOne == false) {
                    addOne = true;
                } else {
                    if (numberC == '1') {
                        stringNumberConcat += '0';
                    } else {
                        stringNumberConcat += '1';
                    }
                }
            } else {
                stringNumberConcat += numberC;

            }
        }

        return flipNumber(stringNumberConcat);
    }

    public static String normalizeNumber(String number) {
        String stringNumber = "" + number;
        boolean first = false, second = false, third = false;

        for (int i = stringNumber.length() - 1; i >= 0; i--) {
            // evalua el caso 
            if (stringNumber.charAt(i) == ',' && i >= 2) {
                // caso en el que se debe mover la coma hacia la izquierda (sumar) 
                first = true;
            } else if (stringNumber.charAt(i) == ',' && i == 1 && stringNumber.charAt(0) == '0') {
                // caso en el que se debe mover la coma hacia la derecha (restar)
                second = true;
            }
        }
        if (!first && !second) {
            // no habia coma en el numero, se debe mover hacia la derecha(restar)
            third = true;
        }
        System.out.println(first + ", " + second + ", " + third);
        return "";
    }

    public static boolean check(String number) {
        boolean bandera = false;
        boolean first = false, second = false, third = false;
        int counter = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            if ((bandera == true && i != 0 && first == false)
                    || (bandera == true && number.charAt(i) == '0' && i == 0 && first == false)) {
                second = true;
            }
            if (bandera == true && number.charAt(i) == '1' && i != 0) {
                first = true;
                second = false;
            }

            if (number.charAt(i) == ',') {
                bandera = true;
            }

        }
        
        if (bandera == false) {
            third = true;
        } else {
            // el numero tiene la coma con un numero, es decir, no se modifica
        }

        System.out.println(first + ", " + second + ", " + third);
        return false;
    }

    private static String first(String number) {
        String stringTemp = "";
        int counter = 0;
        for (int i = number.length(); i > 0; i++) {
            if (number.charAt(i) == ',') {
                counter++;
            }
            if (i == 1 && i == 0) {
                stringTemp = "," + number.charAt(i);
            } else {
                stringTemp = "" + number.charAt(i);
            }
        }
        return "";
    }
}
