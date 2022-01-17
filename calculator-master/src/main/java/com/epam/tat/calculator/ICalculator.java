package com.epam.tat.calculator;

public interface ICalculator {

    double add(double a, double b);

    double subtract(double a, double b);

    double multiply(double a, double b);

    double divide(double a, double b);

    boolean checkExpression (String expression, String forCheck);

    String searchAction (String expression);

    double[] stringToDouble (String[] parseString);

}
