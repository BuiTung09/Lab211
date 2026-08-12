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
public class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();
        Scanner sc = new Scanner(System.in);
        int size;
        while (true) {            
            System.out.print("Enter number of array: ");
            String input = sc.nextLine();
            size = validator.getInt(input, "Out of range", "Invalid", 1, Integer.MAX_VALUE);
            if(size != -1){
                break;
            }
        }

        QuickSort quickSort = new QuickSort(size);

        System.out.print("Unsorted array: ");
        quickSort.generateRandomArray();
        quickSort.display();

        quickSort.sort();

        System.out.print("Sorted array: ");
        quickSort.display();

    }
}
