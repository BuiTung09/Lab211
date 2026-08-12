package utils;

/**
 * Chứa các function dùng chung như validate dữ liệu.
 * Toàn bộ method ở đây là static, KHÔNG dùng Scanner
 * (Scanner chỉ được sử dụng ở Main).
 */
public class Validation {

    private Validation() {
    }

    public static boolean isInteger(String input) {
        if (input == null) {
            return false;
        }
        try {
            Integer.parseInt(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }
}
