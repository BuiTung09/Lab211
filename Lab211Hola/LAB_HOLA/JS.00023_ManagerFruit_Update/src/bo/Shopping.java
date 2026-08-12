/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Fruit;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author win
 */
public class Shopping {

    ListFruit listFruit;
    Map<String, Order> orders;

    public Shopping(ListFruit listFruit) {
        this.listFruit = listFruit;
        orders = new Hashtable<>();
    }

    public ListFruit getListFruit() {
        return listFruit;
    }

    public Map<String, Order> getOrders() {
        return orders;
    }

    //Phuong thuc mua hang va tra ve danh sach order sau khi mua xong
    public void shoppingProcess(String customerName, Fruit selectedFruit, int quantityOrder) throws Exception {
        Order order;
        if (orders.containsKey(customerName)) {
            order = orders.get(customerName);
        } else {
            order = new Order(customerName);
        }
        selectedFruit.setQuantity(selectedFruit.getQuantity() - quantityOrder);
        Fruit orderFruit = new Fruit(selectedFruit.getFruitId(), selectedFruit.getFruitName(), selectedFruit.getPrice(),
                quantityOrder, selectedFruit.getOrigin());
        order.addFruitToOrder(orderFruit);
        orders.put(customerName, order);
    }

    public String toString() {
        if (orders.isEmpty()) {
            return "No orders";
        }
        String result = "";
        for (Order order : orders.values()) {
            result += order.toString();
        }
        return result;
    }

}
