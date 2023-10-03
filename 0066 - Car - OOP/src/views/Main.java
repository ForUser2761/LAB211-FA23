/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import bo.ExceptionCar;
import bo.ManageCar;
import utils.Utility;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        ManageCar manage = new ManageCar();
        manage.addCar();
        System.out.println("Input information of car");
        while (true) {
            try {
                System.out.print("Name: ");
                String name = Utility.checkInputString();
                System.out.print("Color: ");
                String color = Utility.checkInputString();
                System.out.print("Price: ");
                int price = Utility.checkInputInt();
                System.out.print("Today: ");
                String today = Utility.checkInputString();
                if (!manage.checkNameCar(name, color, price, today)) {
                    return;
                }
            } catch (ExceptionCar e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
