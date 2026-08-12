/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bill;

public class Item {

    private String name;
    private double price;
    private double discount;


    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }


    public double getDiscount() {
        return discount;
    }


    @Override
    public String toString() {
        return String.format(
                "%-15s Price: $%7.2f | Discount: $%6.2f",
                name,
                price,
                discount
        );
    }
}
