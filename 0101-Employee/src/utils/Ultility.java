package utils;

import constant.Constant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Ultility {

    // access modifier + (static) +return type + name method
    public static int getInteger(String message, String error, int min, int max) {
        Scanner scanner = new Scanner(System.in);

        //- Yêu cầu người dùng nhập vào một số nguyên
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.err.println("KhÔng được để trống");
                } else {
                    int number = Integer.parseInt(input);
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

    public static double getDouble(String message, String error, double min, double max) {
        Scanner scanner = new Scanner(System.in);

        //- Yêu cầu người dùng nhập vào một số nguyên
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.err.println("KhÔng được để trống");
                } else {
                    double number = Double.parseDouble(input);
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

    public static String getString(String message, String regex, String error ) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            //nhap vao
            String input = scanner.nextLine();
            //kiem tra xem input co rong hay khong
            if (input.isEmpty()) {
                System.err.println("Input cannot be empty !!");
            } else {
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
    }

    public static Date inputDateWithFormat(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            //input 
            String input = scanner.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.FORMAT_DATE);
            //check input in format dd/MM/yyyy
            if (input.matches(regex)) {
                //check input date exist ?
                if (isDateExist(input)) {
                    //check date before current date
                    try {
                        if (checkOldEnough(input)) {
                            return dateFormat.parse(input);
                        }else {
                            System.out.println("You must enough " + Constant.OLD_ENOUGH);
                        }
                    }catch (Exception ex) {

                    }


                } else {
                    System.err.println("Date not exist !!");
                }
            } else {
                System.err.println(error);
            }
        }
    }

    public static boolean checkOldEnough(String input) {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.FORMAT_DATE);
            Date currentDate = new Date();
            Date inputDate = dateFormat.parse(input);
            long result = (currentDate.getTime() - inputDate.getTime()) / (60 * 60 * 24 * 365l * 1000);
            if(result >= Constant.OLD_ENOUGH) {
                return  true;
            }else {
                return false;
            }

        } catch (ParseException ex) {
            return false;
        }
    }

    private static boolean isDateExist(String inputDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.FORMAT_DATE);
            dateFormat.setLenient(false);
            dateFormat.parse(inputDate);
            //check parse success => date exist => return true
            return true;
        } catch (ParseException ex) {
            //parse failed => date not exist => return false
            return false;
        }
    }
}
