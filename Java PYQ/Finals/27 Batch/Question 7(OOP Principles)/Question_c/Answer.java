

// (c) What is the difference between method overriding and method overloading? Explain with examples.

// Method Overloading: Method overloading is a feature that allows a class to have more than one method having the same name, if their argument lists are different. 
// It is similar to constructor overloading in Java, that allows a class to have more than one constructor having different argument lists.

// Method Overriding: Method overriding is a feature that allows a subclass to provide a specific implementation of a method that is already provided by its superclass.


class A {

    void display() {
        System.out.println("Class A");
    }
    // Method Overloading
    void display(int a) {
        System.out.println("A " + a);
    }
}


class B extends A {
    // Method Overriding

    void display() {
        System.out.println("Class B");
    }
    // Method Overloading
    void display(int a, int b) {
        System.out.println("A " + a+ " B " + b);
    }
}

public class Answer {
    public static void main(String[] args) {
        A a = new A();
        a.display();
        a.display(10);

        B b = new B();
        b.display();
        b.display(20);
        b.display(10, 20);
    }
}
