/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author acmon
 */
public class QuickSort {

    private int[] array = null;

    /**
     * Construct a random array.
     *
     * @param number length of array
     */
    public QuickSort(int number) {
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
     * Quick Sort.
     */
    private void quickSort(int left, int right) {

        if (left >= right) {
            return;
        }

        int pivot = array[(left + right) / 2];
        int i = left;
        int j = right;

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        quickSort(left, j);
        quickSort(i, right);

    }

    /**
     * Call quick sort.
     */
    public void sort() {
        quickSort(0, array.length - 1);
    }

}
