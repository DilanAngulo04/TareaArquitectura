package cr.ac.ucr.if400.tarea1.Utilidades;

import static java.lang.System.exit;

public class Utilidades {
    
    
    
    public static double binaryDecimal(String binary) {
        double aux, digit, decimal;
        int exponent;
        boolean isBinario;

        exponent = 0;
        decimal = 0; //será el equivalente en base decimal
        int numero = (int) Double.parseDouble(binary);
        while (numero != 0) {
            //se toma la última cifra
            digit = numero % 10;
            //se multiplica por la potencia de 2 correspondiente y se suma al número
            decimal = decimal + digit * (int) Math.pow(2, exponent);
            //se aumenta el exponente
            exponent++;
            //se quita la última cifra para repetir el proceso
            numero = numero / 10;
        }

        return decimal + expNegative("" + binary);
    }

    public static String decimalBinary(String number) {

        String decimalNumber = "" + decimalBinaryX(Double.parseDouble(decimalFormat(number)));
        System.out.println(decimalNumber);

        String binary = "";//Concatena el numero binario
        long aux = (long) Double.parseDouble(number);
        System.out.println(aux);
        while (aux > 0) {
            System.out.println(binary);
            binary = (aux % 2) + binary;
            aux /= 2;
        }

        long binaryFinal = 0;
        if (aux > 0) {
            binaryFinal = Long.parseLong(binary);
        }

        double binaryFinal2 = Double.parseDouble(decimalNumber);
        System.out.println(binaryFinal2);

        return "Result " + binaryFinal + "." + (long) binaryFinal2;

    }

    public static double decimalBinaryX(double decimales) {

        System.out.println(decimales);

        String binary3 = "";
        while (decimales != 0.0) {
            System.out.println(decimales);
            binary3 += "" + (short) (decimales * 2);
            decimales = Double.parseDouble(decimalFormat(decimales * 2 + ""));
        }

        return Double.parseDouble(binary3);
    }

    public static String decimalFormat(String numero) {
        String decimales = "0";
        String binary2 = numero + "";

        for (int i = 0; i <= numero.length() - 1; i++) {
            if (numero.charAt(i) == '.') {
                System.out.println("si");
                System.out.println("i " + i);
                for (int f = i; f <= binary2.length() - 1; f++) {
                    decimales += "" + binary2.charAt(f);
                }
            }

        }

        return decimales;

    }

//    public static boolean isBinary(double binaryNum) {
//        boolean isBinaryNum = true;
//        String number = binaryNum + "";
//        for (int i = 0; i <= number.length() - 1; i++) {
//            if (number.charAt(i) != 1 && number.charAt(i) != 0 && number.charAt(i) != '.') {
//                System.out.println(number.charAt(i));
//                isBinaryNum = false;
//            }
//        }
//
//        return isBinaryNum;
//
//    }
    public static short getIntex(double binaryNum) {
        short index = 0;
        String number = binaryNum + "";
        for (int i = 0; i <= number.length() - 1; i++) {
            if (number.charAt(i) == '.') {
                index = (short) i;
                return index;
            }
        }
        return index;
    }

    public static long getDecimal(String num) {

        System.out.println(num);
        String decimales = "";
        for (int i = 0; i <= num.length() - 1; i++) {
            if (num.charAt(i) == '.') {
                System.out.println("i" + i);
                System.out.println("si");
                for (int f = i + 1; f <= num.length() - 1; f++) {
                    decimales += "" + num.charAt(f);
                    System.out.println("decimales" + decimales);
                }
            }
        }

        return Long.parseLong(decimales);
    }

    public static double expNegative(String binaryNumber) {

        double numberFinal = 0;
        int j = 0;
        for (int f = 0; f <= binaryNumber.length() - 1; f++) {
            if (binaryNumber.charAt(f) == '.') {
                System.out.println("si");
                System.out.println("f" + f);
                for (int i = f + 1; i < binaryNumber.length(); i++) {
                    System.out.println("i" + i);
                    System.out.println("char " + binaryNumber.charAt(i));
                    numberFinal += Integer.parseInt("" + binaryNumber.charAt(i)) * Math.pow(2, --j);
                    System.out.println("j" + j);
                }
            }

        }

        return numberFinal;
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
