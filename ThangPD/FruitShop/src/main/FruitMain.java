package main;

import controller.FruitController;
import java.util.Scanner;
import view.Input;

public class FruitMain {

    // KHI KHAI BÁO SCANNER DUY NHẤT Ở ĐÂY
    private static Scanner sc = new Scanner(System.in);
    private static FruitController controller = new FruitController();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n========== FRUIT SHOP SYSTEM ==========");
            System.out.println("1. Create Fruit");
            System.out.println("2. Update Fruit");
            System.out.println("3. View Order");
            System.out.println("4. Shopping (for buyer)");
            System.out.println("5. Exit");

            int choice = Input.inputInt("Please choose an option: ", 1, 5);

            switch (choice) {
                case 1:
                    controller.createFruit();
                    break;
                case 2:
                    controller.updateFruit();
                    break;
                case 3:
                    controller.viewOrders();
                    break;
                case 4:
                    controller.shopping();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
