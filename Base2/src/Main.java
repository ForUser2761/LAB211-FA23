
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
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
        int sotuoi = getInteger("Hãy nhập vào số tuổi: ", "Tuổi phải là số nguyên",
                10, 30);
        System.out.println(sotuoi);
        
        int soluongSP = getInteger("Hãy nhập vào số lượng sản phẩm: ",
                "Số lượng sản phẩm phải là số nguyên", 1, 1000);
        System.out.println(soluongSP);
        
    }

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
}
