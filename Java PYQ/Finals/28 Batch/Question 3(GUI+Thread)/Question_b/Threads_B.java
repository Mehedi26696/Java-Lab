//(b) To make the computation faster, the thread-based program can be a help. Write a Java program to find Cusing two threads.

import java.util.Scanner;

class FactorialThread extends Thread {
    private int number;
    private long result;

    public FactorialThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        result = factorial(number);
    }

    public long getResult() {
        return result;
    }

    private long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}

public class Threads_B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get input from user

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        // Create threads for factorial calculations
        FactorialThread factN = new FactorialThread(n);
        FactorialThread factK = new FactorialThread(k);
        FactorialThread factNK = new FactorialThread(n - k);

        // Start the threads
        factN.start();
        factK.start();
        factNK.start();

        // Wait for all threads to finish
        try {
            factN.join();
            factK.join();
            factNK.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get results from threads 
        long factNResult = factN.getResult();
        long factKResult = factK.getResult();
        long factNKResult = factNK.getResult();

        // Calculate C(n, k) using the formula: C(n, k) = n! / (k! * (n - k)!)
        long combination = factNResult / (factKResult * factNKResult);

        // Output the result
        System.out.println("C(" + n + ", " + k + ") = " + combination);

        sc.close();

    }
}


// Explanation:
// This program finds the combination C(n, k) using two threads. The FactorialThread class is a subclass of Thread that calculates the factorial of a given number.
// In the main class, we create three FactorialThread objects for calculating the factorials of n, k, and n-k.
// We start the threads and wait for them to finish using the join() method.
// After the threads have finished, we get the results from each thread and calculate the combination C(n, k) using the formula: C(n, k) = n! / (k! * (n - k)!).
// Finally, we output the result to the console.

// Here, we use threads to calculate the factorials of n, k, and n-k simultaneously, which can make the computation faster compared to a single-threaded approach.