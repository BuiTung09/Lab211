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
public class Matrix {

    private int rows;
    private int cols;
    private int[][] data;

    public Matrix(int rows, int cols) throws Exception {
        if (rows > 0 && cols > 0) {
            this.rows = rows;
            this.cols = cols;
            data = new int[rows][cols];
        } else {
            throw new Exception("row and col must be >0");
        }
    }

    public Matrix(int[][] data) throws Exception {
        if (data == null) {
            throw new Exception("Data array not null or empty");
        }
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = data;
    }

    public Matrix add(Matrix other) throws Exception {
        if (rows != other.rows || cols != other.cols) {
            throw new Exception("Rows and cols two matrix must be same");
        }
        int dataResult[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dataResult[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        Matrix result = new Matrix(dataResult);
        return result;
    }

    public Matrix subtract(Matrix other) throws Exception {
        if (rows != other.rows || cols != other.cols) {
            throw new Exception("Rows and cols two matrix must be same");
        }
        int dataResult[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dataResult[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        Matrix result = new Matrix(dataResult);
        return result;
    }

    public Matrix multiply(Matrix other) throws Exception {
        if (cols != other.rows) {
            throw new Exception("Cols of matrix 1 must be equal rows of matrix 2");
        }
        int dataResult[][] = new int[rows][other.cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < cols; k++) {
                    dataResult[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        Matrix result = new Matrix(dataResult);
        return result;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                str += String.format("[%d]", data[i][j]);
            }
            str += "\n";
        }
        return str;
    }
}
