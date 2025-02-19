
// (b) You are given the following multi-threaded program. You need to extract the values from the array given Arr in the object of the class Data and store them locally
//       within the classes' array SArr that implements the thread. Each value should be extracted only once from Arr. You can assume that all the values of Arr will be a 
//       positive integer number. For any index, the value -1 means that the value of that index has already been extracted.

//       Identify any concurrency-related issues and explain your rationale. In addition, mention any synchronization measure you would consider here.
//       Modify the program in such regard and analyze the improvement.

// Code:

// class Data {

//   int Arr[];

//   public Data() {
//     Arr = new int[20];
//     for (int i = 0; i < 20; i++) {

//       Arr[i] = i*2 + 1;
//     }
//   }
// }

// class Processor implements Runnable {

//   Data d;
//   int SArr[];
//   Thread t;

//   public Processor(Data d, String threadName) {
//     SArr = new int[20];
//     this.d = d;
//     t = new Thread(this, threadName);
//   }

//   public void run() {
//     int j = -1;
//     for (int i = 0; i < 20; i++) {

//       if (this.d.Arr[i] != -1) {
//         j++;
//         SArr[j] = this.d.Arr[i];
//         System.out.println("j = " + SArr[j] + " " + i + " " + d.Arr[i] + " " + Thread.currentThread());
//         this.d.Arr[i] = -1;
//       }
//     }
//   }
// }

// public class ConcurThread {

//   public static void main(String[] args) {
//     Data d = new Data();
//     Processor pl = new Processor(d, "p1");
//     Processor p2 = new Processor(d, "p2");
//     pl.t.start();
//     p2.t.start();
//     try {
//       pl.t.join();
//       p2.t.join();
//     } catch (Exception e) {
//       e.printStackTrace();
//     }
//   }
// }


// The given code has a concurrency issue because multiple threads are accessing and modifying the shared array `Arr` without synchronization.
//  This can lead to race conditions where multiple threads might read and write to the same index simultaneously, causing incorrect results.

// To resolve this issue, we need to synchronize the access to the shared array `Arr`. We can use a synchronized block to ensure that only one
//  thread can access and modify the array at a time.

class Data {

  int Arr[];

  public Data() {
    Arr = new int[20];
    for (int i = 0; i < 20; i++) {
      Arr[i] = i * 2 + 1;
    }
  }
}

class Processor implements Runnable {

  Data d;
  int SArr[];
  Thread t;

  public Processor(Data d, String threadName) {
    SArr = new int[20];
    this.d = d;
    t = new Thread(this, threadName);
  }

  public void run() {
    int j = -1;
    for (int i = 0; i < 20; i++) {
      synchronized (d) {
        if (this.d.Arr[i] != -1) {
          j++;
          SArr[j] = this.d.Arr[i];
          System.out.println("j = " + SArr[j] + " " + i + " " + d.Arr[i] + " " + Thread.currentThread());
          this.d.Arr[i] = -1;
        }
      }
    }
  }
}

public class ConcurThread {

  public static void main(String[] args) {
    Data d = new Data();
    Processor pl = new Processor(d, "p1");
    Processor p2 = new Processor(d, "p2");
    pl.t.start();
    p2.t.start();
    try {
      pl.t.join();
      p2.t.join();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

// By adding the synchronized block around the critical section where the array `Arr` is accessed and modified, we ensure that only one thread can execute that section at a time. 
// This prevents race conditions and ensures that each value is extracted only once from the array.