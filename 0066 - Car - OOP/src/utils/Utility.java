/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import bo.ExceptionCar;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Utility {
    static Scanner in = new Scanner(System.in);

    public static String checkInputString() throws ExceptionCar {
        while (true) {
            String result = in.nextLine();
            if (result.length() == 0) {
                throw new ExceptionCar("Not empty");
            } else {
                return result;
            }
        }
    }

    public static int checkInputInt() throws ExceptionCar {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result <= 0) {
                    throw new ExceptionCar("Price greater than zero");
                }
                return result;
            } catch (NumberFormatException ex) {
                throw new ExceptionCar("Price is digit");
            }

        }
    }

    public static boolean checkYN() throws ExceptionCar {
        while (true) {
            String result = checkInputString();
            if (result.length() == 1) {
                char resultChar = result.charAt(0);
                if (resultChar == 'y' || resultChar == 'Y') {
                    return true;
                }
                if (resultChar == 'n' || resultChar == 'N') {
                    return false;
                }
            }
            System.err.println("Re-input");
        }
    }
}
