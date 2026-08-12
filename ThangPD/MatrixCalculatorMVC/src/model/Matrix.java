package model;

/**
 * Model - chỉ chứa thuộc tính và các function mô tả đối tượng Matrix.
 * KHÔNG input từ scanner hoặc output (println) ở class này.
 */
public class Matrix {

    private int rows;
    private int cols;
    private int[][] data;

    public Matrix(int rows, int cols) throws Exception {
        if (rows > 0 && cols > 0) {
            this.rows = rows;
            this.cols = cols;
            this.data = new int[rows][cols];
        } else {
            throw new Exception("row and col must be >0");
        }
    }

    public Matrix(int[][] data) throws Exception {
        if (data == null || data.length == 0) {
            throw new Exception("Data array not null or empty");
        }
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = data;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int[][] getData() {
        return data;
    }

    public int getValue(int row, int col) {
        return data[row][col];
    }

    public void setValue(int row, int col, int value) {
        data[row][col] = value;
    }

    public Matrix add(Matrix other) throws Exception {
        if (other == null) {
            throw new Exception("Matrix can not null!");
        }
        if (rows != other.rows || cols != other.cols) {
            throw new Exception("Rows and cols two matrix must be same");
        }
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix subtract(Matrix other) throws Exception {
        if (other == null) {
            throw new Exception("Matrix can not null!");
        }
        if (rows != other.rows || cols != other.cols) {
            throw new Exception("Rows and cols two matrix must be same");
        }
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = data[i][j] - other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix multiply(Matrix other) throws Exception {
        if (other == null) {
            throw new Exception("Matrix can not null!");
        }
        if (cols != other.rows) {
            throw new Exception("Cols of matrix 1 must be equal rows of matrix 2");
        }
        int[][] result = new int[rows][other.cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < cols; k++) {
                    result[i][j] += data[i][k] * other.data[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(String.format("[%d]", data[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
