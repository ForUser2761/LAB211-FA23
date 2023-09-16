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
        ViewVehicle view = new ViewVehicle();
        while (true) {
            displayMenu();
            int choice = Utility.getInteger("Enter your choice: ",
                    "Invalid choice. Please try again.", 1, 9);
            switch (choice) {
                case 1:
                    view.input();
                    break;
                case 2:
                    view.checkExistVehicle();
                    break;
                case 3:
                    view.updateVehicle();
                    break;
                case 4:
                    //Delete Vehicle
                    view.delete();
                    break;
                case 5:
                    searchMenu(view);
                    break;
                case 6:
                    displayVehicleMenu(view);
                    break;
                case 7:
                    view.saveDataToFile();
                    break;
                case 8:
                    printVehicleListMenu(view);
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("==========================================================================");
        System.out.println("Vehicle Management System");
        System.out.println("1. Add Vehicle");
        System.out.println("2. Check Existence of Vehicle");
        System.out.println("3. Update Vehicle");
        System.out.println("4. Delete Vehicle");
        System.out.println("5. Search Vehicle");
        System.out.println("6. Display All Vehicles");
        System.out.println("7. Save Data to File");
        System.out.println("8. Print Vehicle List");
        System.out.println("9. Quit");

    }

    private static void searchMenu(ViewVehicle view) {
        while (true) {
            System.out.println("=============================== Search Vehicle ===============================");
            System.out.println("1. Search vehicle by Name");
            System.out.println("2. Search vehicle by id");
            System.out.println("3. Back to previous menu");

            int choice = Utility.getInteger("Enter your choice: ",
                    "Choice must be number", 1, 3);
            switch (choice) {
                case 1:
                    //search vehicle by name
                    view.searchByName();
                    break;
                case 2:
                    //search vehicle by id
                    view.searchById();
                    break;
                case 3:
                    //back to menu
                    return;
                default:
                    System.err.println("Invalid choice. Please choose a valid option.");
            }

        }

    }

    private static void displayVehicleMenu(ViewVehicle view) {
        while (true) {
            System.out.println("=============================== Show Vehicle ===============================");
            System.out.println("1. Show all vehicles");
            System.out.println("2. Show all by price");
            System.out.println("3. Back to previous menu");

            int choice = Utility.getInteger("Enter your choice: ",
                    "Choice must be number", 1, 3);
            switch (choice) {
                case 1:
                    //Show all vehicles
                    view.showAllVehicles();
                    break;
                case 2:
                    //Show all by price
                    view.showAllByPrice();

                    break;
                case 3:
                    //back to menu
                    return;
                default:
                    System.err.println("Invalid choice. Please choose a valid option.");
            }

        }
    }

    private static void printVehicleListMenu(ViewVehicle view) {
        while (true) {
            System.out.println("=============================== Print Vehicle List ===============================");
            System.out.println("1. Print all vehicles");
            System.out.println("2. Print all by Year");
            System.out.println("3. Back to previous menu");

            int choice = Utility.getInteger("Enter your choice: ",
                    "Choice must be number", 1, 3);
            switch (choice) {
                case 1:
                    //Show all vehicles
                    view.showAllVehicles();
                    break;
                case 2:
                    //Show all by price
                    view.printAllVehiclesByYear();
                    break;
                case 3:
                    //back to menu
                    return;
                default:
                    System.err.println("Invalid choice. Please choose a valid option.");
            }

        }
    }

}
