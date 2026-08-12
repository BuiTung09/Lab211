/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.Controller;
import entity.Worker;
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
        Controller control = new Controller();
        control.readFile();
        do {
            int choice = Validator.getInt("======== Worker Management =========\n"
                    + "1.	Add Worker\n"
                    + "2.	Up salary\n"
                    + "3.	Down salary\n"
                    + "4.	Display Information salary\n"
                    + "5.	Exit\nEnter your choice: ", "Just be 1-> 5", "Invalid!", 1, 5);
            switch (choice) {
                case 1:
                    try {
                        System.out.println("--------- Add Worker ----------");
                        Worker worker = control.addWorker();
                        System.out.println("Add success: " + worker);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    control.saveWorkersToFile();
                    break;
                case 2:
                    try {
                        System.out.println("------- Up/Down Salary --------");
                        Worker workerUp = control.upSalary();
                        System.out.println("Up salary success:");
                        System.out.println(workerUp);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    control.saveWorkersToFile();
                    control.saveHistoryToFile();
                    break;
                case 3:
                    try {
                        System.out.println("------- Up/Down Salary --------");
                        Worker workerDown = control.downSalary();
                        System.out.println("Down salary success:");
                        System.out.println(workerDown);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    control.saveWorkersToFile();
                    control.saveHistoryToFile();
                    break;
                case 4:
                    control.showHistorySalary();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

}
