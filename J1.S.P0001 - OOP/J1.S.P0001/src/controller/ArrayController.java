/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Random;
import view.BubbleSortView;

/**
 *
 * @author ADMIN
 */
public class ArrayController {

    // tạo contructer array, biến lớp, không nhập ra nhập vào
    // create random array
    //int number;
    private int[] array;

    public ArrayController() {
        BubbleSortView bubbleSortView = new BubbleSortView();
        int number = bubbleSortView.inputArraySize();
        array = new int[number];
        randomArray(array);
    }
    
    private void randomArray(int[] array) {
        Random random = new Random();
        // int array[] = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length);
        }
        
    }

    // sort random array
    private void sortArray() {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tempt = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tempt;
                }
            }
        }
    }

    public void displayBubbleSort() {
        BubbleSortView bubbleSortView = new BubbleSortView();
        // display unsorted array
        bubbleSortView.printArray("Unsorted array: ", array);
        //sort array
        sortArray();
        // display sorted array
        bubbleSortView.printArray("Sorted array: ", array);
    }
}
