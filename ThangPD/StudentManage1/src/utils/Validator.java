package utils;

import java.util.Scanner;

/**
 * Lớp hỗ trợ nhập và kiểm tra dữ liệu.
 */
public final class Validator {

    private Validator() {
    }

    /**
     * Nhập số nguyên trong khoảng min đến max.
     */
    public static int getInt(Scanner scanner, String message,
            int min, int max) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                int number = Integer.parseInt(input);

                if (number < min || number > max) {
                    System.out.println(
                            "Please enter a number from "
                            + min + " to " + max + "."
                    );
                    continue;
                }

                return number;
            } catch (NumberFormatException exception) {
                System.out.println("Invalid number.");
            }
        }
    }

    /**
     * Nhập chuỗi không được để trống.
     */
    public static String getNonEmptyString(
            Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty.");
        }
    }

    /**
     * Nhập mã sinh viên.
     *
     * Ví dụ hợp lệ: S001, s12.
     */
    public static String getStudentId(
            Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.matches("^S\\d+$")) {
                return input;
            }

            System.out.println(
                    "Student ID must start with S followed by numbers."
            );
        }
    }

    /**
     * Nhập tên sinh viên.
     *
     * \\p{L} cho phép nhập cả chữ cái tiếng Việt.
     */
    public static String getStudentName(
            Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = normalizeSpace(
                    scanner.nextLine().trim()
            );

            if (input.matches("^[\\p{L} ]+$")) {
                return input;
            }

            System.out.println(
                    "Student name must contain letters only."
            );
        }
    }

    /**
     * Nhập học kỳ.
     */
    public static String getSemester(
            Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = normalizeSpace(
                    scanner.nextLine().trim()
            );

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Semester cannot be empty.");
        }
    }

    /**
     * Nhập lựa chọn Y hoặc N.
     */
    public static boolean getYesNo(
            Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("Y")) {
                return true;
            }

            if (input.equalsIgnoreCase("N")) {
                return false;
            }

            System.out.println("Please enter Y or N.");
        }
    }

    /**
     * Nhập lựa chọn U hoặc D.
     */
    public static char getUpdateDeleteChoice(
            Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("U")) {
                return 'U';
            }

            if (input.equalsIgnoreCase("D")) {
                return 'D';
            }

            System.out.println("Please enter U or D.");
        }
    }

    /**
     * Xóa khoảng trắng thừa trong chuỗi.
     */
    private static String normalizeSpace(String input) {
        return input.replaceAll("\\s+", " ");
    }
}