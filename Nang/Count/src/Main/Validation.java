/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.util.Scanner;



public class Validation {

//    public boolean isValidString(String input) {
//        return input != null && !input.trim().isEmpty();
//    }
//    
    public String getString(String mess){
        System.out.println(mess);
        Scanner sc = new Scanner(System.in);
        do {            
            try {
                
                String input = sc.nextLine();
                if(input == null || input.trim().isEmpty()){
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.out.println("Invalid");
            }
        } while (true);
    }
}



