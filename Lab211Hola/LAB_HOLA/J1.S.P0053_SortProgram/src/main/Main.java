/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Array;
import utils.Validator;

/**
 *
 * @author win
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        Array array = null;
        do {
            System.out.println("========= Bubble Sort program =========\n"
                    + "1. Input Element\n"
                    + "2. Sort Ascending\n"
                    + "3. Sort Descending\n"
                    + "4. Exit");
            choice = Validator.getInt("Please choice one option:",
                    "Please enter number (1->4)", "Invalid!", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("----- Input Element -----\n"
                            + "Input Length Of Array");
                    int number = Validator.getInt("Enter Number: ",
                            "Please input numberand number is greater than zero",
                            "Please input numberand number is greater than zero",
                            0, Integer.MAX_VALUE);
                    array = new Array(number);
                    break;
                case 2:
                    System.out.println("----- Ascending -----");
                    try {
                        array.bubbleSort(true);
                        array.printArray(true);
                    } catch (NullPointerException e) {
                        System.out.println("Please input Element before SORT");
                    }
                    break;
                case 3:
                    System.out.println("----- Descending -----");
                    try {
                        array.bubbleSort(false);
                        array.printArray(false);
                    } catch (NullPointerException e) {
                        System.out.println("Please input Element before SORT");
                    }
                    break;
            }
        } while (choice != 4);
    }
}
