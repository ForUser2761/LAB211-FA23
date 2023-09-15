/*
 * This class represents the user interface for inputting and managing product data.
 */
package main;

import controller.ManageProduct;
import java.util.Date;
import model.Product;
import utils.InputValid;

/**
 * The ViewProduct class handles the input of product information and displays
 * relevant messages.
 */
public class ViewProduct {

    ManageProduct manage = new ManageProduct();

    /**
     * This method allows the user to input product information.
     */
    public void inputProduct() {
        // Input information and validate data
        System.out.println("Add a Product:");
        String code;
        while (true) {
            code = InputValid.inputCode();
            if (manage.findByCode(code) != null) {
                System.err.println("Duplicate code !!");
            } else {
                break;
            }
        }
        String name = InputValid.inputName();
        double price = InputValid.inputPrice();
        int quantity = InputValid.inputQuantity();
        Date manufacturingDate = InputValid.inputManufacturingDate();
        Date expirationDate = InputValid.inputExpirationDate(manufacturingDate);
        int type = InputValid.inputType();

        // Create a new Product object with the collected information
        Product product = new Product(code, name, manufacturingDate, expirationDate, quantity, type);

        // Add the new product to your collection or data structure (e.g., a list)
        manage.addProduct(product);
        System.out.println("Product added successfully!");
    }
}
