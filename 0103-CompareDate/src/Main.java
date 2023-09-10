
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        //1.	User enter the first date with[dd / mm / yyyy] format 
        String firstDate = inputDateWithFormat("Input first date:",
                "Input must be in format dd/MM/yyyy", "\\d{1,2}[/]\\d{1,2}[/]\\d{1,4}");
        //2.	User enter the second date with[dd / mm / yyyy] format 
        String secondDate = inputDateWithFormat("Input second date:",
                "Input must be in format dd/MM/yyyy", "\\d{1,2}[/]\\d{1,2}[/]\\d{1,4}");
        //3.	Compare 
        String compareResult = compareTwoDate(firstDate, secondDate);
        //4.    display
        System.out.println(compareResult);
    }

    private static String inputDateWithFormat(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input: ");
            //input 
            String input = scanner.nextLine();
            //check input in format dd/MM/yyyy
            if (input.matches(regex)) {
                //check input date exist ?
                if (isDateExist(input)) {
                    return input;
                } else {
                    System.out.println("Date not exist !!");
                }
            } else {
                System.out.println(error);
            }
        }
    }

    private static boolean isDateExist(String inputDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            dateFormat.parse(inputDate);
            //check parse success => date exist => return true
            return true;
        } catch (ParseException ex) {
            //parse failed => date not exist => return false
            return false;
        }
    }

    private static String compareTwoDate(String firstDate, String secondDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String result = null;
        try {
            //chuyen ve tu string -> date
            Date first = dateFormat.parse(firstDate);
            Date second = dateFormat.parse(secondDate);
            //so sanh
            if (first.before(second)) {
                result = "Date1 before Date2";
            } else if (first.after(second)) {
                result = "Date1 after Date2";
            } else {
                result = "Date1 equal Date2";
            }

            //tra ve ket qua
        } catch (Exception e) {
        }
        return result;
    }

}
