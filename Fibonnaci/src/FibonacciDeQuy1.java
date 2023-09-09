/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class FibonacciDeQuy1 {

    public static int Fibonacci(int n, int lower, int higher, int position) {
        System.out.print(higher + " ");
        System.out.println(" index: " + position);
        if (n < 2) {
            return higher;
        }

        return Fibonacci(n - 1, higher, higher + lower, position + 1);
    }

    public static void main(String args[]) {

        Fibonacci(45, 1, 0, 0);
    }
}
