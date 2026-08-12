/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quicksort;

import java.util.Scanner;

/**
 *
 * @author acmon
 */
public class Validator {
    public int getInt(
            String input,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min,
            int max) {

        
            try {
               int number = Integer.parseInt(input);
                if (number >= min && number <= max) {
                    return number;
                }

                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException exception) {
                System.out.println(messageErrorInvalidNumber);
            }
        return -1;
    }
}
