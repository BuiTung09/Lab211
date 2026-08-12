/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import utils.Validator;

/**
 *
 * @author win
 */
public class NormalCalculator {

    private double a;
    private double b;
    private Operator operator;

    public NormalCalculator() {
    }

    public NormalCalculator(double a,
            double b, Operator operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

    public double calculate() throws Exception{
        switch (operator) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b == 0) {
                    throw new ArithmeticException("Can not divide with 0!");
                }
                return a / b;
            case EXPONENT:
                return Math.pow(a, b);
            default:
                throw new NullPointerException();
        }
    }

}
