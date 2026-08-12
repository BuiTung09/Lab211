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
        // TODO code application logic here
        int number = Validator.getInt("Enter number of array: ",
                "Number must be >0", "Invalid!", 1, Integer.MAX_VALUE);
        Array array = null;
        try {
            array = new Array(number);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        int key = Validator.getInt("Enter search value: ",
                "Error range!", "Invalid!", Integer.MIN_VALUE, Integer.MAX_VALUE);
        array.display();
        int index = array.linearSearch(key);
        if (index == -1) {
            System.out.println("Can not found");
        } else {
            System.out.println("Found " + key + " at index: " + index);
        }
    }

}
