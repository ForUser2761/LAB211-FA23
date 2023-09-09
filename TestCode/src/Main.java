
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
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Hay nhap vao ngay thang: ");
        String input = scanner.nextLine();
        if (input.matches("[0-9]+[/][0-9]+[/][0-9]+")) {
            //neeu nhu khop <=> nguoi dung nhap dung
            System.out.println("Ban da nhap sai");
        }else {
            //neu nhu ko khop <=> nguoi dung nhap sai
            System.out.println("Ban da nhap sai roi");
        }
        
        
    }
}
