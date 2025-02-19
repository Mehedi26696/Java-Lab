

// b) Write a program in Java to perform the following,
// i) Consider the parent class named Account. Design its two child classes named CurrentAccount and SavingsAccount. Child classes should have at least
// one additional meaningful variable declared within them, one parameterized constructor, and a toString method. The CurrentAccount maintains daily transactions,
//  and provides a chequebook facility, but does not provide any interest. The SavingsAccount does not provide any chequebook but provides yearly interest.


// ii) Design a driver class named Inheritance Test and a main method inside it.
// Declare at least one object of each of the two child classes using the
// parameterized constructor. Display values of all the variables of these
// objects using the toString method. You have to ensure the maximum utilization
// of the variables/methods of the parent class.



import java.util.Scanner;

class Account {
    int accountNumber;
    String name;
    double balance;

    Account(int n, String s, double b) {
        accountNumber = n;
        name = s;
        balance = b;
    }

    public String toString() {
        return accountNumber + " " + name + " " + balance;
    }
}


class CurrentAccount extends Account {
    double dailyTransactions;
    boolean chequebook;

    CurrentAccount(int n, String s, double b, double d, boolean c) {
        super(n, s, b);
        dailyTransactions = d;
        chequebook = c;
    }

    public String toString() {
        return super.toString() + " " + dailyTransactions + " " + chequebook;
    }
}

class SavingsAccount extends Account {
    double yearlyInterest;

    SavingsAccount(int n, String s, double b, double y) {
        super(n, s, b);
        yearlyInterest = y;
    }

    public String toString() {
        return super.toString() + " " + yearlyInterest;
    }
}

public class InheritanceTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account number, name, balance, daily transactions, chequebook status for Current Account:");

        int n = sc.nextInt();
        String s = sc.next();
        double b = sc.nextDouble();
        double d = sc.nextDouble();
        boolean c = sc.nextBoolean();
        
        CurrentAccount ca = new CurrentAccount(n, s, b, d, c);

        System.out.println("Enter account number, name, balance, yearly interest for Savings Account:");

        n = sc.nextInt();
        s = sc.next();
        b = sc.nextDouble();
        double y = sc.nextDouble();
        
        SavingsAccount sa = new SavingsAccount(n, s, b, y);

        System.out.println(ca.toString());
        System.out.println(sa.toString());

        sc.close();
    }
}


