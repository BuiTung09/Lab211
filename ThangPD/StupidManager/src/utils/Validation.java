package utils;

public class Validation {

    public static String getString(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Not allowed empty!");
        }
        return input.trim();
    }

    public static String getStringAllowEmpty(String input) {
        if (input == null) {
            return "";
        }
        return input.trim();
    }

    public static int getInt(String input, int min, int max) throws IllegalArgumentException {
        try {
            int result = Integer.parseInt(input.trim());
            if (result < min || result > max) {
                throw new IllegalArgumentException("Please input number in range [" + min + ", " + max + "]");
            }
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid format. Please input a valid integer number.");
        }
    }

    public static boolean getOption(String input, String trueOption, String falseOption) throws IllegalArgumentException {
        String result = input.trim();
        if (result.equalsIgnoreCase(trueOption)) {
            return true;
        }
        if (result.equalsIgnoreCase(falseOption)) {
            return false;
        }
        throw new IllegalArgumentException("Invalid option. Please choose " + trueOption + " or " + falseOption);
    }
}
