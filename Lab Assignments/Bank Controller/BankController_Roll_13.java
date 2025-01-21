import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class CustomerException extends Exception {
    public CustomerException(String message) {
        super(message);
    }
}

class BalanceException extends Exception {
    public BalanceException(String message) {
        super(message);
    }
}

class Account {
    int transid;
    String name;
    int balance;

    static Account[] customers = new Account[1000];
    static int count = 0;

    public Account(int transid, String name, int balance) {
        this.transid = transid;
        this.name = name;
        this.balance = balance;
    }
   static synchronized void addCustomer(Account account) throws CustomerException {
        for (int i = 0; i < count; i++) {
            if (customers[i].transid == account.transid) {
                throw new CustomerException("Customer already exists");
            }
        }
        customers[count++] = account;
    }

   static synchronized Account getCustomer(int transid) throws CustomerException {
        for (int i = 0; i < count; i++) {
            if (customers[i].transid == transid) {
                return customers[i];
            }
        }
        throw new CustomerException("Customer does not exist");
    }
}

class CreateCustomer extends Thread {
    String name;
    int transid;

    CreateCustomer(String name, int id) throws CustomerException {
        this.name = name;
        this.transid = id;
         
        Account customer = new Account(transid, name, 0);
    }
    public void run() {
        System.out.println("Customer " + name + " created with transaction id " + transid);
    }
}

class DepositThread extends Thread {
    int transid;
    int money;

    DepositThread(int transid, int money) throws CustomerException {
        this.transid = transid;
        this.money = money;
         
        Account customer = Account.getCustomer(transid);
        
         
         
        customer.balance += money;
        
             
    }
    public void run() {
        System.out.println("Transaction " + transid + " deposited " + money);
    }
}

class WithdrawThread extends Thread {
    int transid;
    int money;

    WithdrawThread(int transid, int money) throws CustomerException, BalanceException {
        this.transid = transid;
        this.money = money;
        Account customer = Account.getCustomer(transid);
        
        if (customer.balance < money) {
                throw new BalanceException("Insufficient balance");
        }
        
       
        customer.balance -= money;
        
    }

    public void run() {
        System.out.println("Transaction " + transid + " withdrew " + money);
    }
}

class Generator extends Thread {
     int totalNumOfTrans;
     Random random = new Random();
     Map<Integer, Boolean> track = new HashMap<>();

    Generator(String name, int total) {
        super(name);
        this.totalNumOfTrans = total;
        start();
    }

    String genDeposit(){ // generating deposit type transaction
        int transID = genRandomTransID(); 
        int money = random.nextInt(10000) + 1; 
        int customerSerial = random.nextInt(100) + 1; // customers between 1 to 100 IDs ; 
        String message = "TRANSACTION " + transID +" DEPOSIT " + money + " CUSTOMER " + customerSerial; 
        return message;
    }

    String genWithdraw(){ // generating withdraw type transaction 
        int transID = genRandomTransID(); 
        int money = random.nextInt(10000) + 1; 
        int customerSerial = random.nextInt(100) + 1; // customers between 1 to 100 IDs ; 
        String message = "TRANSACTION " + transID +" WITHDRAW " + money + " CUSTOMER " + customerSerial; 
        return message;
    }

    String genCreate(){ // generating creation of customer type transaction
        int transID = genRandomTransID(); 

        int sz = random.nextInt(12) + 1; // Random size between 1 and 12
        String name = genRandomString(sz); 

        String message = "TRANSACTION " + transID +" CREATE CUSTOMER " + name; // 1st customer ID 1, 2nd Customer ID 2, 3rd so on 
        return message;
    }

    int genRandomTransID(){
        int v; 
        while(true){
            v = random.nextInt(100000000); 
            if(track.containsValue(v)) continue; 
            else {
                track.put(v, true); 
                break; 
            }
        }
        return v; 
    }

    String genRandomString(int sz){
        String name=""; 
        int v; 
        String temp;
        for(int i=0; i<sz; i++){
             v = random.nextInt(25) + 'A'; 
             name = name + (char)v; 
        }
        return name; 
     }

    public void run() {
        for (int i = 0; i < totalNumOfTrans; i++) {
            int v = random.nextInt(3);
            String trans;
            if (v == 0) {
                trans = genCreate();
                String[] parts = trans.split(" ");
                int id = Integer.parseInt(parts[1]);
                String name = parts[4];
                try {
                    CreateCustomer c = new CreateCustomer(name, id);
                    c.start();
                } catch (CustomerException e) {
                    System.out.println(e.getMessage());
                }
            } else if (v == 1) {
                trans = genDeposit();
                String[] parts = trans.split(" ");
                int id = Integer.parseInt(parts[1]);
                int money = Integer.parseInt(parts[3]);
                try {
                    DepositThread d = new DepositThread(id, money);
                    d.start();
                } catch (CustomerException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                trans = genWithdraw();
                String[] parts = trans.split(" ");
                int id = Integer.parseInt(parts[1]);
                int money = Integer.parseInt(parts[3]);
                try {
                    WithdrawThread w = new WithdrawThread(id, money);
                    w.start();
                } catch (CustomerException | BalanceException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println(trans);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class BankController_Roll_13 {
    public static void main(String[] args) {
        Generator g = new Generator("Transaction Generator Thread", 1000);
        try {
            g.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
