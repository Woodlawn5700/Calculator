package ru.Pasha;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;

/**
 * Created by pavelpetrov on 21.02.16.
 */

public class Calculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (true) {

            System.out.println("Давайте вычеслим два положительных числа");
            String inscription = reader.readLine();// вводим с клавиатуры строчку

            inscription = inscription.trim();

            if (inscription.isEmpty())
                System.out.println("Вы ничего не ввели");
            if(inscription.contains(" "))
                metrodWithSpace(inscription);
            else if(!inscription.contains(" "))
                methodWithoutSpace(inscription);
        }
    }
    public static void metrodWithSpace(String inscription ) { // метод с пробелом
        Operatino operation = new Operatino();

        if (inscription.contains("*")) {
            int stringLeght = inscription.length();
            int index = inscription.indexOf("*");
            String firstNumber = inscription.substring(0, index - 1);
            String secongNumber = inscription.substring(index + 2, stringLeght);
            errow(firstNumber);
            double firstNUmberDouble = Double.parseDouble(firstNumber);
            errow(secongNumber);
            double secongNUmberDouble = Double.parseDouble(secongNumber);
            operation = new Multiplication(firstNUmberDouble, secongNUmberDouble);
        } else if (inscription.contains("+")) {
            int stringLeght = inscription.length();
            int index = inscription.indexOf("+");
            String firstNumber = inscription.substring(0, index - 1);
            String secongNumber = inscription.substring(index + 2, stringLeght);
            double firstNUmberDouble = Double.parseDouble(firstNumber);
            double secongNUmberDouble = Double.parseDouble(secongNumber);
            operation = new Addition(firstNUmberDouble, secongNUmberDouble);
        } else if (inscription.contains("/")) {
            int stringLeght = inscription.length();
            int index = inscription.indexOf("/");
            String firstNumber = inscription.substring(0, index - 1);
            String secongNumber = inscription.substring(index + 2, stringLeght);
            errow(firstNumber);
            double firstNUmberDouble = Double.parseDouble(firstNumber);
            errow(secongNumber);
            double secongNUmberDouble = Double.parseDouble(secongNumber);
            if (secongNUmberDouble == 0) {
                System.out.println("На ноль делить нельзя");
            } else
                operation = new Dividing(firstNUmberDouble, secongNUmberDouble);
        } else if (inscription.contains("-")) {
            char[] list = inscription.toCharArray();
            int minuscount = 0;
            for (int i = 0 ; i < list.length; i ++){
                if (list[i]=='-'){
                    minuscount++;
                }
            }
            if(minuscount == 1){
                int stringLeght = inscription.length();
                int index = inscription.indexOf("-");
                String firstNumber = inscription.substring(0, index-1);
                String secongNumber = inscription.substring(index + 2, stringLeght);
                errow(firstNumber);
                double firstNUmberDouble = Double.parseDouble(firstNumber);
                errow(secongNumber);
                double secongNUmberDouble = Double.parseDouble(secongNumber);
                operation = new Substraction(firstNUmberDouble, secongNUmberDouble);
            }
            if (minuscount == 3){
                for (int i = 1 ; i < list.length-2; i ++){
                    if (list[i] == '-'){
                        int stringLeght = inscription.length();
                        int index = i;
                        String firstNumber = inscription.substring(0, index-1);
                        String secongNumber = inscription.substring(index + 2, stringLeght);
                        errow(firstNumber);
                        double firstNUmberDouble = Double.parseDouble(firstNumber);
                        errow(secongNumber);
                        double secongNUmberDouble = Double.parseDouble(secongNumber);
                        operation = new Substraction(firstNUmberDouble, secongNUmberDouble);
                        break;
                    }
                }
            }
            if (minuscount == 2){
                for (int i = 1 ; i < list.length-2; i ++){
                    if (list[i] == '-') {
                        int stringLeght = inscription.length();
                        int index = i;
                        String firstNumber = inscription.substring(0, index-1);
                        String secongNumber = inscription.substring(index + 2, stringLeght);
                        errow(firstNumber);
                        double firstNUmberDouble = Double.parseDouble(firstNumber);
                        errow(secongNumber);
                        double secongNUmberDouble = Double.parseDouble(secongNumber);
                        operation = new Substraction(firstNUmberDouble, secongNUmberDouble);
                        break;
                    }
                }
            }
        }
        System.out.println(operation.run());
    }
    public static void methodWithoutSpace(String inscription ) {//метод без пробела
        Operatino operation = new Operatino();

        if (inscription.contains("*")) {
            int stringLeght = inscription.length();
            int index = inscription.indexOf("*");
            String firstNumber = inscription.substring(0, index);
            String secongNumber = inscription.substring(index + 1, stringLeght);
            errow(firstNumber);
            double firstNUmberDouble = Double.parseDouble(firstNumber);
            errow(secongNumber);
            double secongNUmberDouble = Double.parseDouble(secongNumber);
            operation = new Multiplication(firstNUmberDouble, secongNUmberDouble);
        } else if (inscription.contains("+")) {
            int stringLeght = inscription.length();
            int index = inscription.indexOf("+");
            String firstNumber = inscription.substring(0, index);
            String secongNumber = inscription.substring(index + 1, stringLeght);
            errow(firstNumber);
            double firstNUmberDouble = Double.parseDouble(firstNumber);
            errow(secongNumber);
            double secongNUmberDouble = Double.parseDouble(secongNumber);
            operation = new Addition(firstNUmberDouble, secongNUmberDouble);

        } else if (inscription.contains("/")) {
            int stringLeght = inscription.length();
            int index = inscription.indexOf("/");
            String firstNumber = inscription.substring(0, index);
            String secongNumber = inscription.substring(index + 1, stringLeght);
            errow(firstNumber);
            double firstNUmberDouble = Double.parseDouble(firstNumber);
            errow(secongNumber);
            double secongNUmberDouble = Double.parseDouble(secongNumber);
            if (secongNUmberDouble == 0) {
                System.out.println("На ноль делить нельзя");
            } else
                operation = new Dividing(firstNUmberDouble, secongNUmberDouble);
        } else if (inscription.contains("-")) {
            char[] list = inscription.toCharArray();
            int minuscount = 0;
            for (int i = 0 ; i < list.length; i ++){
                if (list[i]=='-'){
                    minuscount++;
                }
            }
            if(minuscount == 1){
                 int stringLeght = inscription.length();
                 int index = inscription.indexOf("-");
                 String firstNumber = inscription.substring(0, index);
                 String secongNumber = inscription.substring(index + 1, stringLeght);
                 errow(firstNumber);
                 double firstNUmberDouble = Double.parseDouble(firstNumber);
                 errow(secongNumber);
                 double secongNUmberDouble = Double.parseDouble(secongNumber);
                 operation = new Substraction(firstNUmberDouble, secongNUmberDouble);
            }
            if (minuscount == 3){
                for (int i = 1 ; i < list.length-2; i ++){
                    if (list[i] == '-'){
                        int stringLeght = inscription.length();
                        int index = i;
                        String firstNumber = inscription.substring(0, index);
                        String secongNumber = inscription.substring(index + 1, stringLeght);
                        errow(firstNumber);
                        double firstNUmberDouble = Double.parseDouble(firstNumber);
                        errow(secongNumber);
                        double secongNUmberDouble = Double.parseDouble(secongNumber);
                        operation = new Substraction(firstNUmberDouble, secongNUmberDouble);
                        break;
                    }
                }
            }
            if (minuscount == 2){
                for (int i = 1 ; i < list.length-1; i ++){
                    if (list[i] == '-') {
                        int stringLeght = inscription.length();
                        int index = i;
                        String firstNumber = inscription.substring(0, index);
                        String secongNumber = inscription.substring(index + 1, stringLeght);
                        if (!errow(firstNumber)) {
                            continue;
                        }
                        double firstNUmberDouble = Double.parseDouble(firstNumber);
                        if (!errow(secongNumber)) {
                            continue;
                        }
                        double secongNUmberDouble = Double.parseDouble(secongNumber);
                        operation = new Substraction(firstNUmberDouble, secongNUmberDouble);
                        break;
                    }
                    }
                }
        }
        System.out.println(operation.run());
    }
    public static boolean errow(String firstNumber ){ //метод вывода ошибки
        boolean result = true;
        try {
               double firstNUmberDouble = Double.parseDouble(firstNumber);
           }
           catch (NumberFormatException e){
               System.out.println("Пожалуйста вводите числа правильно");
               result = false;
           }

        return result;
    }
}


