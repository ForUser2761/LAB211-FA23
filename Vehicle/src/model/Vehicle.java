/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Vehicle {

    private String id;
    private String name;
    private String color;
    private double price;
    private String brand;
    private String type;
    private int productYear;

    public Vehicle(String id, String name, String color, double price, String brand, String type, int productYear) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
        this.type = type;
        this.productYear = productYear;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getProductYear() {
        return productYear;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Color: " + color + ", Price: $" + price + ", Brand: " + brand
                + ", Type: " + type + ", Year: " + productYear;
    }

}
