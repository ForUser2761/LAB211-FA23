/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import commom.Inputter;
import java.util.Arrays;

/**
 *
 * @author ADMIN
 */
public class BubbleSortView {
    public int inputArraySize(){
        Inputter number = new Inputter();
        int input = number.getInt("Enter number of array:\n", "Error", 0, Integer.MAX_VALUE);
        return input;
    }
    
    public void printArray(String message, int[] array){
        System.out.println(message + Arrays.toString(array));
    }
}
