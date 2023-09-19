
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Main3 {

    public static void main(String[] args) {
        String date = "19/9/2001";
        System.out.println(checkOldEnough(date));
    }

    public static boolean checkOldEnough(String input) {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date currentDate = new Date();
            Date inputDate = dateFormat.parse(input);
            long result = (currentDate.getTime() - inputDate.getTime()) / (60 * 60 * 24 * 365l * 1000);
            if (result >= 16) {
                return true;
            } else {
                return false;
            }

        } catch (ParseException ex) {
            return false;
        }
    }
}
