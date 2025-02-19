

// (c) Explain the difference between the "throw" and "throws" keywords in Java exception handling with example codes.

// "throw" is used to explicitly throw an exception from a method or any block of code.
// "throws" is used in the method signature to declare the exceptions that can be thrown by the method.

// Example code for "throw":
// In the following example, the readFile() method throws an IOException using the "throw" keyword.
// The exception is caught in the main method using a try-catch block.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ExceptionExample {

    // This method declares that it can throw an IOException
    public void readFile() throws IOException {
        FileReader file = new FileReader("somefile.txt");
        BufferedReader fileInput = new BufferedReader(file);

        // Throwing an exception using "throw"
        throw new IOException("File not found");
    }

    public static void main(String[] args) {
        ExceptionExample example = new ExceptionExample();
        try {
            example.readFile();
        } catch (IOException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }
}