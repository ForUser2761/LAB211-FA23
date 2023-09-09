/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class FibonacciDeQuy2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //find the fibonacci sequence needed using recursion
        int array[] = findFibo(46);
        //print out the fibo sequence
        displayArray(array);
    }

    //function to write value of fibo sequence in to the array
    public static void writeFiboArray(int[] array, int count) {
        //if count ==0,count ==1   
        while (count <= 1) {
            array[count] = count;
            count++;
        }
        if (count > 1) {
            array[count] = array[count - 1] + array[count - 2];
            count++;
            if (count < array.length) {
                writeFiboArray(array, count);
            }
        }
    }

    public static int[] findFibo(int sizeArray) {
        int[] array = new int[sizeArray];
        writeFiboArray(array, 0);
        return array;
    }

    public static void displayArray(int[] i) {
        System.out.println("The 45 sequence fibonacci:");
        for (int j = 0; j < i.length; j++) {
            System.out.println("Index " + j + ": " + i[j]);
           
        }
    }


}
