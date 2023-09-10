
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
public class Main {

    public static void main(String[] args) {
        //1.	User enter date with[dd / mm / yyyy] format 
        String inputDate = inputDateWithFormat();
        //2.	Check user input date exits
        boolean isDateExist = isDateExist(inputDate);
        //3.	Determine day of week with input date
        if (isDateExist) {
           determineDayOfWeek(inputDate);
        } else {
            System.out.println("Date not exist");
        }

    }

    private static String inputDateWithFormat() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input: ");
            //input 
            String input = scanner.nextLine();
            //check input in format dd/MM/yyyy
            //if in format => return input
            // \\d{1,2}: the hien cho ngay hoac la thang
            // [/] : ki tu /
            // \\d{4} : the hien cho nam
            if (input.matches("\\d{1,2}[/]\\d{1,2}[/]\\d{4}")) {
                return input;
            } else {
                //else => tell error
                System.out.println("Please input in correct format dd/MM/yyyy");
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

    private static void determineDayOfWeek(String inputDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        try {
            //chuyen tu string -> date ( .......................)
            date = dateFormat.parse(inputDate);
            
            //chuyen tu date -> string ( format EEEE)
            dateFormat = new SimpleDateFormat("EEEE");
            System.out.println(dateFormat.format(date));
        } catch (Exception e) {
            
        }
        
    }
}
