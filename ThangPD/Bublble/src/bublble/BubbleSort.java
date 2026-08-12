package bublble;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author acmon
 */
public class BubbleSort {

    private int[] array = null;


    public BubbleSort(int number) {
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
     * Bubble Sort.
     */
    public void sort() {
    for (int i = 0; i < array.length - 1; i++) {
        for (int j = 0; j < array.length - 1 - i; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
}
}
