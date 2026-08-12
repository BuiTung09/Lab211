/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import entity.BMI;
import entity.BMICalculator;
import entity.NormalCalculator;
import entity.Operator;
import utils.Validator;

/**
 *
 * @author acmon
 */
public class CaculatorView {
    public void menu(){
        NormalCalculator normalCalculator;
        BMICalculator bmiCalculator;

        while (true) {
            int choice = Validator.getInt(
                    "========= Calculator Program =========\n"
                    + "1. Normal Calculator\n"
                    + "2. BMI Calculator\n"
                    + "3. Exit\n"
                    + "Please choice one option: ",
                    "Just be 1->3",
                    "Invalid!",
                    1,
                    3
            );

            switch (choice) {
                case 1:
                    System.out.println("----- Normal Calculator -----");

                    double a = Validator.getDouble("Enter number: ","Error range!",
                            "Invalid!",
                            -Double.MAX_VALUE,
                            Double.MAX_VALUE
                    );

                    String stringOperator = Validator.getString("Enter Operator: ",
                            "Please input (+, -, *, /, ^)",
                            "^[+\\-*/^]$"
                    );

                    Operator operator = Operator.checkOperator(stringOperator.charAt(0));

                    double b = Validator.getDouble(
                            "Enter number: ",
                            "Error range!",
                            "Invalid!",
                            -Double.MAX_VALUE,
                            Double.MAX_VALUE
                    );

                    normalCalculator = new NormalCalculator(a, b, operator);
                    try {
                        double result = normalCalculator.calculate();
                        System.out.println("Result: " + result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("----- BMI Calculator -----");
                    bmiCalculator = new BMICalculator();
                    bmiCalculator.input();

                    BMI bmiResult = bmiCalculator.calculateBMI();

                    System.out.printf(
                            "BMI Number: %.2f%n",
                            bmiCalculator.getBmi()
                    );

                    System.out.println(
                            "BMI Status: " + bmiResult.getValue()
                    );
                    break;

                case 3:
                    System.out.println("Exit program.");
                    return;

                default:
                    break;
            }
        }
    }
}
