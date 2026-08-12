package services;

import model.Matrix;
import repository.MatrixRepository;

/**
 * Chứa các tính toán nghiệp vụ (cộng, trừ, nhân ma trận).
 * Services chỉ được gọi từ Controller và được phép import Model.
 * Services không làm việc với input, output, View.
 * Luồng dữ liệu: Controller <-> Services <-> Repository <-> Model
 */
public class MatrixServices {

    private final MatrixRepository matrixRepository;

    public MatrixServices() {
        this.matrixRepository = new MatrixRepository();
    }

    public Matrix add(int[][] data1, int[][] data2) throws Exception {
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        Matrix result = matrix1.add(matrix2);
        matrixRepository.save(result);
        return result;
    }

    public Matrix subtract(int[][] data1, int[][] data2) throws Exception {
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        Matrix result = matrix1.subtract(matrix2);
        matrixRepository.save(result);
        return result;
    }

    public Matrix multiply(int[][] data1, int[][] data2) throws Exception {
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        Matrix result = matrix1.multiply(matrix2);
        matrixRepository.save(result);
        return result;
    }

    public Matrix buildMatrix(int[][] data) throws Exception {
        return new Matrix(data);
    }

    public MatrixRepository getRepository() {
        return matrixRepository;
    }
}
