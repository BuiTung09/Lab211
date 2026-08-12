package main;

import controller.FruitController;
import utils.Validation;

public class FruitMain {


    private static FruitController controller = new FruitController();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n========== FRUIT SHOP SYSTEM ==========");
            System.out.println("1. Create Fruit");
            System.out.println("2. Update Fruit");
            System.out.println("3. View Order");
            System.out.println("4. Shopping (for buyer)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = Validation.getInt(1, 5);

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
                    System.out.println("Exit");
                    return;
            }
        }
    }
}
