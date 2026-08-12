/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import utils.Validator;

/**
 *
 * @author Tuandz
 */
public class Array {

    private int array[] = null;

    /**
     * This construct a array.
     *
     * @param number -length of array
     */
    public Array(int number) {
        array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = Validator.getInt("Enter Number " + (i + 1) + ": ",
                    "Error range!", "Invalid!",
                    Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    /**
     * This method is used to display Arrays on the screen.
     *
     * @param increase if true array will print -> other wise <-
     */
    public void printArray(boolean increase) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");
            if (i < array.length - 1 && increase) {
                System.out.print("->");
            } else if (i < array.length - 1 && !increase) {
                System.out.print("<-");
            }
        }
        System.out.println("");
    }

    /**
     * This method is used to sort array by bubble sort
     *
     * @param increase if true array will sort increase other wise decrease
     */
    public void bubbleSort(boolean increase) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (increase) {
                    if (array[j] > array[j + 1]) {
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                } else {
                    if (array[j] < array[j + 1]) {
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }
}
