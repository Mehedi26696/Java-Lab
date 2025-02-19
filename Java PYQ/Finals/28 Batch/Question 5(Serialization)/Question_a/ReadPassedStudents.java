
import java.io.*;

public class ReadPassedStudents {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StudentInformation.dat"))) {
            System.out.println("Students who passed the exam:");
            while (true) {
                try {
                    Student student = (Student) ois.readObject();
                    if (student.marks >= 50) {
                        System.out.println("ID: " + student.id + ", Name: " + student.name);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
