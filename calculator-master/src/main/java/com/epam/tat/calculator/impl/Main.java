package com.epam.tat.calculator.impl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int precision;
        String expression;
        double[] arrToAction;
        String choose ="1";
        Scanner in = new Scanner(System.in);
        do {
                    System.out.println("Enter the precision of calculate");
                    try {
                        precision = in.nextInt();
                        if (precision >= 0) {
                            Calculator calc = new Calculator(precision);
                            System.out.println("Enter the expression for calculate");
                            expression = in.next();
                            if (calc.checkExpression(expression, calc.getRegex())) {

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
                                        if (arrToAction[1] != 0) {
                                            System.out.println(calc.divide(arrToAction[0], arrToAction[1]));
                                            break;
                                        } else System.out.println("Incorrect input");
                                }
                            } else System.out.println("Incorrect input");
                        } else System.out.println("Incorrect input");
                    } catch (Exception e) {
                        System.out.println("Incorrect input");
                    }
                    System.out.println("Enter 1 to continue or 2 to exit");
                    choose = in.next();
            }
        while (choose.equals("1"));
        }


    }


