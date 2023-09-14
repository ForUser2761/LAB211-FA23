/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        ViewProduct view = new ViewProduct();
        while (true) {
            System.out.println("==========================================================================");
            System.out.println("Product Management Program");
            System.out.println("1. Create a Product");
            System.out.println("2. Check Existence of Product");
            System.out.println("3. Search Product Information by Name");
            System.out.println("4. Update Product");
            System.out.println("5. Save Products to File");
            System.out.println("6. Print List of Products from File");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");

            int choice = Utility.getInteger("", "Invalid input. Please enter a valid choice.", 1, 7);

            switch (choice) {
                case 1:
                    view.createProduct();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }
}
