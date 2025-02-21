

import java.io.*;

class Student implements Serializable {
    int id;
    String name;
    double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class WriteStudents {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StudentInformation.dat"))) {
            Student[] students = {
                new Student(101, "Anik", 85.5),
                new Student(102, "Aurnob", 45.0),
                new Student(103, "Mehedi", 55.2),
                new Student(104, "Ahnaf", 72.3),
                new Student(105, "ABS", 38.7)
            };

            for (Student s : students) {
                oos.writeObject(s);
            }

            System.out.println("Student data has been written to StudentInformation.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
