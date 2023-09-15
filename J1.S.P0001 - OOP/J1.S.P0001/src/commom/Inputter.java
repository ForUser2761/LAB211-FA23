/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commom;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Inputter {
    public int getInt(String message, String error, int min, int max){
        Scanner scanner = new Scanner(System.in);
        while (true){
            // try catch lỗi parseInt
            try {
                // scan number
                System.out.println(message);
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                //check range
                if (number > max || number < min){
                    System.out.println(error);
                }else{
                    return number;
                }
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }
}
