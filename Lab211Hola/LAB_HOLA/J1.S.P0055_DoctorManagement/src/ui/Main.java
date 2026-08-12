/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.DoctorController;
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
        DoctorController doctorController = new DoctorController();
        doctorController.loadFile();
        int choice;
        do {
            System.out.println("========= Doctor Management Program =========");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Save file and Exit");
            choice = Validator.getInt("Please choose one option: ", "Out of range, choose again!", "Invalid input, please enter a number!", 1, 5);
            switch (choice) {
                case 1:
                    doctorController.addDoctor();
                    break;
                case 2:
                    doctorController.updateDoctor();
                    break;
                case 3:
                    doctorController.deleteDoctor();
                    break;
                case 4:
                    doctorController.searchDoctor();
                    break;
                case 5:
                    doctorController.saveFile();
                    System.out.println("Exiting program...");
                    break;
            }
        } while (choice != 5);
    }

}
