package dto;

import entity.Matrix;

/**
 *
 * @author win
 */
public class MatrixResponseDTO {

    private Matrix matrix1;
    private Matrix matrix2;
    private Matrix result;
    private String operator;

    public MatrixResponseDTO() {
    }

    public MatrixResponseDTO(Matrix matrix1, Matrix matrix2,
            Matrix result, String operator) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.operator = operator;
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

    public Matrix getResult() {
        return result;
    }

    public void setResult(Matrix result) {
        this.result = result;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}