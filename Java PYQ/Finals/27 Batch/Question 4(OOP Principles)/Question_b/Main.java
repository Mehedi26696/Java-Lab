


// (b) Explain the concept of the "super" keyword in Java. How is it used in method overriding?

// Answer:
// The "super" keyword in Java is used to refer to the immediate parent class object. It is commonly used in the following contexts:
// 1. To access the parent class instance variables and methods.
// 2. To invoke the parent class constructor
// 3. To invoke the parent class method that is overridden by a subclass method.

// In method overriding, the "super" keyword is used to invoke the parent class method that is overridden by a subclass method. This is useful when we want to call the parent class
//  method from the subclass method. For example, consider the following code snippet:

class Parent {

    int a;
    int b;
    public Parent(int a, int b) {
        this.a = a;
        this.b = b;
         
    }
    void display() {
        System.out.println("Parent class method");
    }
}

class Child extends Parent {
    int c;
    public Child(int a, int b, int c) {
        super(a, b); // calling parent class constructor
        this.c = c;
       
    }

    void display() {
        super.display(); // calling parent class method
        System.out.println("Child class method");
    }
    
}

public class Main {
    public static void main(String[] args) {
        Child obj = new Child(10, 20, 30);
        obj.display();
    }
}

