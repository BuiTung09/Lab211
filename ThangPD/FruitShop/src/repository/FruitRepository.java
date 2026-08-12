package repository;

import model.Fruit;
import java.util.ArrayList;
import java.util.Hashtable;
import model.Order;

public class FruitRepository {

    private ArrayList<Fruit> listFruit = new ArrayList<>();
    private Hashtable<String, ArrayList<Order>> listOrder = new Hashtable<>();

    public FruitRepository() {

        listFruit.add(new Fruit("F1", "Coconut", 2.0, 30, "Vietnam"));
        listFruit.add(new Fruit("F2", "Orange", 3.0, 30, "US"));
        listFruit.add(new Fruit("F3", "Apple", 4.0, 30, "Thailand"));
        listFruit.add(new Fruit("F4", "Grape", 6.0, 30, "France"));
        listFruit.add(new Fruit("F5", "Mango", 5.0, 0, "Philipines"));
    }

    public ArrayList<Fruit> getListFruit() {
        return listFruit;
    }

    public Hashtable<String, ArrayList<Order>> getListOrder() {
        return listOrder;
    }

    // Các hàm Create/Update 
    public void addFruit(Fruit fruit) {
        listFruit.add(fruit);
    }

    public void putOrder(String customerName, ArrayList<Order> listBills) {
        listOrder.put(customerName, listBills);
    }
}
