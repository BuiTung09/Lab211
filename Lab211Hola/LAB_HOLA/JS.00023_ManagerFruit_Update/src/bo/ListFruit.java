/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Fruit;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author thuha
 */
public class ListFruit {

    List<Fruit> fruits = new ArrayList<>();

    public List<Fruit> getFruits() {
        return fruits;
    }

    public Fruit getFruitById(String id) {
        for (Fruit fruit : fruits) {
            if (id.equals(fruit.getFruitId())) {
                return fruit;
            }
        }
        return null;
    }

    public boolean addFruit(Fruit newFruit) throws Exception {
        //Neu qua chua ton tai trong danh sach thi them moi, con ton tai roi thi cap nhat so luong
        Fruit fruit = getFruitById(newFruit.getFruitId());
        if (fruit == null) {
            return fruits.add(newFruit);
        } else {
            fruit.setQuantity(fruit.getQuantity() + newFruit.getQuantity());
            return true;
        }
    }

    @Override
    public String toString() {
        int countItem = 0;
        if (fruits.isEmpty()) {
           return null;
        }
        String result = ""
                + "+-----+--------------------+-------------+---------------+----------\n"
                + "|No.  |Fruit Name          |Origin       |Price          |Quantity  |\n"
                + "+-----+--------------------+-------------+---------------+----------\n";
        for (Fruit fruit : fruits) {
            if (fruit.getQuantity() != 0) {
                countItem++;
                result += String.format("|%5d|  %-18s|   %-10s|%15s|%10d|\n", countItem,
                        fruit.getFruitName(), fruit.getOrigin(),
                        ("$" + String.format("%.1f", fruit.getPrice())), fruit.getQuantity());
            }
        }
        result+="+-----+--------------------+-------------+---------------+----------";
        return result;
    }

    public int numberInOfStock() {
        int count = 0;
        for (int i = 0; i < fruits.size(); i++) {
            if (fruits.get(i).getQuantity() != 0) {
                count++;
            }
        }
        return count;
    }

    public Fruit getFruit(int item) {
        int count = 0;
        for (int i = 0; i < fruits.size(); i++) {
            if (fruits.get(i).getQuantity() != 0) {
                count++;
            }
            if (count == item) {
                return fruits.get(i);
            }
        }
        return null;
    }
}
