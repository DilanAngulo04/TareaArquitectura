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

    public static Double check(String binaryNumb) {

        String numbConcat = "", numbBinaryTemp = "" + binaryNumb;
        int lenght = numbBinaryTemp.length();
        boolean first = false, second = false;
        String newNumber = "";
        for (int i = numbBinaryTemp.length() - 1; i >= 0; i--) {
            if (numbBinaryTemp.charAt(i) == '.' && i == 1) {
                first = true;
                newNumber = firstMethod(binaryNumb);
            } else if (numbBinaryTemp.charAt(i) == '.' && i != 1) {
                second = true;
                newNumber = secondMethod(binaryNumb);
            }
        }
        return Double.parseDouble(newNumber);
    }

    public static String secondMethod(String binaryNumb) {
        String binaryString = "";
        boolean flag = false;
        int counter = binaryNumb.length() - 1;
        int dec = 0;
        while (counter >= 0) {
            if (binaryNumb.charAt(counter) == '.') {
                flag = true;
                counter--;
            } else {

                if (flag == true) {
                    dec++;
                }
                if (counter == 0) {
                    binaryString += "." + binaryNumb.charAt(counter);
                    counter--;
                } else {
                    binaryString += binaryNumb.charAt(counter);
                    counter--;
                }
            }

        }

        binaryString = flipNumber(binaryNumb);
        return binaryString;

    }

    public static String firstMethod(String binaryNum) {
        String numConcat = "";
        boolean flag = false;
        int counter = 0;
        int dec = 0;
        for (int i = binaryNum.length() - 1; i >= 0; i--) {
            if (binaryNum.charAt(i) == '.') {
                flag = true;
            } else {
                if (i == 2) {
                    numConcat += "." + binaryNum.charAt(i);
                } else {
                    numConcat += binaryNum.charAt(i);

                }
                if (flag == true) {
                    dec++;
                }
            }
        }

        numConcat = flipNumber(numConcat);
        return numConcat;
    }
}
