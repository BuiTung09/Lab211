/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectionsort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author acmon
 */
public class SelectionSort {
    private int[] array = null;

    /**
     * Construct a random array.
     *
     * @param number length of array
     */
    public SelectionSort(int number) {      
        array = new int[number];      
    }
    
    public void generateRandomArray() {
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length);
        }
    }

    /**
     * Display array.
     */
    public void display() {
        System.out.println(Arrays.toString(array));
    }

    /**
     * Selection Sort.
     */
    public void sort() {

        for (int i = 0; i < array.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }

            }

            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }

        }

    }
}
