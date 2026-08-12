/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reverse.word;

import java.util.Scanner;

/**
 *
 * @author acmon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Reverse reverse = new Reverse();

        String input;

        do {
            System.out.print("Enter a string: ");
            input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!");
            }

        } while (input.isEmpty());

        String output = reverse.printReverse(input);

        System.out.println("Reverse: " + output);
    }

}
