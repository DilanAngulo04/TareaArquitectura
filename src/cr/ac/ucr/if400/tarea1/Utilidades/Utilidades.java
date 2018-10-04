/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.if400.tarea1.Utilidades;

/**
 *
 * @author Melissa Ramirez R
 */
public class Utilidades {

    public static double binaryDecimal(String binary) {
        double digit, decimal;
        int exponent;

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
        }//fin while

        return decimal + expNegative("" + binary);
    }//fin metodo

    public static long getDecimal(String num) {
        String decimales = "";
        for (int i = 0; i <= num.length() - 1; i++) {//se recorre el numero para determinar la posicion del punto decimal
            if (num.charAt(i) == '.') {
                for (int f = i + 1; f <= num.length() - 1; f++) {//apartir del punto de toma el numero decimal
                    decimales += "" + num.charAt(f);
                }//fin for
            }//fin de la condicion
        }//fin for
        return Long.parseLong(decimales);
    }//fin metodo

    //metodo que resuele la parte decimal en base binaria 
    public static double expNegative(String binaryNumber) {
        double numberFinal = 0;
        int j = 0;
        for (int f = 0; f <= binaryNumber.length() - 1; f++) {
            if (binaryNumber.charAt(f) == '.') {
                for (int i = f + 1; i < binaryNumber.length(); i++) {
                    numberFinal += Integer.parseInt("" + binaryNumber.charAt(i)) * Math.pow(2, --j);
                }//fin for
            }//fin if
        }//fin for
        return numberFinal;
    }//fin del metodo

    //Metodo para convertir un numero binario en uno con base hexadeciaml
    public static String binarioToHexa(String binario) {
        Integer number = 0;//numero por defecto
        try {
            number = Integer.valueOf(binario, 2);//Se hace uso de las herramientas de java
        } catch (NumberFormatException e) {
        }
        return Integer.toHexString(number).toUpperCase(); //Se retornan todas las letras en mayusculas
    }//fin metodo

    //metodo que retorna la parte decimal de un numero
    public static String decimalFormat(String numero) {
        String decimales = "0";
        String binary2 = numero + "";

        for (int i = 0; i <= numero.length() - 1; i++) {
            if (numero.charAt(i) == '.') {
                for (int f = i; f <= binary2.length() - 1; f++) {
                    decimales += "" + binary2.charAt(f);
                }//fin for anidado
            }//fin if
        }//fin for
        return decimales;
    }//fin metodo

    public static String decimalToBinario(int numero) {
        return Integer.toBinaryString(numero);
    }

    public static int binarioToDecimal(String binario) {
        Integer numero = 0;
        try {
            numero = Integer.valueOf(binario, 2);
        } catch (NumberFormatException e) {
        }
        return numero.intValue();
    }

    //Matodo complementario para la convercion de base decimal a base binaria
    public static double decimalBinaryX(double decimales) {

        String binary3 = "";
        while (decimales != 0.0) {//cuando el numero llegue a 0.0 se romple el ciclo
            binary3 += "" + (short) (decimales * 2);
            decimales = Double.parseDouble(decimalFormat(decimales * 2 + ""));
        }//fin while

        return Double.parseDouble(binary3);
    }//fin metodo

    public static boolean negOrPos(String num) {
        if (num.charAt(0) == '-') {
            return true;
        }
        return false;
    }

    public static boolean testNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '.') {
                return true;
            }
        }
        return false;
    }

    public static String formatExp(String exp) {
        int ceros = 0;
        String cadenaCeros = "";
        String newExp = "";

        if (exp.length() < 5) {
            ceros = 5 - exp.length();
            for (int i = 0; i < ceros; i++) {
                cadenaCeros += "0";
            }
            newExp = cadenaCeros + exp;
        } else {
            for (int i = 0; i < 5; i++) {
                newExp += exp.charAt(i);
            }
        }
        return newExp;
    }

    public static String formatMantisa(String dec) {
        String decString = "" + dec;
        String decFormat = "";
        if (decString.length() > 10) {

            for (int i = 0; i < 10; i++) {
                decFormat += decString.charAt(i);
            }
        } else {
            int cerosCant = 10 - decString.length();
            for (int i = 0; i < cerosCant; i++) {
                decString += "0";
            }
            return decString;

        }
        return decFormat;
    }

    private static String flipNumber(String number) {
        String flipedNumber = "";
        for (int i = number.length() - 1; i >= 0; i--) {
            flipedNumber += "" + number.charAt(i);
        }
        return flipedNumber;
    }

    public static Object[] check(String binaryNumb) {

        String numbBinaryTemp = "" + binaryNumb;
        boolean first = false, second = false;
        Object normalizedNumber[] = new Object[2];
        for (int i = numbBinaryTemp.length() - 1; i >= 0; i--) {
            if (numbBinaryTemp.charAt(i) == '.' && i == 1) {
                first = true;
            } else if (numbBinaryTemp.charAt(i) == '.' && i != 1) {
                second = true;
            }
        }
        if (first) {
            normalizedNumber = firstMethod(binaryNumb);
        } else {
            normalizedNumber = secondMethod(binaryNumb);
        }

        return normalizedNumber;
    }

    public static String twoComplement(String stringNumber) {
        String stringNumberConcat = "";
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

    public static Object[] secondMethod(String binaryNumb) {
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

        binaryString = flipNumber(binaryString);
      
        Object objArray[] = new Object[2];
        objArray[0] = dec - 1;
        objArray[1] = Utilidades.decimal(binaryString);

        return objArray;

    }

    public static Object[] firstMethod(String binaryNum) {
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
        Object objArray[] = new Object[2];
        objArray[0] = dec;
        objArray[1] = Utilidades.decimal(numConcat);

        return objArray;
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

    //Metodo para convertir un numero decimal a uno binario
    public static String decimalBinary(String number) {

        //Se toma la parte decimal de numero
        String decimalNumber = "" + decimalBinaryX(Double.parseDouble(decimalFormat(number)));

        String binary = "";//Concatena el numero binario
        //Se toma la parte entera del numero 
        long aux = (long) Double.parseDouble(number);
        while (aux > 0) {
            binary = (aux % 2) + binary;
            aux /= 2;
        }

        long binaryFinal = 0;
        if (aux > 0) {
            binaryFinal = Long.parseLong(binary);
        }

        double binaryFinal2 = Double.parseDouble(decimalNumber);
      
        //Se concatena el resultado de ambas partes
        return binaryFinal + "." + (long) binaryFinal2;

    }//fin metodo

    public static String decimal(String binary) {
        String decimalNumber = "";

        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) != '.') {
                decimalNumber += binary.charAt(i);
            } else {
                i = -1;
            }
        }
        return flipNumber(decimalNumber);
    }

    public static String fifteenExcess(int exp) {
        int suma = 15 + exp;
    
        return Utilidades.decimalToBinario(suma);
    }

    public static String addNumber(String num) {
        String concatNum = "";
        int count = 5 - num.length();

        for (int i = 0; i < count; i++) {
            concatNum += 0;
        }

        return concatNum + num;
    }

    public static String leer(Object decimalNumber) {
        String concatBinary = ""; // string que concatena las partes
        Object binaryNumber; // obtiene el numero entrante convertido a binario
        String normalizeNumber = ""; // obtiene la mantiza con formato igual a 10 bits 
        String exponent = "";

        //pregunto si el numero entrante es un entero o tiene decimales, 
        //dependiendo de lo anterior lo convierto a binario utilizando un metodo u otro
        if (testNumber("" + decimalNumber) == false) {
            binaryNumber = decimalToBinario(Integer.parseInt((String) decimalNumber));
        } else {
            binaryNumber = "" + Utilidades.binaryDecimal("" + decimalNumber);
        }

        // si es negativo le añado un uno como bit significativo, de ser negativo le coloco un 0
        if (negOrPos("" + decimalNumber) == true) {
            concatBinary += '1';
        } else {
            concatBinary += '0';
        }

        //En esta parte normalizo el numero entrante, lo que se hace es tomar el numero binario entrante y
        // obtenerle la mantisa y el exponente, que depende de cuantas veces se mueva la coma en el numero
        Object obj[] = Utilidades.check("" + binaryNumber);
        normalizeNumber = "" + formatMantisa((String) obj[1]);

        if ((int) obj[0] < 0) {
            //negativo, se le saca el complemento a dos
            int numPositivo = Integer.parseInt(negativeToPositive("" + obj[0]));
            exponent = Utilidades.twoComplement("" + formatExp("" + numPositivo));
            } else {
            // positivo, le saco exceso a quince
            exponent = Utilidades.fifteenExcess((int) obj[0]);
            exponent = formatExp(exponent);
        }

        concatBinary += exponent;

        concatBinary += normalizeNumber;

        return concatBinary;
    }

    public static String hexaToBinary(String hexa) {
        Integer number = 0;//numero por defecto
        try {
            number = Integer.valueOf(hexa, 16);//Se hace uso de las herramientas de java
        } catch (NumberFormatException e) {
        }
        return Integer.toBinaryString(number).toUpperCase(); //Se retornan todas las letras en mayusculas
    }//fin metodo

    public static String impresion(String hexa) {

        String binary = hexaToBinary(hexa);//Paso el numero hexadecimnal a binario
        String concatDecimalNumber = "1";
       
        if (binary.length() < 16) {
            while (binary.length() < 16) {
                binary = '0' + binary;
            }
        }

        String aux1 = binary.substring(1, 6);
        System.out.println(aux1);

        int preExceso = binarioToDecimal(aux1);
        System.out.println(preExceso);

        int exceso = preExceso - 15;
        System.out.println(exceso);

        System.out.println("binary " + binary);
        int n = 0;
        boolean exc = false;

        for (int i = 7; i < binary.length(); i++) {

            if (n == exceso) {
                System.out.println("n " + n);
                concatDecimalNumber += ".";
                concatDecimalNumber += "" + binary.charAt(i);
                exc = true;
                n++;

            }
            concatDecimalNumber += "" + binary.charAt(i);
            n++;
        }

        System.out.println(concatDecimalNumber);

//        if (!exc) {
//            if (binary.charAt(0) == '1') {
//                if (exceso > concatDecimalNumber.length() - 2) {
//                    System.out.println("tes1");
//                    while (concatDecimalNumber.length() - 2 < exceso) {
//                        concatDecimalNumber += '0';
//                        System.out.println(concatDecimalNumber);
//                    }
//                }
//                concatDecimalNumber = "" + negativeToPositive(concatDecimalNumber);
//            } else {
//                if (exceso > concatDecimalNumber.length() - 1) {
//                    System.out.println("tes2");
//                    while (concatDecimalNumber.length() - 1 < exceso) {
//                        concatDecimalNumber += '0';
//                    }
//                }
//            }
//        }
        boolean convertDecimal = false;
        for (int i = 0; i < concatDecimalNumber.length(); i++) {
            if (concatDecimalNumber.charAt(i) == '.') {
                concatDecimalNumber = "" + binaryDecimal(concatDecimalNumber);
                convertDecimal = true;
            }
        }

        if (!convertDecimal) {
            concatDecimalNumber = "" + binarioToDecimal(concatDecimalNumber);
        }

        if (binary.charAt(0) == '1') {
            System.out.println("yes");
            concatDecimalNumber = "-" + concatDecimalNumber;
        }

        return concatDecimalNumber;

    }

    // metodo que pasa de un numero negativo a positivo
    public static String negativeToPositive(String num) {
        String numString = "" + num;
        String newNum = "";

        for (int i = 1; i < numString.length(); i++) {
            newNum += numString.charAt(i);
        }
        return newNum;
    }

}
