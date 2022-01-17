package com.epam.tat.calculator.impl;

import com.epam.tat.calculator.ICalculator;
import org.apache.commons.math3.util.Precision;

public class Calculator implements ICalculator {

    private int precision;

    public Calculator(int precision) {
        this.precision = precision;
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
}

