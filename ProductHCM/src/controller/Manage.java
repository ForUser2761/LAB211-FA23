/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class Manage {
    ArrayList<Product> productList;

    public Manage() {
        productList = new ArrayList<>();
                
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
    
    
}
