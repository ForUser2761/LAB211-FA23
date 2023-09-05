
import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    /**
     *
     * @param array
     */
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

    static void sortArray(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < (array.length - i); j++) {
                if (array[j - 1] > array[j]) {
                    //swap elements  
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

}
