/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author win
 */
public enum Operator {
    ADD('+'), SUBTRACT('-'), MULTIPLY('*'), DIVIDE('/'),
    EXPONENT('^'), EQUALS('=');
    private char value;

    private Operator(char value) {
        this.value = value;
    }
    
    public static Operator checkOperator(char operator) {
        switch (operator) {
            case '+':
                return ADD;
            case '-':
                return SUBTRACT;
            case '*':
                return MULTIPLY;
            case '/':
                return DIVIDE;
            case '^':
                return EXPONENT;
            case '=':
                return EQUALS;
            default:
                return null;
        }
    }

    public char getValue() {
        return value;
    }
    
}
