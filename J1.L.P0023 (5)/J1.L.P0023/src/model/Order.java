/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kidzd
 */
public class Order {

    private String nameCustomer;
    private List<Fruit> listFruitOrder = new ArrayList<>();

    /**
     * create order
     *
     * @param nameCustomer
     * @param listFruit
     */
    public Order(String nameCustomer, List<Fruit> listFruit) {
        this.nameCustomer = nameCustomer;
        this.listFruitOrder = listFruit;
    }

    public Order() {
    }

    /**
     *
     * @return nameCustomer
     */
    public String getNameCustomer() {
        return nameCustomer;
    }

    /**
     * the nameCustomer to set
     *
     * @param nameCustomer
     */
    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    /**
     *
     * @return listFruitOrder
     */
    public List<Fruit> getListFruit() {
        return listFruitOrder;
    }

    /**
     * the listFruitOrder to set
     *
     * @param listFruit
     */
    public void setListFruit(List<Fruit> listFruit) {
        this.listFruitOrder = listFruit;
    }
    
    public void addFruitToOrder(Fruit fruitOrder) {
        Fruit fruitInList = getFruitByID(fruitOrder.getId());
        if (fruitInList == null) {
           listFruitOrder.add(fruitOrder);
        } else {
            fruitInList.setQuantity(fruitInList.getQuantity() + fruitOrder.getQuantity());
        }
    }
    //total bill
    public double getTotal() {
        double total = 0;
        double temp;
        for (int i = 0; i < listFruitOrder.size(); i++) {
            temp = listFruitOrder.get(i).getPrice() * listFruitOrder.get(i).getQuantity();
            total += temp;
        }
        return total;
    }

    private Fruit getFruitByID(String id) {
        for (Fruit fruit : listFruitOrder) {
            if (fruit.getId().equalsIgnoreCase(id)) {
                return fruit;
            }
        }
        return null;
    }

}
