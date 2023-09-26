
import java.util.ArrayList;
import java.util.List;
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
        List<Integer> listIndex = getIndexByLinearSearch(array, searchValue);
        //display
        if (listIndex != null) {
            System.out.print("Found " + searchValue + " at index: " );
            System.out.println(listIndex);
        }else {
            System.out.println("Not found");
        }
    }

    private static List<Integer> getIndexByLinearSearch(int[] array, int searchValue) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            //check search value equal element
            if (searchValue == array[i]) {
                //found : return index
                list.add(i);
            }
        }
        //neu nhu tim thay
        if (!list.isEmpty()) {
            return list;
        }else {
            //not found
            return  null;
        }
    }
    
}
