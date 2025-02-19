
// (a) "Suppose, you are implementing a database for storing the information of some students. You will be given an array of students. Each student has a unique name 
//      and three additional features - age, nationality, and address. After storing the information, you will be asked with a query given by a string X to fetch the 
//      data of the student named X. If no such entry exists, you need to create a custom exception denoting the issue."
//      Write a Java program for the above scenario. Not that you can only use basic Arrays and can't use any sophisticated collection framework (e.g., HashMap, ArrayList, Set, etc..).

 
import java.util.Scanner;

class Student {
    String name;
    int age;
    String nationality;
    String address;

    Student(String name, int age, String nationality, String address) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.address = address;
    }
}

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

class Database {
    Student[] students = new Student[100]; // Fixed array size
    int totalStudents = 0;

    public void addStudent(String name, int age, String nationality, String address) {
        if (totalStudents < students.length) {
            students[totalStudents++] = new Student(name, age, nationality, address);
        } else {
            System.out.println("Database is full! Cannot add more students.");
        }
    }

    public void fetchStudent(String name) throws StudentNotFoundException {
        for (int i = 0; i < totalStudents; i++) {
            if (students[i].name.equalsIgnoreCase(name)) { // Case-insensitive search
                System.out.println("Name: " + students[i].name);
                System.out.println("Age: " + students[i].age);
                System.out.println("Nationality: " + students[i].nationality);
                System.out.println("Address: " + students[i].address);
                return;
            }
        }
        throw new StudentNotFoundException("Student not found");
    }

    public void display() {
        System.out.println("Total number of students: " + totalStudents);
        for (int i = 0; i < totalStudents; i++) {
            System.out.println("Name: " + students[i].name);
            System.out.println("Age: " + students[i].age);
            System.out.println("Nationality: " + students[i].nationality);
            System.out.println("Address: " + students[i].address);
            System.out.println("--------------------------");
        }
    }
}

public class StudentDatabase {
    public static void main(String[] args) {
        Database db = new Database();

        // Adding students
        db.addStudent("Mbappe", 22, "French", "Paris");
        db.addStudent("Musiala", 18, "German", "Munich");
        db.addStudent("Wirtz", 18, "German", "Leverkusen");
        db.addStudent("Haaland", 20, "Norwegian", "Manchester");

        db.display();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the student: ");
        String name = sc.nextLine();

        try {
            db.fetchStudent(name);
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
