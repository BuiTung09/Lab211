/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Matrix;

/**
 *
 * @author win
 */
public class MatrixInputer {

    public static Matrix input(int numberOfMatrix) throws Exception {
        int rows = Validator.getInt("Enter Row Matrix "+numberOfMatrix+": ", "Just be >0 ",
                "Please enter integer number!", 1, Integer.MAX_VALUE);
        int cols = Validator.getInt("Enter Column Matrix "+numberOfMatrix+": ", "Just be >0 ",
                "Please enter integer number!", 1, Integer.MAX_VALUE);
        int data[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = Validator.getInt(String.format("Matrix%d[%d][%d]: ",
                        numberOfMatrix, i + 1, j + 1),
                        "Error range!", "Value of matrix is digit", 
                        Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return new Matrix(data);
    }
}
