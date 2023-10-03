/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author kidzd
 */
public class GetInput {

    static Scanner scanner = new Scanner(System.in);

    //global
    public static final String REGEX_STRING = "[a-zA-Z0-9 ]+";
    public static final String REGEX_NAME = "[a-zA-Z ]+";
    public static final String REGEX_SEMESTER = "[0-9]";
    public static final String REGEX_COURSE_NAME = "[a-zA-Z.+/ ]+";
    public static String REGEX_YES_NO = "[yYnN]";
    public static final String REGEX_UPDATE_DELETE = "[uUdD]";

    public static int getInt(String message, String error, int min, int max) {
        String REGEX_NUMBER = "[0-9]+";
        while (true) {
            System.out.print(message);
            String result = scanner.nextLine();
            if (result.isEmpty()) {
                System.out.println("Input cannot be empty");
                //neu result khop voi cai regex => cho qua
                //neu khong khop (false )
            } else if (result.matches(REGEX_NUMBER) == false) {
                System.out.println(error);

            } else {

                try {
                    int number = Integer.parseInt(result);
                    if (number >= min && number <= max) {
                        return number;

                    } else {
                        System.out.println("Number must in range from " + min + " to " + max);
                    }

                } catch (NumberFormatException e) {
                    System.out.println(error);

                }
            }
        }
    }

    public static double getDouble(String message, String error, double min, double max) {
        String REGEX_NUMBER = "[0-9.]+";
        while (true) {
            System.out.print(message);
            String result = scanner.nextLine();
            if (result.isEmpty()) {
                System.out.println("Input cannot be empty");
                //neu result khop voi cai regex => cho qua
                //neu khong khop (false )
            } else if (result.matches(REGEX_NUMBER) == false) {
                System.out.println(error);
            } else {
                try {
                    double number = Double.parseDouble(result);
                    if (number >= min && number < max) {
                        return number;
                    } else {
                        System.out.println("Number must in range from " + min + " to " + max);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(error);
                }
            }
        }
    }

    public static String getString(String message, String error, String regex) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!!");
            } else {
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            }
        }
    }
}
