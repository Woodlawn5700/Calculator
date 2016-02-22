package ru.Pasha;

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
            System.out.println("Введите число знак число");
            String inscription = reader.readLine();// вводим с клавиатуры строчку
            if (inscription.isEmpty()) //  выход из цикла
                break;
        }
    }
    public static void metrodWithSpace(String inscription ) {
        Operatino operation = new Operatino();

        if (inscription.contains("*")) {
            String sign = "*";
            int stringLeght = inscription.length();
            int index = inscription.indexOf("*");
            String firstNumber = inscription.substring(0, index - 1);
            String secongNumber = inscription.substring(index + 2, stringLeght);
            double firstNUmberDouble = Double.parseDouble(firstNumber);
            double secongNUmberDouble = Double.parseDouble(secongNumber);
            operation = new Multiplication(firstNUmberDouble, secongNUmberDouble);
        } else if (inscription.contains("+")) {
            String sign = "+";
            int stringLeght = inscription.length();
            int index = inscription.indexOf("+");
            String firstNumber = inscription.substring(0, index - 1);
            String secongNumber = inscription.substring(index + 2, stringLeght);
            double firstNUmberDouble = Double.parseDouble(firstNumber);
            double secongNUmberDouble = Double.parseDouble(secongNumber);
            operation = new Addition(firstNUmberDouble, secongNUmberDouble);
        } else if (inscription.contains("-")) {
            String sign = "-";
            int stringLeght = inscription.length();
            int index = inscription.indexOf("-");
            String firstNumber = inscription.substring(0, index - 1);
            String secongNumber = inscription.substring(index + 2, stringLeght);
            double firstNUmberDouble = Double.parseDouble(firstNumber);
            double secongNUmberDouble = Double.parseDouble(secongNumber);
            operation = new Substraction(firstNUmberDouble, secongNUmberDouble);
        } else if (inscription.contains("/")) {
            String sign = "/";
            int stringLeght = inscription.length();
            int index = inscription.indexOf("/");
            String firstNumber = inscription.substring(0, index - 1);
            String secongNumber = inscription.substring(index + 2, stringLeght);
            double firstNUmberDouble = Double.parseDouble(firstNumber);
            double secongNUmberDouble = Double.parseDouble(secongNumber);
            if (secongNUmberDouble == 0) {
                System.out.println("На ноль делить нельзя");
                break;
            } else
                operation = new Dividing(firstNUmberDouble, secongNUmberDouble);
        }
        System.out.println(operation.run());
    }
}
