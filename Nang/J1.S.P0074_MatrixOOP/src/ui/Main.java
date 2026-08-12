/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import utils.MatrixInputer;
import entity.Matrix;
import utils.Validator;

/**
 *
 * @author win
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        while (true) {
            int choice = Validator.getInt("==========Calculator program============\n"
                    + "1. Addition Matrix\n"
                    + "2. Subtraction Matrix\n"
                    + "3. Multiplication Matrix\n"
                    + "4. Quit\n"
                    + "Enter your choice: ", "Just be 1 -> 4", "Please enter integer number", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("---------Addition---------");
                    try {
                        Matrix matrix1 = MatrixInputer.input(1);
                        Matrix matrix2 = MatrixInputer.input(2);
                        Matrix result = matrix1.add(matrix2);
                        System.out.println("-------------Result-------------");
                        System.out.print(matrix1.toString());
                        System.out.println("+");
                        System.out.print(matrix2.toString());
                        System.out.println("=");
                        System.out.println(result.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("---------Subtraction---------");
                    try {
                        Matrix matrix1 = MatrixInputer.input(1);
                        Matrix matrix2 = MatrixInputer.input(2);
                        Matrix result = matrix1.subtract(matrix2);
                        System.out.println("-------------Result-------------");
                        System.out.print(matrix1.toString());
                        System.out.println("-");
                        System.out.print(matrix2.toString());
                        System.out.println("=");
                        System.out.println(result.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("---------Multiplication---------");
                    try {
                        Matrix matrix1 = MatrixInputer.input(1);
                        Matrix matrix2 = MatrixInputer.input(2);
                        Matrix result = matrix1.multiply(matrix2);
                        System.out.println("-------------Result-------------");
                        System.out.print(matrix1.toString());
                        System.out.println("*");
                        System.out.print(matrix2.toString());
                        System.out.println("=");
                        System.out.println(result.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

}
