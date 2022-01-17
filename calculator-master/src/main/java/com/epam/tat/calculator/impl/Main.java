package com.epam.tat.calculator.impl;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int precision;
        String expression;
        String [] parseString;
        String action;
        double [] arrToAction = new double[2];
        String regex = "\\d+(\\.)?\\d*[\\+\\-\\*\\/]\\d+(\\.)?\\d*";
        Pattern pattern = Pattern.compile(regex);
        System.out.println ("Enter the precision of calculate");
        Scanner in = new Scanner(System.in);
        precision = in.nextInt();
        Calculator calc = new Calculator(precision);
        System.out.println ("Enter the expression for calculate");
        expression = in.next();
        Matcher matcher = pattern.matcher(expression);
        if (matcher.matches()) {
            action = calc.searchAction(expression);
            parseString =expression.split(action);
            for (int i = 0; i< parseString.length; i++) {
                arrToAction[i]= Double.parseDouble(parseString[i]);

            }
        switch (action) {
            case "\\+":
                System.out.println(calc.add(arrToAction[0], arrToAction[1]));
            break;
            case "\\-":
                System.out.println(calc.subtract(arrToAction[0], arrToAction[1]));
                break;
            case "\\*":
                System.out.println(calc.multiply(arrToAction[0], arrToAction[1]));
                break;
            case "\\/":
                System.out.println(calc.divide(arrToAction[0], arrToAction[1]));
                break;
        }
        }
        else System.out.println("Incorrect input");
    }
}
