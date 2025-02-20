
// (b) Put appropriate exception handling code in the following code snippet. You must use the best practice of exception handling.

// public static void main(String args[]){

//     int i=0;
//     FileInputStream fin= new FileInputStream (filename); //may throw IOException

//     do {

//     i = fin.read(); //may throw IOException

//     if(i!= -1) System.out.print((char) i);

//     } while (i!= -1);

//     fin.close(); //may throw IOException

// }

//Answer:

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Answer {

    public static void main(String args[]) {

        String filename = "example.txt"; // Ensure a valid filename is provided
        
        int i = 0;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(filename);
            
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file - " + e.getMessage());
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    System.err.println("Error closing file - " + e.getMessage());
                }
            }
        }
    }

}
