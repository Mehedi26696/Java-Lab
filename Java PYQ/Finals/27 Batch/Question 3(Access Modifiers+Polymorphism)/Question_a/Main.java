
// (a) Explain the different types of polymorphism that are available in Java with an example.

// There are two types of polymorphism in Java: compile-time polymorphism and runtime polymorphism.

// Compile-time polymorphism is method overloading. It is achieved when two or more methods in the same class have the same name but different parameters. 
// The method that is called is determined by the number and type of arguments passed to the method.  

// runtime polymorphism is method overriding. It is achieved when a subclass provides a specific implementation of a method that is already provided by its superclass.



class A {
    
    
    void display(int a) {
        System.out.println("Class A: a = " + a);
    }

    // Method overloading
    void display(int a, int b) {
        System.out.println("Class A : a = " + a + ", b = " + b);
    }
}

class B extends A {
    
    // Method overriding
    void display(int a, int b) {
        System.out.println("Class B : a = " + a + ", b = " + b);
    }
}

public class Main {
    public static void main(String[] args) {
        A obj1 = new A();
        A obj2 = new B();
        B obj3 = new B();

        obj1.display(10);
        obj1.display(20, 30);

        obj2.display(40);
        obj2.display(50, 60);

        obj3.display(70);
        obj3.display(80, 90);
    }
}
