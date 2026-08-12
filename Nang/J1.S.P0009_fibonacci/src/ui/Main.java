/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Fibonacci;

/**
 *
 * @author win
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int number = 45;

        System.out.println("The " + number + " sequence fibonacci: ");
        for (int i = 0; i < number; i++) {
            System.out.print(Fibonacci.fibo(i));
            if (i < number - 1) {
                System.out.print(", ");
            } else {
                System.out.println(".");
            }
        }
    }

    /**
     * package fibo;
     *
     * import java.util.Scanner;
     *
     * public class MainProgram {
     *
     * public static void main(String[] args) { Scanner sc = new
     * Scanner(System.in);
     *
     * System.out.print("Nhap n: "); int n = sc.nextInt();
     *
     * Fibonacci fb = new Fibonacci(n);
     *
     * System.out.println("Day Fibonacci:"); for (int i = 0; i < n; i++) {
     * System.out.print(fb.fibonacci(i) + " "); } } }
     *
     */
}
