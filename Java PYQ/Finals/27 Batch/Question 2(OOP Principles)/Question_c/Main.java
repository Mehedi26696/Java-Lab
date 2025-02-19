
// (c) Mention three cases where the final keyword is used.

// Answer:

// 1. A final variable can be explicitly initialized only once.
// 2. A final method cannot be overridden by subclasses.
// 3. A final class cannot be subclassed.


// Example:


class A{
    final int x = 10;
    final void display(){
        System.out.println("Hello");
    }
}


class B extends A{

  //  x = 20; // cannot reassign final variable

    // cannot override final method
    // void display(){
    //     System.out.println("Hi");
    // }
}

final class C{

    void display(){
        System.out.println("Hello");
    }
}
 
// cannot subclass final class
// class D extends C{
//     
// }



public class Main{
    public static void main(String[] args){
        B obj = new B();
        obj.display();
    }
}