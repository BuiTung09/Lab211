/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.ListFruit;
import bo.Shopping;
import entity.Fruit;
import utils.Validator;

/**
 *
 * @author win
 */
public class Controller {

    private ListFruit fruits;
    private Shopping shopping;

    public Controller() {
        fruits = new ListFruit();
        shopping = new Shopping(fruits);
    }

    public void createFruit() throws Exception {
        if (fruits.toString() != null) {
            System.out.println(fruits.toString());
        }
        while (true) {
            String fruitId = Validator.getString("Enter ID Fruit: ",
                    "Please enter string with format (Fxx), x is digit","F\\d{2}");
            Fruit fruit = fruits.getFruitById(fruitId);
            //If same ID , update new quantities of fruit
            if (fruit != null) {
                System.out.println("ID is existed");
                System.out.println(fruit.toString());
                String choose = Validator.getString("You want to increase quantity of fruits (Y/N): ",
                        "Just Y or N", "[YNyn]");
                if (choose.equalsIgnoreCase("Y")) {
                    int newQuantity = Validator.getInt("Enter new Quantity:", "Please enter number >0", "Invalid!", 1, Integer.MAX_VALUE);
                    if (fruits.addFruit(new Fruit(fruitId, fruit.getFruitName(),
                            fruit.getPrice(), newQuantity, fruit.getOrigin()))) {
                        System.out.println("Update quantity success: " + fruit);
                        return;
                    } else {
                        System.out.println("Update fail!");
                    }
                }else{
                  return;  
                }
            }
            String fruitName = Validator.getString("Enter name Fruit:", "Just be alphabet!", "[A-Za-z\\s]+");
            String origin = Validator.getString("Enter origin:", "Just be alphabet!", "[A-Za-z\\s]+");
            double price = Validator.getDouble("Enter price:", "Please enter number >0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
            int quantity = Validator.getInt("Enter quantity:", "Please enter number >0", "Invalid!", 1, Integer.MAX_VALUE);
            Fruit newFruit = new Fruit(fruitId, fruitName, price, quantity, origin);
            if (fruits.addFruit(newFruit)) {
                System.out.println("Add success: " + newFruit);
            } else {
                System.out.println("Add fail!");
            }
            System.out.println("----------CONTINUE ADD-----------");
            String choose = Validator.getString("You want to continue (Y/N): ",
                    "Just Y or N", "[YNyn]");
            if (choose.equalsIgnoreCase("N")) {
                System.out.println(fruits.toString());
                break;
            }
        }
    }

    public void shopping() throws Exception {
        String name = Validator.getString("Enter customer name:", "Invalid!", "[A-Za-z\\s]+");
        while (true) {
            if (fruits.toString() != null) {
                System.out.println(fruits.toString());
            }
            if (fruits.numberInOfStock() == 0) {
                System.out.println("Out of stock!");
                break;
            }
            int item = Validator.getInt("Enter item(Enter 0 to exit!): ", "Error range!",
                    "Invalid!", 0, fruits.numberInOfStock());
            if (item == 0) {
                System.out.println("See you again!");
                return;
            }
            //Select fruit by item
            Fruit selectedFruit = fruits.getFruit(item);
            System.out.println("You selected: " + selectedFruit.getFruitName());
            int quantityOrder = Validator.getInt("Enter quantity: ", "Invalid quantity",
                    "Invalid!", 1, selectedFruit.getQuantity());
            shopping.shoppingProcess(name, selectedFruit, quantityOrder);
            System.out.println("----------CONTINUE ADD-----------");
            String choose = Validator.getString("You want to continue (Y/N): ", "Just Y or N", "[YNyn]");
            if (choose.equalsIgnoreCase("N")) {
                System.out.println("Thank you!");
                break;
            }
        }
    }

    public void viewOrders() {
        System.out.println(shopping.toString());
    }
    public void generateFruit() throws Exception {
        fruits.addFruit(new Fruit("F01", "Cam", 2000, 3, "Hanoi"));
        fruits.addFruit(new Fruit("F02", "Quyt", 4000, 6, "Hanoi"));
        fruits.addFruit(new Fruit("F03", "Dua", 5000, 5, "Can Tho"));
        fruits.addFruit(new Fruit("F04", "Thang Long", 5000, 5, "Can Tho"));
        fruits.addFruit(new Fruit("F05", "Na", 5000, 5, "Can Tho"));
        fruits.addFruit(new Fruit("F06", "Hong Xiem", 5000, 5, "Can Tho"));
    }
}
