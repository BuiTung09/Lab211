
package view;

import utils.Validation;


public class Input {


    public static String inputString(String msg) {
        System.out.println(msg);
        return Validation.getString();
    }

    public static int inputInt(String msg, int min, int max) {
        System.out.println(msg);
        return Validation.getInt(min, max);
    }

    public static int inputIntMin(String msg, int min) {
        System.out.println(msg);
        return Validation.getIntMin(min);
    }

    public static double inputDoubleMin(String msg, double min) {
        System.out.println(msg);
        return Validation.getDoubleMin(min);
    }

    public static boolean twoOption(String msg, String trueOp, String falseOp) {
        System.out.println(msg);
        return Validation.getOption(trueOp, falseOp);
    }
}
