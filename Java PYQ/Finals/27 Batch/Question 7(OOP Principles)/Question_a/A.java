
// (a) Generate the output of the following Java program and state the reason for your result:


// public class A{
//          A() {
//             System.out.println("Constructor of A");
//          }

//         void print() {
//             System.out.println("Inside print method of A");
//         }
//     }

// public class B extends A{

//     B() {
//         System.out.println("Constructor of B");
//     }
//     void print() {
//         System.out.println("Inside print method of B");
//     }
//     public static void main(String[] args) { 
//         A a = new B();

//        a.print();
//     }
// }



// This code will give an error beacause in same file we can't have two public classes. So, we have to remove public from class A and class B.