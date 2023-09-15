/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import utils.InputValid;

/**
 *
 * @author ADMIN
 */
public class Main {
    static ViewProduct manageProduct = new ViewProduct();
    
    public static void main(String[] args) {
        while (true) {
            System.err.println("==================================");
            System.out.println("Main Menu:");
            System.out.println("1. Manage products");
            System.out.println("2. Manage Warehouse");
            System.out.println("3. Report");
            System.out.println("4. Exit");

            int choice = InputValid.getInteger("Enter your choice: ", "Invalid choice. Please enter a number.", 1, 4);

            switch (choice) {
                case 1:
                    manageProductsMenu();
                    break;
                case 2:
                    manageWarehouseMenu();
                    break;
                case 3:
                    reportMenu();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    public static void manageProductsMenu() {
        while (true) {
            System.out.println("Manage Products Menu:");
            System.out.println("\t1.1. Add a product");
            System.out.println("\t1.2. Update product information");
            System.out.println("\t1.3. Delete product");
            System.out.println("\t1.4. Show all products");
            System.out.println("\t1.5. Back to Main Menu");

            int choice = InputValid.getInteger("Enter your choice: ", "Invalid choice. Please enter a number.", 1, 5);

            switch (choice) {
                case 1:
                    // Call the method to add a product
                    manageProduct.inputProduct();
                    break;
                case 2:
                    // Call the method to update product information
                    break;
                case 3:
                    // Call the method to delete a product
                    break;
                case 4:
                    // Call the method to show all products
                    break;
                case 5:
                    return; // Back to the previous menu
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    public static void manageWarehouseMenu() {
        while (true) {
            System.out.println("Manage Warehouse Menu:");
            System.out.println("\t2.1. Create an import receipt");
            System.out.println("\t2.2. Create an export receipt");
            System.out.println("\t2.3. Back to Main Menu");

            int choice = InputValid.getInteger("Enter your choice: ", "Invalid choice. Please enter a number.", 1, 3);

            switch (choice) {
                case 1:
                    // Call the method to create an import receipt
                    break;
                case 2:
                    // Call the method to create an export receipt
                    break;
                case 3:
                    return; // Back to the previous menu
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    public static void reportMenu() {
        while (true) {
            System.out.println("Report Menu:");
            System.out.println("\t3.1. Products that have expired");
            System.out.println("\t3.2. The products that the store is selling");
            System.out.println("\t3.3. Products that are running out of stock");
            System.out.println("\t3.4. Import/export receipt of a product");
            System.out.println("\t3.5. Back to Main Menu");

            int choice = InputValid.getInteger("Enter your choice: ", "Invalid choice. Please enter a number.", 1, 5);

            switch (choice) {
                case 1:
                    // Call the method to display products that have expired
                    break;
                case 2:
                    // Call the method to display products that the store is selling
                    break;
                case 3:
                    // Call the method to display products that are running out of stock
                    break;
                case 4:
                    // Call the method to display import/export receipt of a product
                    break;
                case 5:
                    return; // Back to the previous menu
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
