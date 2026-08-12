package dto;

import entity.Matrix;

/**
 *
 * @author win
 */
public class MatrixRequestDTO {
    private Matrix matrix1;
    private Matrix matrix2;

    public MatrixRequestDTO() {
    }

    public MatrixRequestDTO(Matrix matrix1, Matrix matrix2) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
    }

    public Matrix getMatrix1() {
        return matrix1;
    }

    public void setMatrix1(Matrix matrix1) {
        this.matrix1 = matrix1;
    }

    public Matrix getMatrix2() {
        return matrix2;
    }

    public void setMatrix2(Matrix matrix2) {
        this.matrix2 = matrix2;
    }

}