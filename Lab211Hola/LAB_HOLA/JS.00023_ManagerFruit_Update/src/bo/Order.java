/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

/**
 *
 * @author win
 */
import entity.Fruit;

import java.util.ArrayList;

public class Order {

    private String customerName;
    private ArrayList<Fruit> orderList;

    public Order(String customerName) {
        this.customerName = customerName;
        this.orderList = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Fruit> getOrderList() {
        return orderList;
    }

    public void addFruitToOrder(Fruit fruitNewOrder) throws Exception {
        //Kiem tra xem danh sach da mua co chua qua minh muon mua hay khong,
        //Neu co roi thi tang so luong , chua co thi them vao order list
        Fruit fruitInOrder = checkFruitInOrder(fruitNewOrder.getFruitId());
        if (fruitInOrder != null) {
            fruitInOrder.setQuantity(fruitInOrder.getQuantity() + fruitNewOrder.getQuantity());
        } else {
            orderList.add(fruitNewOrder);
        }
    }

    public Fruit checkFruitInOrder(String id) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getFruitId().equalsIgnoreCase(id)) {
                return orderList.get(i);
            }
        }
        return null;
    }

    public double calculateTotal() {
        double total = 0;
        for (Fruit fruit : orderList) {
            total += fruit.getPrice() * fruit.getQuantity();
        }
        return total;
    }

    @Override
    public String toString() {
        String result = "Customer: " + getCustomerName();
        result += "\n"
                + "+-----+--------------------+----------+-----------+------------+\n"
                + "+No.  |     Product        |  Quantity| Price     |  Amount    |\n"
                + "+-----+--------------------+----------+-----------+------------+\n";
        for (int i = 0; i < orderList.size(); i++) {
            result += String.format("|%5d|    %-16s|  %8d| %10s|  %10s|\n", (i + 1), orderList.get(i).getFruitName(),
                    orderList.get(i).getQuantity(), "$" + String.format("%.1f", orderList.get(i).getPrice()),
                    "$" + String.format("%.1f", orderList.get(i).getPrice() * orderList.get(i).getQuantity()));
        }
        double total = calculateTotal();
        result += "+-----+--------------------+----------+-----------+------------+\n";
        result += String.format("|\t\t\t\t\tTotal     |%12s|\n", "$" + String.format("%.1f", total));
        result += "+-----+--------------------+----------+-----------+------------+\n";
        return result;
    }
}
