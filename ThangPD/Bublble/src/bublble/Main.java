/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bublble;

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
      Validator validator = new Validator();
        Scanner sc = new Scanner(System.in);
 
        int size;
        while (true) {
            System.out.print("Enter number of array: ");
            String input = sc.nextLine();
            size = validator.getInt(input, "Out of range", "Invalid", 1, Integer.MAX_VALUE);
            if (size != -1) {
                break;
            }
        }
 
        BubbleSort bubbleSort = new BubbleSort(size);
        bubbleSort.generateRandomArray();
        System.out.print("Unsorted array: ");
        bubbleSort.display();
        bubbleSort.sort();
        System.out.print("Sorted array: ");
        bubbleSort.display();
    }
    
}
