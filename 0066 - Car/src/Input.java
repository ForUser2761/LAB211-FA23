
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Input {

    public static String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String input = scanner.nextLine();
        return input;
    }

    public static boolean isContinue() {
        while (true) {
            String s = getString("Do you want find more?(Y/N): ");
            if (s.matches("[yYnN]")) {
                if (s.equalsIgnoreCase("y")) {
                    return true;
                }else {
                    return false;
                }
            }
        }
    }
}
