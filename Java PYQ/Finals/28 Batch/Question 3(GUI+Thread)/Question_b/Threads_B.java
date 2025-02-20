//(b) To make the computation faster, the thread-based program can be a help. Write a Java program to find C using two threads.

// C  = AXB here A and B are two matrix

import java.util.Scanner;
 
class MatrixMultiplication extends Thread
{
    int rowStart, rowEnd;
    int[][] A, B, C;
 
    public MatrixMultiplication(int rowStart, int rowEnd, int[][] A, int[][] B, int[][] C)
    {
        this.rowStart = rowStart;
        this.rowEnd = rowEnd;
        this.A = A;
        this.B = B;
        this.C = C;
    }
    
    public void run()
    {   

        for (int i = rowStart; i < rowEnd; i++)
        {
            for (int j = 0; j < C[0].length; j++)
            {
                C[i][j] = 0;
                for (int k = 0; k < A[0].length; k++)
                {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }
}


public class Threads_B
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of matrix A: ");
        int rowsA = sc.nextInt();
        int colsA = sc.nextInt();
        System.out.println("Enter the number of rows and columns of matrix B: ");
        int rowsB = sc.nextInt();
        int colsB = sc.nextInt();
        
        if (colsA != rowsB)
        {
            System.out.println("Matrix multiplication is not possible.");
            return;
        }
        
        int[][] A = new int[rowsA][colsA];
        int[][] B = new int[rowsB][colsB];
        int[][] C = new int[rowsA][colsB];
        
        System.out.println("Enter the elements of matrix A: ");
        for (int i = 0; i < rowsA; i++)
        {
            for (int j = 0; j < colsA; j++)
            {
                A[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("Enter the elements of matrix B: ");
        for (int i = 0; i < rowsB; i++)
        {
            for (int j = 0; j < colsB; j++)
            {
                B[i][j] = sc.nextInt();
            }
        }
        
        
        int rows = A.length;
        int cols = B[0].length;

        
        MatrixMultiplication t1 = new MatrixMultiplication(0, rows / 2, A, B, C);

        MatrixMultiplication t2 = new MatrixMultiplication(rows / 2, rows, A, B, C);

        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();

        }

        System.out.println("Product of matrices A and B is: ");

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}

