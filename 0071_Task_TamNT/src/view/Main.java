/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Task;
import utils.Utility;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        ViewTask view = new ViewTask();
        while (true) {
            displayMenu();
            int option = Utility.getInteger("Option: ",
                    "Option must be digits",
                    1, 5);
            switch (option) {
                case 1:
                    view.createAssignee();
                    break;
                case 2:
                    view.createTask();
                    break;
                case 3:
                    view.deleteTask();
                    break;
                case 4:
                    view.displayAssignee();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }

    }

    private static void displayMenu() {
        System.out.println("========= Task program =========\n"
                + "1.	Create assignee\n"
                + "2.	Create task\n"
                + "3.	Delete task\n"
                + "4.	Display assignee\n"
                + "5.	Exit");
    }
}
