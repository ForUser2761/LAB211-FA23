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
                    break;
                case 3:
                    //Delete Vehicle
                    view.delete();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
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

}
