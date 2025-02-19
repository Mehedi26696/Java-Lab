

// (a) What is the difference between checked exceptions (e.g., IOException) and unchecked exceptions (e.g., ArithmeticException) in Java, and how are they handled differently in the code?

// Answer: 
// Checked exceptions are exceptions that are checked at compile time. This means that the compiler will check if the code that can throw a checked exception is surrounded by 
// a try-catch block or if the method that can throw a checked exception declares it in its throws clause. Unchecked exceptions, on the other hand, are exceptions that are not checked 
// at compile time. This means that the compiler does not require the code to handle or declare unchecked exceptions.

// Checked exceptions must be either caught or declared in the throws clause of the method. If a method throws a checked exception, the calling method must either catch the exception
// or declare it in its throws clause. Unchecked exceptions, on the other hand, do not need to be caught or declared. If an unchecked exception is thrown and not caught, it will propagate
// up the call stack until it is caught or the program terminates.


// Example of throwing and catching checked and unchecked exceptions:

import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class ExceptionExample {

    // Checked exception - FileNotFoundException
    public void readFile1(String fileName) {
        try {
            FileReader file1 = new FileReader(fileName);
            System.out.println("File found and opened.");
        } catch (FileNotFoundException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }
    }

    // Checked exception - IOException
    public void readFile2(String fileName) throws IOException {
        FileReader file2 = new FileReader(fileName);
        System.out.println("File found and opened.");
    }

    // checked exception - without try-catch block or throws clause
    // Cheked exception has to be handled
    // public void readFile3(String fileName) {
    //     FileReader file3 = new FileReader(fileName);
    //     System.out.println("File found and opened.");
    // }



    // Unchecked exception - ArithmeticException

    // Unchecked exception - without try-catch block
    // Unchecked exception does not have to be handled
   

    // Unchecked exception - with try-catch block

    public void divide2(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }
    }

    // Unchecked exception - without try-catch block

    public void divide(int a, int b) {
        int result = a / b;
        System.out.println("Result of division: " + result);
    }

  



    public static void main(String[] args) {
        ExceptionExample example = new ExceptionExample();

        // Handling checked exception
        example.readFile1("nonexistentfile.txt");

        // Handling checked exception with throws clause

        try {
            example.readFile2("nonexistentfile.txt");
        } catch (IOException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }

        // Handling unchecked exception
       // example.readFile3("nonexistentfile.txt");

        // Handling unchecked exception
        example.divide2(10, 0);

        // Handling unchecked exception with try-catch block
        example.divide(10, 0);
    }
}




// The main difference between checked and unchecked exceptions is how they are handled by the compiler and the programmer. 
// Checked exceptions are checked at compile time, and the programmer is required to handle them explicitly using try-catch blocks or by declaring them in the method's throws clause. 
// Unchecked exceptions are not checked at compile time, and the programmer is not required to handle them explicitly. 
// This means that unchecked exceptions can propagate up the call stack and potentially terminate the program if not caught.


