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
                    1, 4);
            switch (option) {
                case 1:
                    view.inputTask();
                    break;
                case 2:
                    view.deleteTask();
                    break;
                case 3:
                    view.displayTask();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }

    }

    private static void displayMenu() {
        System.out.println("========= Task program =========\n"
                + "1.	Add Task\n"
                + "2.	Delete task\n"
                + "3.	Display Task\n"
                + "4.	exit");
    }
}
