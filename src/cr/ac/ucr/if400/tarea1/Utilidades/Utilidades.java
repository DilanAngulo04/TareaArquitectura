package cr.ac.ucr.if400.tarea1.Utilidades;

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

    //Metodo para convertir un numero decimal a uno binario
    public static String decimalBinary(String number) {

        //Se toma la parte decimal de numero
        String decimalNumber = "" + decimalBinaryX(Double.parseDouble(decimalFormat(number)));

        String binary = "";//Concatena el numero binario
        //Se toma la parte entera del numero 
        long aux = (long) Double.parseDouble(number);
        System.out.println(aux);
        while (aux > 0) {
            binary = (aux % 2) + binary;
            aux /= 2;
        }

        long binaryFinal = 0;
        if (aux > 0) {
            binaryFinal = Long.parseLong(binary);
        }

        double binaryFinal2 = Double.parseDouble(decimalNumber);
        System.out.println(binaryFinal2);

        //Se concatena el resultado de ambas partes
        return "Result " + binaryFinal + "." + (long) binaryFinal2;

    }//fin metodo

    //Metodo para convertir un numero binario en uno con base hexadeciaml
    public static String binarioToHexa(String binario) {
        Integer number = 0;//numero por defecto
        try {
            number = Integer.valueOf(binario, 2);//Se hace uso de las herramientas de java
        } catch (NumberFormatException e) {
        }
        return Integer.toHexString(number).toUpperCase(); //Se retornan todas las letras en mayusculas
    }//fin metodo

    //Matodo complementario para la convercion de base decimal a base binaria
    public static double decimalBinaryX(double decimales) {

        String binary3 = "";
        while (decimales != 0.0) {//cuando el numero llegue a 0.0 se romple el ciclo
            System.out.println(decimales);
            binary3 += "" + (short) (decimales * 2);
            decimales = Double.parseDouble(decimalFormat(decimales * 2 + ""));
        }//fin while

        return Double.parseDouble(binary3);
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

    private static String flipNumber(String number) {
        String flipedNumber = "";
        for (int i = number.length() - 1; i >= 0; i--) {
            flipedNumber += "" + number.charAt(i);
        }//fin for
        return flipedNumber;
    }//fin del metoso

    public static String twoComplement(long number) {
        String stringNumber = "" + number, stringNumberConcat = "";
        boolean firstOne = false, addOne = false;
        for (int i = stringNumber.length() - 1; i >= 0; i--) {
            char numberC = stringNumber.charAt(i);
            if (numberC == '1' && firstOne == false) {
                firstOne = true;
                stringNumberConcat += '1';
            }//fin if
            if (firstOne == true) {
                if (addOne == false) {
                    addOne = true;
                } else {
                    if (numberC == '1') {
                        stringNumberConcat += '0';
                    } else {
                        stringNumberConcat += '1';
                    }//fin else
                }//fin else
            } else {
                stringNumberConcat += numberC;
            }//fin else
        }//fin for
        return flipNumber(stringNumberConcat);
    }//fin metodo

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
            }//fin if/else
        }//fin for
        return Double.parseDouble(newNumber);
    }//fin metodo

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
                }//fin if
                if (counter == 0) {
                    binaryString += "." + binaryNumb.charAt(counter);
                    counter--;
                } else {
                    binaryString += binaryNumb.charAt(counter);
                    counter--;
                }//fin else
            }//fin else
        }//fin while
        binaryString = flipNumber(binaryNumb);
        return binaryString;
    }//fin metodo

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
                }//fin else
                if (flag == true) {
                    dec++;
                }//fin if
            }//fin else
        }//fin for

        numConcat = flipNumber(numConcat);
        return numConcat;
    }//fin metodo
}//fin clse Utilidades
