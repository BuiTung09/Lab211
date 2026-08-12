/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Base;
import entity.BaseNumber;
import input.BaseInput;
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
        BaseInput inputer = new BaseInput();
        BaseNumber number = null;
        try {
            number = inputer.input();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        do {
            try {
                int choice = Validator.getInt("1 for Binary, 2 for Decimal, 3 for Hexadecimal, 4 exit\n"
                        + "Enter choice: ", "Just 1->3", "Invalid!!!", 1, 4);
                switch (choice) {
                    case 1:
                        number.setBase(Base.BIN);
                        break;
                    case 2:
                        number.setBase(Base.DEC);
                        break;
                    case 3:
                        number.setBase(Base.HEX);
                        break;
                    case 4:
                        System.exit(0);

                }
                System.out.println("Number after convert: " + number.getNumber());

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

}
