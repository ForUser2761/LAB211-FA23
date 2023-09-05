
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
        //enter size of array
        int sizeOfArray = getInteger("Enter size of array: ",
                "Size of array must be integer number", 1, Integer.MAX_VALUE);
        int searchValue = getInteger("Enter search number: ",
                "Search value must be integer number", 
                Integer.MIN_VALUE,
                Integer.MAX_VALUE);
        //Declaring array
        int[] array = new int[sizeOfArray];
        //Generate random integer in number range for each array element
        LinearSearch.generateRandomNumberInRange(array);
        //Display array before 
        LinearSearch.displayArray(array, "The array: ");
        //Display the index of search number in array
        LinearSearch.displayIndexOfSearchNumber(array, searchValue);
    }
    
    public static int getInteger(String message, String error, int min, int max) {
        Scanner scanner = new Scanner(System.in);

        //- Yêu cầu người dùng nhập vào một số nguyên
        while (true) {
            try {
                System.out.println(message);
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
