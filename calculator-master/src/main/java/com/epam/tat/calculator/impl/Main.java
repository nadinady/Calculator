package com.epam.tat.calculator.impl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int precision;
        String expression;
        double [] arrToAction;
        System.out.println ("Enter the precision of calculate");
        Scanner in = new Scanner(System.in);
        precision = in.nextInt();
        Calculator calc = new Calculator(precision);
        System.out.println ("Enter the expression for calculate");
        expression = in.next();
        if (calc.checkExpression(expression)) {

            arrToAction = calc.stringToDouble(expression.split(calc.searchAction(expression)));
        switch (calc.searchAction(expression)) {
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
