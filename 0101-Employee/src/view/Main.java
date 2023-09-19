/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import entity.Employee;
import java.util.ArrayList;
import java.util.List;
import utils.Ultility;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        View_Employee view = new View_Employee();
        List<Employee> listEmployees = new ArrayList<>();

        listEmployees.add(new Employee("1", null, null, null, null,
                null, null, null, 1, 10));
        listEmployees.add(new Employee("2", null, null, null, null,
                null, null, null, 1, 10));
        listEmployees.add(new Employee("3", null, null, null, null,
                null, null, null, 1, 10));
        listEmployees.add(new Employee("4", null, null, null, null,
                null, null, null, 1, 10));
        listEmployees.add(new Employee("5", null, null, null, null,
                null, null, null, 1, 10));
        
        while (true) {
            displayMenu();
            int option = Ultility.getInteger("Option: ","Error", 1, 7);
            switch (option) {
                case 1:
                    //1. input employee
                    view.inputEmployee(listEmployees);
                    break;

                case 2:
                    //2. display information country just input
                    view.updateEmployee(listEmployees);
                    break;
                case 3:
                    //3. search country by name
                     view.removeEmployee(listEmployees);
                    break;
                case 4:
                    //4. sort country by name
                    // view.sortByName(listCountry);
                    break;
                case 5:
//                    view.searchEmployee(listEmployees);
                    break;
                case 6:
                    //5. exit
                    System.exit(0);
                    break;
                case 7:
                    for (Employee employee:
                         listEmployees) {
                        System.out.println(employee);
                    }
            }

        }
    }

    private static void displayMenu() {
        System.out.println("                               MENU\n"
                + "==========================================================================\n"
                + "1.	Add employees \n"
                + "2.	Update employees\n"
                + "3.	Remove employees\n"
                + "4.	Search employees\n"
                + "5.	Sort employees by salary\n"
                + "6.	Exit\n"
                + "==========================================================================");
    }
}
