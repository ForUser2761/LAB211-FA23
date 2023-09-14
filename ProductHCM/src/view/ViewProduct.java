/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Manage;
import model.Product;

/**
 *
 * @author ADMIN
 */
class ViewProduct {
    Manage manage = new Manage();
    void createProduct() {
        //input information, check valid data
        int productId = Utility.getInteger("Enter ProductID: ",
                "Invalid ProductID. Please enter a valid number.", 1, Integer.MAX_VALUE);
        String productName = Utility.getString("Enter ProductName: ",
                "Invalid ProductName. Please enter a valid name.", "\\S{5,}");
        double unitPrice = Utility.getDouble("Enter UnitPrice: ",
                "Invalid UnitPrice. Please enter a valid number between 0 and 10000.", 0, 10000);
        int quantity = Utility.getInteger("Enter Quantity: ",
                "Invalid Quantity. Please enter a valid number between 0 and 1000.", 0, 1000);
        String status = Utility.getString("Enter Status (Available or Not Available): ",
                "Invalid Status. Please enter 'Available' or 'Not Available'.", "Available|Not Available");

        //tao doi tuong
        Product product = new Product(productId, status, unitPrice, quantity, status);
        
        //add collection
        manage.addProduct(product);
        
        //display message
        System.out.println("Add successfull");
    }

}
