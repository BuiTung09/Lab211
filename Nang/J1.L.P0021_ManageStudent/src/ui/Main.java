/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Controller manager = new Controller();
        try {
            manager.generateStudent();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        while (true) {
            System.out.println("\tWELCOME TO STUDENT MANAGEMENT");
            System.out.println(" 1.Create");
            System.out.println(" 2.Find and Sort");
            System.out.println(" 3.Update/Delete");
            System.out.println(" 4.Report");
            System.out.println(" 5.Exit");
            int choice = Validator.getInt("Enter choice:", "Enter 1->5",
                    "Invalid!", 1, 5);
            switch (choice) {
                case 1:
                    try {
                        manager.addStudent();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    try {
                        manager.findAndSort();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    try {
                        manager.updateOrDelete();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    try {
                        manager.report();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    return;
            }
        }
    }

}
