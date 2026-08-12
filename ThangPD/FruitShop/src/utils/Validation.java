package utils;

import java.util.Scanner;

public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static String getString() {
        while (true) {
            String input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) {
                System.out.println("Dữ liệu không được để trống. Vui lòng nhập lại: ");
                continue;
            }
            return input.trim();
        }
    }

    public static int getInt(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) {
                    System.out.println("nhập số nguyên trong khoảng từ: " + min + " - " + max);
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Nhập số nguyên");
            }
        }
    }

    public static int getIntMin(int min) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result <= min) {
                    System.out.println("Nhập số nguyên lớn hơn " + min);
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Nhập số nguyên lớn hơn " + min);
            }
        }
    }

    public static double getDoubleMin(double min) {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                if (result <= min) {
                    System.out.println("Nhap so thuc > " + min);
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Nhap so thuc > " + min);
            }
        }
    }

    public static boolean getOption(String trueOption, String falseOption) {
        while (true) {
            String result = sc.nextLine();
            if (result.equalsIgnoreCase(trueOption)) {
                return true;
            }
            if (result.equalsIgnoreCase(falseOption)) {
                return false;
            }
            System.out.println("Chon " + trueOption + " hoac " + falseOption);
        }
    }
}
