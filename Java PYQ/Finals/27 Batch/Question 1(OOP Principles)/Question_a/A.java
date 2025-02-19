
// (a) What is constructor overloading? Give an example. What happens when a return type, even void, is specified for a constructor?


// Constructor overloading is a concept in which a class can have more than one constructor with different parameters. The constructors can 
// have different number of parameters, different types of parameters, or both. The constructors are distinguished by the number and types of parameters they accept.
// The constructors are called based on the arguments passed to them. The constructors are used to initialize the objects of the class.

// Example:

class A {
    int x, y;

    A() {
        x = 10;
        y = 20;
    }

    A(int a) {
        x = a;
        y = 20;
    }

    A(int a, int b) {
        x = a;
        y = b;
    }

    void display() {
        System.out.println("x = " + x + ", y = " + y);
    }

    public static void main(String[] args) {
        A obj1 = new A();
        A obj2 = new A(30);
        A obj3 = new A(40, 50);

        obj1.display();
        obj2.display();
        obj3.display();
    }
}


// What happens when a return type, even void, is specified for a constructor?

// A constructor cannot have a return type, not even void. If a return type is specified for a constructor, it is treated as a method and not a constructor.
// The compiler will not treat it as a constructor and will not generate a default constructor. The compiler will generate an error if a return type is specified for a constructor.
