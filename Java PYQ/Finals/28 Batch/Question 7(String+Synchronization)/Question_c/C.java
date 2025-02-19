
// (c). Explain the concept of deadlock using an example

// Deadlock is a situation where two or more threads are blocked forever, waiting for each other. Here's an example:

// Let's say we have two threads t1 and t2. Both of them need access to two shared resources r1 and r2.
// If t1 locks r1 and t2 locks r2, and then t1 tries to lock r2 and t2 tries to lock r1, a deadlock will occur. 
// Both threads will be blocked forever, waiting for each other to release the resources they need.

// Here's an example code that demonstrates a deadlock:

class Resource {
    String name;

    Resource(String name) {
        this.name = name;
    }
}

public class C {

     public static void main(String[] args) {

        Resource r1 = new Resource("Liverpool");
        Resource r2 = new Resource( "Manchester");

        Thread t1 = new Thread(() -> {
            synchronized (r1) {
                System.out.println("Thread 1: locked "+ r1.name);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (r2) {
                    System.out.println("Thread 1: locked "+ r2.name);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (r2) {
                System.out.println("Thread 2: locked "+ r2.name);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (r1) {
                    System.out.println("Thread 2: locked "+ r1.name);
                }
            }
        });

        t1.start();
        t2.start();

     }
}


// In this code, we have two threads t1 and t2. t1 locks r1 and then tries to lock r2, while t2 locks r2 and then tries to lock r1.
// When we run this code, a deadlock will occur because t1 is waiting for r2 to be released by t2, and t2 is waiting for r1 to be released by t1.

// Output:
// Thread 1: locked r1
// Thread 2: locked r2
// program hangs here

// The program will hang at this point because both threads are blocked waiting for each other to release the resources they need. This is a classic example of a deadlock.





