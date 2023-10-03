/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vview;

public class Main {

    public static void main(String[] args) {
        View_Student view = new View_Student();
        while (true) {
            displayMenu();

            int option = Utility.getInt("Enter option: ", "Error", 1, 5);
            switch (option) {
                case 1:
                    //create student
                    view.createStudent();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.exit(0);
                    break;

            }
        }
    }

    private static void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT\n"
                + "1.	Create\n"
                + "2.	Find and Sort\n"
                + "3.	Update/Delete\n"
                + "4.	Report\n"
                + "5.	Exit");
    }
}
