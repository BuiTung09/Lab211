package constants;

/**
 * Chứa nội dung các message, label sẽ hiển thị trong chương trình.
 * Tất cả message/label khai báo chung ở đây, không hardcode ở các class khác.
 */
public class Message {

    private Message() {
    }

    public static final String MENU =
            "==========Calculator program============\n"
            + "1. Addition Matrix\n"
            + "2. Subtraction Matrix\n"
            + "3. Multiplication Matrix\n"
            + "4. Quit\n"
            + "Enter your choice: ";

    public static final String ERROR_MENU_RANGE = "Just be 1 -> 4";
    public static final String ERROR_DIMENSION_RANGE = "Just be >0";
    public static final String ERROR_NOT_INTEGER = "Please enter integer number!";

    public static final String TITLE_ADDITION = "---------Addition---------";
    public static final String TITLE_SUBTRACTION = "---------Subtraction---------";
    public static final String TITLE_MULTIPLICATION = "---------Multiplication---------";
    public static final String TITLE_RESULT = "-------------Result-------------";

    public static final String OP_ADD = "+";
    public static final String OP_SUBTRACT = "-";
    public static final String OP_MULTIPLY = "*";
    public static final String OP_EQUAL = "=";

    public static String enterRow(int matrixNumber) {
        return "Enter Row Matrix " + matrixNumber + ": ";
    }

    public static String enterCol(int matrixNumber) {
        return "Enter Column Matrix " + matrixNumber + ": ";
    }

    public static String enterElement(int matrixNumber, int row, int col) {
        return String.format("Matrix%d[%d][%d]: ", matrixNumber, row, col);
    }
}
