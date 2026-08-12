/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bill;

import java.util.ArrayList;
import java.util.List;

public class GroceryBill {

    private Employee clerk;
    private List<Item> items;


    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        this.items = new ArrayList<>();
    }


    public void add(Item item) {
        if (item != null) {
            items.add(item);
        }
    }


    public double getTotal() {
        double total = 0.0;

        for (Item item : items) {
            total += item.getPrice();
        }

        return total;
    }


    public void printReceipt() {
        System.out.println("=============== GROCERY BILL ===============");
        System.out.println("Clerk: " + clerk.getName());
        System.out.println("--------------------------------------------");

        if (items.isEmpty()) {
            System.out.println("The bill has no items.");
        } else {
            for (int i = 0; i < items.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, items.get(i));
            }
        }

        System.out.println("--------------------------------------------");
        System.out.printf("Original total: $%.2f%n", getTotal());
        System.out.println("============================================");
    }
}