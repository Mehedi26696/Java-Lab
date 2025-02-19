package a;

//a) "Inheritance provides a powerful mechanism for code reuse" - Justify your opinion with proper examples.

//Answer: Inheritance is a mechanism in which one object acquires all the properties and behaviors of a parent object. It is a mechanism in which one class acquires
//  the properties and behaviors of another class. It represents the IS-A relationship which is also known as a parent-child relationship. It is used for code reuse
//  and to establish a relationship between two classes.  

//  Example: In the below example, we have a class A and two classes B and C which are inheriting class A. Class B and C are inheriting the properties and behaviors

import java.util.Scanner;

class A {
    int a;
    int b;

    A(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void parent() {
        System.out.println("Parent class");
    }

    void display() {
        System.out.println("This is class A");
    }
}

class B extends A {

    int num;

    B(int a, int b, int num) {
        super(a, b);
        this.num = num;
    }

    void display() {
        System.out.println("This is class B");
    }
}

class C extends A {
    int digit;

    C(int a, int b, int digit) {
        super(a, b);
        this.digit = digit;
    }

    void display() {
        System.out.println("This is class C");
    }
}

public class Main_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b, num, digit;

        a = sc.nextInt();
        b = sc.nextInt();
        num = sc.nextInt();
        digit = sc.nextInt();


        A obj1 = new A(a, b);
        B obj2 = new B(a, b, num);
        C obj3 = new C(a, b, digit);

        obj1.display();
        obj2.display();
        obj3.display();

        obj1.parent();
        obj2.parent();
        obj3.parent();

        sc.close();
    }
}

// The above example demonstrates how inheritance allows for code reuse. 
// Class B and Class C inherit from Class A, meaning they automatically have access to the properties and methods defined in Class A. 
// This avoids the need to duplicate code in each subclass. 
// For instance, the `parent()` method and the properties `a` and `b` are defined only once in Class A, but can be used by both Class B and Class C. 
// This not only reduces redundancy but also makes the code easier to maintain and extend. 
// If a change is needed in the `parent()` method, it only needs to be updated in one place (Class A), and the change will be reflected in all subclasses.
