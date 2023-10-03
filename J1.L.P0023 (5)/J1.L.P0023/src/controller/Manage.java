/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.Order;

/**
 *
 * @author kidzd
 */
public class Manage {

    //create list fruit
    List<Fruit> listFruit = new ArrayList<>();
    //create list order
    List<Order> listOrder = new ArrayList<>();

    //get list Fruit
    public List<Fruit> getListFruit() {
        return listFruit;
    }

    //get list Orders
    public List<Order> getListOrders() {
        return listOrder;
    }

    // check duplicate id
    public boolean checkDuplicate(String id) {
        for (Fruit fruit : listFruit) {
            if (fruit.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    // add fruit
    public void addFruit(Fruit fruit) {
        listFruit.add(fruit);
    }

    //get fruit by id
    public Fruit getFruitByID(String id) {
        for (Fruit fruit : listFruit) {
            if (fruit.getId().equalsIgnoreCase(id)) {
                return fruit;
            }
        }
        return null;
    }

    //remove fruit
    public void removeFruit(Fruit fruitChoice, List<Fruit> listFruitTemp) {
        listFruitTemp.remove(fruitChoice);
    }

    //add order

    public void addOrder(Order order) {
        listOrder.add(order);
    }

    public void addAllFruit(List<Fruit> listFruitTemp, List<Fruit> listFruit) {
        for (Fruit fruit : listFruit) {
            if (fruit.getQuantity() != 0) {
                listFruitTemp.add(fruit);
            }
        }
    }

}
