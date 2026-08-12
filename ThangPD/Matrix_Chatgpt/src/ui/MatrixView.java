package ui;

import dto.MatrixRequestDTO;
import dto.MatrixResponseDTO;
import entity.Matrix;
import utils.Validator;

/**
 *
 * @author win
 */
public class MatrixView {

    public MatrixRequestDTO inputMatrix(int choice) throws Exception {
        while (true) {
            System.out.println("--------- Input Matrix ---------");
            int rows1 = Validator.getInt("Enter Row Matrix 1: ", "Row must be > 0",
                    "Please enter integer!", 1, Integer.MAX_VALUE);
            int cols1 = Validator.getInt("Enter Column Matrix 1: ", "Column must be > 0",
                    "Please enter integer!", 1, Integer.MAX_VALUE);
            int rows2 = Validator.getInt("Enter Row Matrix 2: ", "Row must be > 0", 
                    "Please enter integer!", 1, Integer.MAX_VALUE);
            int cols2 = Validator.getInt("Enter Column Matrix 2: ", "Column must be > 0",
                    "Please enter integer!", 1, Integer.MAX_VALUE);

            if ((choice == 1 || choice == 2) && (rows1 != rows2 || cols1 != cols2)) {
                System.out.println("Two matrices must have the same size.");
                continue;
            }
            if (choice == 3 && cols1 != rows2) {
                System.out.println("Column Matrix1 must equal Row Matrix2.");
                continue;
            }

            Matrix matrix1 = inputData(1, rows1, cols1);
            Matrix matrix2 = inputData(2, rows2, cols2);
            return new MatrixRequestDTO(matrix1, matrix2);
        }
    }

    private Matrix inputData(int number, int rows, int cols) throws Exception {

        int[][] data = new int[rows][cols];

        System.out.println("Input Matrix " + number);

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                data[i][j] = Validator.getInt(
                        String.format("Matrix%d[%d][%d]: ",
                                number,
                                i + 1,
                                j + 1),
                        "Invalid!",
                        "Please enter integer!",
                        Integer.MIN_VALUE,
                        Integer.MAX_VALUE);
            }
        }
        return new Matrix(rows, cols, data);

    }

    public void display(MatrixResponseDTO response) {

        System.out.println("------------ Result ------------");

        System.out.print(response.getMatrix1());

        System.out.println(response.getOperator());

        System.out.print(response.getMatrix2());

        System.out.println("=");

        System.out.println(response.getResult());

    }

}
