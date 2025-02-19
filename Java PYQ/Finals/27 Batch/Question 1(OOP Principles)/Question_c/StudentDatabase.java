

// (c) Design a class named student that has two private data - student id and score. The class should contain a parameterized constructor to 
//     initialize its data members and one method to display the information. Now, write a Java program that will use an array of the Student 
//     objects to represent information about n number of students. Your program should take input from the keyboard and display the students' information.


import java.util.Scanner;

class Student {
    private int studentId;
    private int score;

    public Student(int studentId, int score) {
        this.studentId = studentId;
        this.score = score;
    }

    public void display() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Score: " + score);
    }
}

public class StudentDatabase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student ID: ");
            int studentId = sc.nextInt();
            System.out.print("Enter score: ");
            int score = sc.nextInt();
            students[i] = new Student(studentId, score);
        }
        for (int i = 0; i < n; i++) {
            students[i].display();
        }
        sc.close();
    }
}