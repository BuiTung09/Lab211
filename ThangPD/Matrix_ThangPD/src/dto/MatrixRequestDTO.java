package dto;

/**
 * Đối tượng chứa data giao tiếp giữa Main và Controller.
 * Có thể truyền nguyên vẹn DTO này vào Services và Repository.
 */
public class MatrixRequestDTO {

    private int choice;
    private int[][] matrix1Data;
    private int[][] matrix2Data;

    public MatrixRequestDTO() {
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public int[][] getMatrix1Data() {
        return matrix1Data;
    }

    public void setMatrix1Data(int[][] matrix1Data) {
        this.matrix1Data = matrix1Data;
    }

    public int[][] getMatrix2Data() {
        return matrix2Data;
    }

    public void setMatrix2Data(int[][] matrix2Data) {
        this.matrix2Data = matrix2Data;
    }
}
