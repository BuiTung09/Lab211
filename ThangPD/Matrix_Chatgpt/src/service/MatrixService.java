package service;

import dto.MatrixRequestDTO;
import dto.MatrixResponseDTO;
import entity.Matrix;

/**
 *
 * @author win
 */
public class MatrixService {

    public MatrixResponseDTO add(MatrixRequestDTO request) throws Exception {

        Matrix matrix1 = request.getMatrix1();
        Matrix matrix2 = request.getMatrix2();



        int[][] resultData = new int[matrix1.getRows()][matrix1.getCols()];

        for (int i = 0; i < matrix1.getRows(); i++) {
            for (int j = 0; j < matrix1.getCols(); j++) {
                resultData[i][j] = matrix1.getData()[i][j]
                        + matrix2.getData()[i][j];
            }
        }

        Matrix result = new Matrix(
                matrix1.getRows(),
                matrix1.getCols(),
                resultData);

        return new MatrixResponseDTO(
                matrix1,
                matrix2,
                result,
                "+"
        );

    }

    public MatrixResponseDTO subtract(MatrixRequestDTO request) throws Exception {

        Matrix matrix1 = request.getMatrix1();
        Matrix matrix2 = request.getMatrix2();

        if (matrix1.getRows() != matrix2.getRows()
                || matrix1.getCols() != matrix2.getCols()) {
            throw new Exception("Rows and columns of two matrices must be the same.");
        }

        int[][] resultData = new int[matrix1.getRows()][matrix1.getCols()];

        for (int i = 0; i < matrix1.getRows(); i++) {
            for (int j = 0; j < matrix1.getCols(); j++) {
                resultData[i][j] = matrix1.getData()[i][j]
                        - matrix2.getData()[i][j];
            }
        }

        Matrix result = new Matrix(
                matrix1.getRows(),
                matrix1.getCols(),
                resultData);

        return new MatrixResponseDTO(
                matrix1,
                matrix2,
                result,
                "-"
        );

    }

    public MatrixResponseDTO multiply(MatrixRequestDTO request) throws Exception {

        Matrix matrix1 = request.getMatrix1();
        Matrix matrix2 = request.getMatrix2();

        if (matrix1.getCols() != matrix2.getRows()) {
            throw new Exception("Column of Matrix 1 must equal Row of Matrix 2.");
        }

        int[][] resultData = new int[matrix1.getRows()][matrix2.getCols()];

        for (int i = 0; i < matrix1.getRows(); i++) {

            for (int j = 0; j < matrix2.getCols(); j++) {

                for (int k = 0; k < matrix1.getCols(); k++) {

                    resultData[i][j] += matrix1.getData()[i][k]
                            * matrix2.getData()[k][j];
                }
            }
        }

        Matrix result = new Matrix(matrix1.getRows(), matrix2.getCols(),
                resultData);

        return new MatrixResponseDTO(
                matrix1,
                matrix2,
                result,
                "*"
        );

    }

}
