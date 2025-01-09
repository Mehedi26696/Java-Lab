// In this problem, we will deal with the student database. A student can be identified
// with two pieces of information: name (string data) and roll number (integer data).
// a) We should have a class that would address associated members to solve this
// problem (Mark 10).
// b) We should have a function that adds a new student to the database. (Mark
// 20).
// c) We are going to track 7 days of student attendance. We should have a method
// that would take the day number (1st day, 2nd day, …) along with the student’s
// roll to store the information that the student was present at that day (Mark
// 30).
// d) Finally, we should have another method that would take a parameter denoting
// the student’s roll number and print the statistics (Mark 40). In this statistics,
// we need to print, the student’s full name, and the percentage of days he was
// present among the seven days. Alongside the days when he was absent.

import java.util.Scanner;

class Student {
    String name;
    int roll;

    Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }
}

class features {

    Student[] student = new Student[100];

    int i;

    void addstudent() {
        for (i = 0; i < 50; i++) {

            student[i] = new Student("Mehedi(" + i + ")", i);
        }
    }

    void newstudent(String name, int roll) {
        student[roll] = new Student(name, roll);

        if (i < roll) {

            i = roll;

        }
    }

    Boolean[][] att = new Boolean[8][100];

    void attendance(int day, int roll, Boolean verdict) {

        att[day][roll] = verdict;

    }

    void totalstudent() {
        for (int k = 1; k <= i; k++) {

            if (student[k] != null) {
                System.out.println(student[k].name);
                System.out.println(student[k].roll);
            }
        }
    }

    void presentstudent(int day) {
        for (int j = 1; j <= i; j++) {

            if (att[day][j] != null && att[day][j] == true && student[j] != null) {

                System.out.println(student[j].name);
                System.out.println(student[j].roll);
            }
        }

    }

    void absentstudent(int day) {
        for (int j = 1; j <= i; j++) {

            if (att[day][j] != null && att[day][j] == false && student[j] != null) {

                System.out.println(student[j].name);
                System.out.println(student[j].roll);
            }
        }
    }

    int totalstudentcount() {

        return i;
    }

    void statistics(int roll) {

        if (roll > i) {
            System.out.println("Invalid Roll number");
            return;
        }
        int count = 0;
        for (int j = 1; j <= 7; j++) {
            if (att[j][roll] != null && att[j][roll] == true && student[roll] != null) {
                count++;
            }
        }

        if (student[roll] != null) {

            System.out.println("Name: " + student[roll].name);
            System.out.println("Roll: " + student[roll].roll);

            System.out.println("Total present: " + count);

            Float percentage = (float) count / 7;
            System.out.println("Percentage of present: " + Math.round(percentage * 100)+ "%");
            System.out.println("Percentage of absent: " + Math.round((1 - percentage) * 100)+ "%");

            // abbsent days

            for (int j = 1; j <= 7; j++) {
                if (att[j][roll] != null && att[j][roll] == false) {
                    System.out.println("Absent on day: " + j);
                }
            }
        }
        else{
            System.out.println("Studnet not found");
        }

    }

}

public class StudentDatabase {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        features ff = new features();

        ff.addstudent();

        System.out.println("If want to see total studnets");

        System.out.println("1. Yes\n2. No");

        int flag = sc.nextInt();

        if (flag == 1) {
            ff.totalstudent();
        }

        System.out.println("If want to add a new studnet");

        System.out.println("1. Yes\n2. No");

        int c = sc.nextInt();

        if (c == 1) {
            System.out.println("Enter the name of the student: ");
            String name = sc.next();
            System.out.println("Enter the roll of the student: ");
            int roll = sc.nextInt();

            ff.newstudent(name, roll);
        }

        System.out.println("If want to see total studnets");

        System.out.println("1. Yes\n2. No");

        int flag1 = sc.nextInt();

        if (flag1 == 1) {
            ff.totalstudent();
        }

        int a = ff.totalstudentcount();

        for (int i = 1; i <= 7; i++) {

            for (int j = 1; j <= a; j++) {

                if (j % 2 == 1 && i % 2 == 0) {

                    ff.attendance(i, j, true);
                }

                else if (j % 2 == 0 && i % 2 == 1) {
                    ff.attendance(i, j, true);
                } else {
                    ff.attendance(i, j, false);
                }
            }

        }
        System.out.println("Attendance has been taken");
        System.out.println("If want to see the present or absent student");
        System.out.println("1. Yes\n2. No");

        int d = sc.nextInt();

        if (d == 1) {
            System.out.println("Enter the day number to see the present or absent student: ");

            int n = sc.nextInt();
            System.out.println("1.Present student\n2.Absent Student ");

            int b = sc.nextInt();

            if (b == 1) {
                ff.presentstudent(n);
            }

            else if (b == 2) {
                ff.absentstudent(n);
            }

            else {
                System.out.println("Invalid Choices");
            }
        }

        System.out.println("Enter the roll number to see the statistics between(1 to " + a + ")");

        int roll = sc.nextInt();

        ff.statistics(roll);

        sc.close();
    }
}