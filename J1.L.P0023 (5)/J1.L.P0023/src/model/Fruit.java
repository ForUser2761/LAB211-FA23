/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kidzd
 */
public class Fruit {

    private String id;
    private String name;
    private double price;
    private int quantity;
    private String origin;

    /**
     * create fruit with properties
     *
     * @param id
     * @param name
     * @param price
     * @param quantity
     * @param origin
     */
    public Fruit(String id, String name, double price, int quantity, String origin) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    /**
     *
     * @return Amount = price * quantity
     */
    public double getAmount() {
        return price * quantity;
    }

    public Fruit() {
        super();
    }

    /**
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * the ID to set
     *
     * @param id
     */
    public void setId(String id) {
        if (id != null) {
            this.id = id;
        }
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * the nam to set
     *
     * @param name
     */
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    /**
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * the price to set
     *
     * @param price
     */
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    /**
     *
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * the quantity to set
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * the origin to set
     *
     * @param origin
     */
    public void setOrigin(String origin) {
        if (origin != null) {
            this.origin = origin;
        }
    }

    @Override
    public String toString() {
        return String.format("%-15s|%-15s|%-15s|%-15s|%-15s", id, name, origin, quantity, price);
    }
}
