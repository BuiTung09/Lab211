/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import bo.ManagerCandidate;
import entity.Candidate;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
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
        ManagerCandidate manager = new ManagerCandidate();
        do {
            int choice = Validator.getInt("CANDIDATE MANAGEMENT SYSTEM\n"
                    + "1. Experience\n"
                    + "2. Fresher\n"
                    + "3. Internship\n"
                    + "4. Searching\n"
                    + "5. Exit\n"
                    + "Enter your choice: ", "Must 1->5", "Invalid!", 1, 5);
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("=============CREATE EXPERIENCE=============");
                        Candidate candidate = manager.add(0);
                        if (candidate != null) {
                            System.out.println("Add success: " + (Experience) candidate);
                        } else {
                            System.out.println("Add fail!");
                        }
                        String choose = Validator.getString("Do you want to continue(Y/N)? ",
                                "Just be y or N", "[ynYN]");
                        if (choose.equalsIgnoreCase("N")) {
                            manager.displayAllNameCandidate(1);
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("=============CREATE FRESHER=============");
                        Candidate candidate = manager.add(1);
                        if (candidate != null) {
                            System.out.println("Add success: " + (Fresher) candidate);
                        } else {
                            System.out.println("Add fail!");
                        }
                        String choose = Validator.getString("Do you want to continue(Y/N)? ",
                                "Just be y or N", "[ynYN]");
                        if (choose.equalsIgnoreCase("N")) {
                            manager.displayAllNameCandidate(2);
                            break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.println("=============CREATE INTERN=============");
                        Candidate candidate = manager.add(2);
                        if (candidate != null) {
                            System.out.println("Add success: " + (Intern) candidate);
                        } else {
                            System.out.println("Add fail!");
                        }
                        String choose = Validator.getString("Do you want to continue(Y/N)? ",
                                "Just be y or N", "[ynYN]");
                        if (choose.equalsIgnoreCase("N")) {
                            manager.displayAllNameCandidate(3);
                            break;
                        }
                    }
                    break;
                case 4:
                    String key = Validator.getString("Input key: ", "Can not empty!", "^(?!\\s*$).+");
                    manager.displaySearchResult(manager.search(key));
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

}
