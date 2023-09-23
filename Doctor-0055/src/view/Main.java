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
        ViewDoctor view = new ViewDoctor();
        // loop until user want to exit
        while (true) {
            // display menu
            displayMenu();
            // choice option
            int choice = GetInput.getInteger("Choice: ", "The choice must be a decimal number", 1, 6);
            switch (choice) {
                case 1:
                    // add doctor
                    view.addDoctor();
                    break;
                case 2:
                    // update doctor by id
                    view.updateDoctor();
                    break;
                case 3:
                    // delete doctor id
                    view.deleteDoctor();
                    break;
                case 4:
                    // search doctor by text
                    view.searchDoctor();
                    break;
                case 5:
                    // exit
                    System.exit(0);
                case 6:
                    view.showData();
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("========= Doctor Management ==========");
        System.out.println("    1.Add Doctor");
        System.out.println("    2.Update Doctor");
        System.out.println("    3.Delete Doctor");
        System.out.println("    4.Search Doctor");
        System.out.println("    5.Exit");
    }
}
