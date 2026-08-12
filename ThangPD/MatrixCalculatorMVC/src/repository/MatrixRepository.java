package repository;

import model.Matrix;
import java.util.ArrayList;
import java.util.List;

/**
 * Chứa data, ở đây là lịch sử các kết quả tính toán ma trận.
 * Các method CRUD đơn giản đối với data chính nằm ở đây.
 * Repository không làm việc với input, output, View.
 */
public class MatrixRepository {

    private final List<Matrix> history = new ArrayList<>();

    public void save(Matrix matrix) {
        history.add(matrix);
    }

    public List<Matrix> getAll() {
        return history;
    }

    public Matrix getLast() {
        if (history.isEmpty()) {
            return null;
        }
        return history.get(history.size() - 1);
    }

    public void clear() {
        history.clear();
    }
}
