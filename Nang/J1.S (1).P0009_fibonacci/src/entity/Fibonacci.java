
package entity;

/**
 *
 * @author Asus
 */
public class Fibonacci {
    public static void displayFibonacci(int n){ 
        displayFibonacci(n, 0, 1);
    }
    
    private static void displayFibonacci(int n, int f1, int f2){
        if(n > 0){
            System.out.print(f1);
            if(n > 1){
                System.out.print(", ");
            }else{
                System.out.println(".");
            }
            displayFibonacci(n - 1, f2, f1 + f2);
        }
    }
}