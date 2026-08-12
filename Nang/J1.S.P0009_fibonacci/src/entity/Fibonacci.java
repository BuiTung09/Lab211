/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author win
 */
public class Fibonacci {
    
    private static long[] memo;

    // constructor với mảng có kích thước từ 0 đến number
    public Fibonacci(int number) {
        memo = new long[number + 1];
        // gán -1 cho các phần tử chưa tính để đánh dấu là "chưa tính"
        for (int i = 0; i <= number; i++) {
            memo[i] = -1; 
        }
    }
    
    public static long fibo(int n){
        if(n <= 1) return n;
        if(memo[n] != -1) return memo[n];
        memo[n] = fibo(n-1) + fibo(n-2);
        return memo[n];
    }
    
}



//    public static int generateFibonacci(int number) {
//        switch (number) {
//            case 0:
//                return 0;
//            case 1:
//                return 1;
//            default:
//                return generateFibonacci(number-1)+generateFibonacci(number-2);
//        }
//    }


//import java.math.BigInteger;
//
//public class Fibonacci {
//
//    private static BigInteger[] memo;
//
//    // constructor
//    public Fibonacci(int number) {
//        memo = new BigInteger[number + 1];
//        // mặc định các phần tử là null → chưa tính
//    }
//
//    public static BigInteger fibo(int n) {
//        if (n <= 1) {
//            return BigInteger.valueOf(n);
//        }
//
//        if (memo[n] != null) {
//            return memo[n];
//        }
//
//        memo[n] = fibo(n - 1).add(fibo(n - 2));
//        return memo[n];
//    }
//}
