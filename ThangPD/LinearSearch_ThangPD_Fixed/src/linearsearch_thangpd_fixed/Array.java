/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearsearch_thangpd_fixed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Array {

    private int[] array;

    public Array(int number) {
        
        array = new int[number];
    }

    public void generateRandomArray() {
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length);
        }
    }

    public void display() {
        System.out.println("The array: " + Arrays.toString(array));
    }

    public ArrayList<Integer> linearSearch(int key) {

        ArrayList<Integer> indexes = new ArrayList<>();

        String keyString = String.valueOf(key);

        for (int i = 0; i < array.length; i++) {

            if (String.valueOf(array[i]).equals(keyString)) {
                indexes.add(i);
            }

        }

        return indexes;
    }

    public static void run() {
        try {
            int number = Validator.getInt( "Enter number of array: ","Number must be >0",
                    "Invalid!",
                    1,
                    Integer.MAX_VALUE);

            Array array = new Array(number);
            array.generateRandomArray();
            array.display();

            int key = Validator.getInt( "Enter search value: ","Out of range!",
                    "Invalid!",
                    Integer.MIN_VALUE,
                    Integer.MAX_VALUE);

            ArrayList<Integer> result = array.linearSearch(key);

            if (result.isEmpty()) {
                System.out.println("Can not found");
            } else {
                System.out.println("Found at indexes: " + result);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
