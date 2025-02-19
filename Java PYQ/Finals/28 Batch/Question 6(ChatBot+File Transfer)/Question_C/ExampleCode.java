
// public interface InnerExampleCode {
//     static int x;
//     final int y;
//     void demo () {
//     System.out.println("demo");
//   }

//   public void addDemo ();

// }

// class Def extends InnerExampleCode{

//     void demo () {
//         X = 67;
//         System.out.println("demo function here " + x);
//     }

//    void newFunc() {
//      int z = x + y;
//    }
// }
// public class ExampleCode{

//   public static void main (String[] args) {
//        InnerExampleCode inExp = new Def(); 
//        inExp.newFunc();
//   }
// }


// Probelem:
// 1. Interfaces cannot have instance variables
// 2. Interface methods cannot have implementations 
// 3. Interfaces cannot be extended using class
// 4. Static fields of an interface cannot be modified in a class
// 5. Interface methods must be implemented in the implementing class
// 6. Fields in an interface must be accessed using the interface name
// 7. newFunc() is not defined in InnerExampleCode, so it cannot be called
 

interface InnerExampleCode {
    static int x = 10;
    final int y = 20;
    void demo ();
    void addDemo ();
}

class Def implements InnerExampleCode{

    public void demo(){
      // x = 67;
      System.out.println("demo function here " + x);
    }

    public void addDemo(){
      int z = x + y;
      System.out.println("Sum of x and y is: " + z);
    }
}


public class ExampleCode{

  public static void main (String[] args) {
       InnerExampleCode inExp = new Def(); 
       inExp.addDemo();
  }
}