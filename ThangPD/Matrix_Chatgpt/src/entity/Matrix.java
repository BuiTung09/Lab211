package entity;

/**
 *
 * @author win
 */
public class Matrix {

    private int rows;
    private int cols;
    private int[][] data;

    public Matrix() {
    }

    public Matrix(int rows, int cols, int[][] data) throws Exception {
        if (rows <= 0 || cols <= 0) {
            throw new Exception("Rows and columns must be greater than 0.");
        }
        if (data == null) {
            throw new Exception("Matrix data cannot be null.");
        }
        if (data.length != rows) {
            throw new Exception("Number of rows is invalid.");
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i].length != cols) {
                throw new Exception("Number of columns is invalid.");
            }
        }

        this.rows = rows;
        this.cols = cols;
        this.data = data;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
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
