
import java.util.Locale;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author SICOMP
 */
public class Main {

    public static void main(String[] args) {

        Ebank ebank = new Ebank();
        Utility util = new Utility();

        while (true) {
            //display menu
            displayMenu();

            int option = util.getInt("Enter option: ",
                    "Wrong", 1, 3);
            Locale locale;
            switch (option) {
                case 1:
                    locale = new Locale("vi");
                    ebank.setLocate(locale);
                    break;
                case 2:
                    locale = new Locale("en");
                    ebank.setLocate(locale);
                    break;
                case 3:
                    System.exit(0);
                    break;

            }
        }

    }

    private static void displayMenu() {
        System.out.println("1. vietnam");
        System.out.println("2. english");
        System.out.println("3. exit");
    }
}
