package com.epam.tat.calculator.impl;

import com.epam.tat.calculator.ICalculator;
import org.apache.commons.math3.util.Precision;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator implements ICalculator {

    private int precision;
    private final String regex = "\\d+(\\.)?\\d*[\\+\\-\\*\\/]\\d+(\\.)?\\d*";


    public Calculator(int precision) {
        this.precision = precision;
    }

    public String getRegex() {
        return regex;
    }

    @Override
    public double add(double a, double b) {
        return Precision.round(a + b, this.precision);
    }

    @Override
    public double subtract(double a, double b) {
        return Precision.round(a - b, this.precision);
    }

    @Override
    public double multiply(double a, double b) {
        return Precision.round(a * b, this.precision);
    }

    @Override
    public double divide(double a, double b) {
        return Precision.round(a / b, this.precision);
    }

    @Override
    public String searchAction(String expression) {
        String escapeSymbol = "\\";
        String action = " ";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' ||
                    expression.charAt(i) == '/') {
                // action = escapeSymbol + expression.charAt(i);
                action = escapeSymbol.concat(Character.toString(expression.charAt(i)));
                break;

            }
        }
        return action;
    }
    @Override
    public boolean checkExpression (String expression, String forCheck) {
        Pattern pattern = Pattern.compile(forCheck);
        Matcher matcher = pattern.matcher(expression);
        return matcher.matches();
    }
    @Override
    public double[] stringToDouble (String[] parseString) {
        double [] arrToAction = new double[2];
        for (int i = 0; i< parseString.length; i++) {
            arrToAction[i]= Double.parseDouble(parseString[i]);

        }
        return arrToAction;

    }

}

