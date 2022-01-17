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
        return Precision.round(a+b,this.precision);
    }

    @Override
    public double subtract(double a, double b) {
        return Precision.round(a-b,this.precision);
    }

    @Override
    public double multiply(double a, double b) {
        return Precision.round(a*b,this.precision);
    }

    @Override
    public double divide(double a, double b) {
        return Precision.round(a/b,this.precision);
    }
}
