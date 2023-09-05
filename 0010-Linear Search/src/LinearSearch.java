
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
class LinearSearch {

    static void generateRandomNumberInRange(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            //generate random number
            int randomNumber = random.nextInt(array.length);
            //assign value to array's element
            array[i] = randomNumber;
        }
    }

    static void displayArray(int[] array, String message) {
        System.out.print(message);
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        //display last element
        System.out.print(array[array.length - 1]);
        System.out.println("]");

    }

    static void displayIndexOfSearchNumber(int[] array, int searchValue) {
        //search
        int index = getIndexByLinearSearch(array, searchValue);
        //display
        if (index != -1) {
            System.out.println("Found " + searchValue + " at index: " + index);
        }else {
            System.out.println("Not found");
        }
    }

    private static int getIndexByLinearSearch(int[] array, int searchValue) {
        for (int i = 0; i < array.length; i++) {
            //check search value equal element
            if (searchValue == array[i]) {
                //found : return index
                return i;
            }
        }
        //not found
        return -1;
    }
    
}
