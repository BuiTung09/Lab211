package utils;

import java.util.Scanner;

/**
 *
 * @author win
 */
public class Validator {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Validator() {
    }

    public static int getInt(String message,
            String outOfRange,
            String invalidNumber,
            int min,
            int max) {

        while (true) {

            try {

                System.out.print(message);

                int number = Integer.parseInt(SCANNER.nextLine());

                if (number >= min && number <= max) {
                    return number;
                }

                System.out.println(outOfRange);

            } catch (NumberFormatException e) {

                System.out.println(invalidNumber);

            }

        }

    }

}