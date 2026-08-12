/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author win
 */
public class Array {

    private int[] array;

    public Array(int number) throws Exception {
        if (number <= 0) {
            throw new Exception("Number of array must be >0");
        }
        array = new int[number];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(number);
        }
    }

    public Array(int[] array) throws Exception {
        if (array == null) {
            throw new Exception("Array can not null!");
        }
        this.array = array;
    }

    public void display() {
        System.out.println("The array: "+Arrays.toString(array));
    }

    public int linearSearch(int key) {
        for (int i = 0; i < array.length; i++) {
            if(array[i]==key){
                return i;
            }
        }
        return -1;
    }
}
