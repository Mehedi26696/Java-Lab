

// (a) Discuss two ways through which Java achieves the OOP feature of polymorphism.

// Answer:
// Java achieves the OOP feature of polymorphism through the following ways:
// 1. Method Overloading
// 2. Method Overriding

// Method Overloading:
// Method overloading is a feature that allows a class to have more than one method having the same name, 
// if their argument lists are different. It is a type of compile-time polymorphism. It is also known as static polymorphism. 
// Method overloading is achieved by defining two or more methods in a class that have the same name but different parameters. 
// The methods can have different return types, but they must have different parameters. The compiler determines which method to call 
// based on the number and type of arguments passed to the method.

// Method Overriding:
// Method overriding is a feature that allows a subclass to provide a specific implementation of a method that is already provided by its superclass.
// When a subclass provides a specific implementation of a method that is already provided by its superclass, it is said to override the method.
// Method overriding is a type of run-time polymorphism. It is also known as dynamic polymorphism.

// Example of Method Overloading:

class A {
    public void display(int a) {
        System.out.println("Method with one argument: " + a);
    }

    public void display(int a, int b) {
        System.out.println("Method with two arguments: " + a + " and " + b);
    }
}

class B extends A {
    public void display(int a) {
        System.out.println("Overridden method with one argument: " + a);
    }
}

public class Main {
    public static void main(String[] args) {
        A obj = new A();
        obj.display(10);
        obj.display(20, 30);

        B obj2 = new B();
        obj2.display(40);
        obj2.display(50, 60);

    }
}