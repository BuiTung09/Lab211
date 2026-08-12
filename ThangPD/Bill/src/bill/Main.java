/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bill;

public class Main {

    public static void main(String[] args) {

        Employee clerk = new Employee("Nguyen Van An");

        Item candy = new Item("Candy", 1.35, 0.25);
        Item milk = new Item("Milk", 2.00, 0.00);
        Item bread = new Item("Bread", 3.00, 0.50);
        Item apple = new Item("Apple", 4.50, 1.00);


        DiscountBill preferredBill = new DiscountBill(clerk, true);

        preferredBill.add(candy);
        preferredBill.add(milk);
        preferredBill.add(bread);
        preferredBill.add(apple);

        System.out.println("BILL FOR PREFERRED CUSTOMER");
        preferredBill.printReceipt();

        System.out.println();

        DiscountBill normalBill = new DiscountBill(clerk, false);

        normalBill.add(candy);
        normalBill.add(milk);
        normalBill.add(bread);
        normalBill.add(apple);

        System.out.println("BILL FOR NORMAL CUSTOMER");
        normalBill.printReceipt();
    }
}