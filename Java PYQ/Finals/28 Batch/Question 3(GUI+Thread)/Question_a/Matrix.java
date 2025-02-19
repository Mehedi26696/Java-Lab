
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows of first matrix: ");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns of first matrix: ");
        int columns = sc.nextInt();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the number of rows of second matrix: ");
        int rows2 = sc.nextInt();
        System.out.println("Enter the number of columns of second matrix: ");
        int columns2 = sc.nextInt();
        int[][] matrix2 = new int[rows2][columns2];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

        if (columns != rows2) {
            System.out.println("Matrix multiplication is not possible");
        } else {
            int[][] result = new int[rows][columns2];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns2; j++) {
                    for (int k = 0; k < columns; k++) {
                        result[i][j] += matrix[i][k] * matrix2[k][j];
                    }
                }
            }

            System.out.println("Resultant matrix after multiplication:");
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
        sc.close();

    }

}