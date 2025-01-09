
// In this problem, we will deal with a banking system. A customer of a bank will have
// two pieces of information for his authentication, name (string data) and customer ID
// (integer number).
// a) We should have a class that would address associated members to solve this
// problem (Mark 10).
// b) We should have a function that adds a new customer to the database (Mark
// 20).
// c) We are going to track 7 days of banking transactions. We should have a
// method that would take the day number (1st day, 2nd day, …) customer ID,
// transaction type (deposit/withdrawal), and an amount of money (integer).
// This method would be responsible for executing the transaction and updating
// the information in the banking database (Mark 30).
// d) Finally, we should have another method that would take a parameter
// denoting the customer’s ID and print the statistics (Mark 40). In these
// statistics, we need to print the customer’s full ID, the amount of current
// savings in his account, and the days when he did some sort of transaction
// (deposit/withdrawal) with the information regarding the associated money.

import java.util.Scanner;

class Customer {
    String name;
    int id;
    int savings;
    int days;
    int money;

    Customer(String name, int id) {
        // System.out.println("Customer ID: " + id + " Customer Name: " + name);
        this.name = name;
        this.id = id;
        this.savings = 500;
        this.days = 0;
        this.money = 0;

    }
}

class Features {
    Customer[] acc = new Customer[100];

    int i = 0;

    void addCustomer() {

        System.out.println("Adding 50 customers: ");
        for (i = 1; i <= 50; i++) {

            acc[i] = new Customer("Mehedi(" + i + ")", i);
        }

    }

    void addnewCustomer(String name, int id) {

        acc[id] = new Customer(name, id);
        if (i < id) {
            i = id;
        }
    }

    void AllCustomer() {

        System.out.println("Total Customer: ");

        for (int j = 1; j <= i; j++) {
            if (acc[j] != null) {
                System.out.println("Customer ID: " + acc[j].id + " Customer Name: " + acc[j].name);
            }
        }

    }

    String t;

    void transaction(int day, int id, String type, int amount) {
        if (type.equals("deposit")) {
            acc[id].savings += amount;
            acc[id].days = day;
            acc[id].money = amount;
            t = type;
        } else if (type.equals("withdrawal")) {

            if (acc[id].savings < amount) {
                System.out.println("Insufficient Balance");
                return;
            } else {

                acc[id].savings -= amount;
                acc[id].days = day;
                acc[id].money = amount;
                t = type;
            }

        }
    }

    void printStatistics(int id) {
        System.out.println("Customer ID: " + acc[id].id);
        System.out.println("Customer Name: " + acc[id].name);
        System.out.println("Current Savings: " + acc[id].savings);
        System.out.println("Days of Transaction: ");

        if (acc[id].days == 0) {
            System.out.println("No Transaction");
            return;
        }

        System.out.println("Day: " + acc[id].days + " Money: " + acc[id].money + " Type: " + t);

    }

}

public class BankingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Features f = new Features();
        f.addCustomer();

        System.out.println("If you want to see the total customer:");

        System.out.println("1.Yes\n2.No");

        int ch = sc.nextInt();

        if (ch == 1) {
            f.AllCustomer();
        }

        System.out.println("If you want to add new customer:");
        System.out.println("1.Yes\n2.No");

        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("Enter the name of the customer: ");

            String name = sc.next();
            System.out.println("Enter the ID of the customer: ");
            int id = sc.nextInt();
            f.addnewCustomer(name, id);
        }

        System.out.println("If you want to see total customer:");
        System.out.println("1.Yes\n2.No");

        int c = sc.nextInt();

        if (c == 1) {
            f.AllCustomer();
        }

        System.out.println("If you want to do transaction:");
        System.out.println("1.Yes\n2.No");

        int c1 = sc.nextInt();

        if (c1 == 1) {
            System.out.println("Enter the day number: ");
            int day = sc.nextInt();
            System.out.println("Enter the customer ID: ");
            int id = sc.nextInt();
            System.out.println("Enter the transaction type: ");
            System.out.println("1.Deposit\n2.Withdrawal");
            int t = sc.nextInt();
            String type;
            if (t == 1) {
                type = "deposit";
            } else {
                type = "withdrawal";
            }

            System.out.println("Enter the amount of money: ");
            int amount = sc.nextInt();
            f.transaction(day, id, type, amount);
        }

        System.out.println("If you want to see the statistics:");

        System.out.println("1.Yes\n2.No");

        int c2 = sc.nextInt();

        if (c2 == 1) {
            System.out.println("Enter the customer ID: ");
            int id = sc.nextInt();
            f.printStatistics(id);
        }

        sc.close();
    }
}
