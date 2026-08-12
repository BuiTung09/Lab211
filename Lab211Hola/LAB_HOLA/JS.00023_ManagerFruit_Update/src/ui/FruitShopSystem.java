/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author win
 */
import controller.Controller;
import utils.Validator;

public class FruitShopSystem {

    public static void main(String[] args) {
        Controller control = new Controller();
        try {
            control.generateFruit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        while (true) {
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");

            int choice = Validator.getInt("Enter your choice: ", "Invalid input!", "Out of range!", 1, 4);

            switch (choice) {
                case 1:
                    try {
                        control.createFruit();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 2:
                    try {
                        control.viewOrders();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    // Mua sắm cho người mua
                    try {
                        control.shopping();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
