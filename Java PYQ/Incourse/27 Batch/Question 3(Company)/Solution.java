// An employee has three pieces of data: name, ID (a number), and position ("Assistant Manager", "Deputy Manager", and "Manager"). Each of these three positions has a starting salary which are:
// 50,000 BDT, 60,000 BDT, and 80,000 BDT respectively. Each year on January 1, the salary of each employee is increased by 5%. Salary can also be changed when a promotion is achieved by an employee.
// Salary never changed outside these two conditions. Name and ID are never changed. Position can only be changed after promotion. The company can afford a maximum of 50 employees.

// You should write only one class named Employee where you need to write code to implement the above scenario. This class should include the main function where the following actions are performed:
// a) The company takes two new employees in Assistant Manager and Deputy Manager posts named "Sakib" and "Mahmud" respectively.
// b) Sakib gets a promotion to the "Deputy Manager" post.
// c) The year ends, and the company increases salaries of all employees by 5%.

// Your code should be as standard as possible as per the OOP practice.


class Employee {
    private String name;
    private int ID;
    private String position;
    private double salary;

    Employee(String name, int ID, String position) {
        this.name = name;
        this.ID = ID;
        this.position = position;
        if (position.equals("Assistant Manager")) {
            this.salary = 50000;
        } else if (position.equals("Deputy Manager")) {
            this.salary = 60000;
        } else if (position.equals("Manager")) {
            this.salary = 80000;
        }
    }

    void promote(String position) {
        this.position = position;
        if (position.equals("Assistant Manager")) {
            this.salary = 50000;
        } else if (position.equals("Deputy Manager")) {
            this.salary = 60000;
        } else if (position.equals("Manager")) {
            this.salary = 80000;
        }
    }

    void increaseSalary() {
        this.salary *= 1.05;
    }

    void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + ID);
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary);
    }
}

public class Solution {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Sakib", 1, "Assistant Manager");
        Employee emp2 = new Employee("Mahmud", 2, "Deputy Manager");
        
        System.out.println("Initial Information:");
        emp1.printInfo();
        emp2.printInfo();

        emp1.promote("Deputy Manager");
        System.out.println("\nAfter Promotion:");
        emp1.printInfo();
        emp2.printInfo();

    
        emp1.increaseSalary();
        emp2.increaseSalary();
        System.out.println("\nAfter Salary Increment:");
        emp1.printInfo();
        emp2.printInfo();
    }
}