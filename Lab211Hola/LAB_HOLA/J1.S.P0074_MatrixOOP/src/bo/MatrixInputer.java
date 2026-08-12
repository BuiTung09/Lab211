/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Matrix;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Validator;

/**
 *
 * @author win
 */
public class MatrixInputer {

    private Matrix matrix;

    public MatrixInputer() {
    }

    public Matrix input(String messInfor, int row, int col) {
        int data[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                data[i][j] = Validator.getInt(messInfor + String.format("[%d][%d]: ", i + 1, j + 1),
                        "Error range!", "Value of matrix is digit", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        try {
            matrix = new Matrix(data);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return matrix;
    }
}
