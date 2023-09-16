package view;

import constant.Constant;
import java.util.Scanner;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Utility {

    // access modifier + (static) +return type + name method
    public static int getInteger(String message, String error, int min, int max) {
        Scanner scanner = new Scanner(System.in);

        //- Yêu cầu người dùng nhập vào một số nguyên
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                //check number in range
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.err.println("Bạn phải nhập trong khoảng " + min + "-" + max);
                }
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    public static double getDouble(String message, String error, double min, double max) {
        Scanner scanner = new Scanner(System.in);

        //- Yêu cầu người dùng nhập vào một số nguyên
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                double number = Double.parseDouble(input);
                //check number in range
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.err.println("Bạn phải nhập trong khoảng " + min + "-" + max);
                }
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    public static float getFloat(String message, String error, float min, float max) {
        Scanner scanner = new Scanner(System.in);

        //- Yêu cầu người dùng nhập vào một số nguyên
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.err.println("KhÔng được để trống");
                } else {
                    float number = Float.parseFloat(input);
                    //check number in range
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.err.println("Bạn phải nhập trong khoảng " + min + "-" + max);
                    }
                }
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    public static String getString(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            //nhap vao
            String input = scanner.nextLine().trim();
            //kiem tra xem input co matches regex hay ko
            //neu nhu matches voi regex => return string
            if (input.matches(regex)) {
                return input;
            } else {
                //tell error
                System.err.println(error);
            }
        }
    }

    public static String inputId() {
        String id = Utility.getString("Enter Vehicle ID: ",
                "Invalid ID format.", "[A-Za-z0-9]+");
        return id;
    }

    public static int inputProductYear() {
        int productYear = Utility.getInteger("Enter Vehicle Production Year: ",
                "Invalid year.", 0, 9999);
        return productYear;
    }

    public static String inputType() {
        String type = Utility.getString("Enter Vehicle Type: ",
                "Invalid type.", Constant.REGEX_ALL_CHARACTER);
        return type;
    }

    public static String inputBrand() {
        String brand = Utility.getString("Enter Vehicle Brand: ",
                "Invalid brand.", Constant.REGEX_ALL_CHARACTER);
        return brand;
    }

    public static String inputName() {
        String name = Utility.getString("Enter Vehicle Name: ",
                "Invalid name.", Constant.REGEX_ALL_CHARACTER);
        return name;
    }

    public static String inputColor() {
        String color = Utility.getString("Enter Vehicle Color: ",
                "Invalid color.", Constant.REGEX_ALL_CHARACTER);
        return color;
    }

    public static double inputPrice() {
        double price = Utility.getDouble("Enter Vehicle Price: ",
                "Invalid price.", 0.0, Double.MAX_VALUE);
        return price;
    }
}
