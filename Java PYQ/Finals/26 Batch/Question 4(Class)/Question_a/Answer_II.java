

// (II) Explain in the light of your example given in your answer to (I) as to how using the interface avoids the problem.

// Answer:


// (II) Using an interface avoids the diamond problem because interfaces do not contain any implementation.
//        When a class implements an interface, it must provide an implementation for all the methods defined in the interface.
//        This ensures that there is no ambiguity in method resolution. The above code can be modified to use interfaces as follows:

interface A {
    void display();
}

class B implements A {
    public void display() {
        System.out.println("B");
    }
}

class C implements A {
    public void display() {
        System.out.println("C");
    }
}

class D implements B, C {
    public void display() {
        System.out.println("D");
    }
}

public class Answer_II {
    public static void main(String[] args) {
        D ob = new D();
        ob.display();
    }
}

// In the above code, the interface A contains a method display(). The classes B and C implement the interface A and provide an implementation for the display() method.
// The class D implements both the interfaces B and C. Since the display() method is defined in the interface A, the class D must provide an implementation for the display() method.
// This ensures that there is no ambiguity in method resolution, and the diamond problem is avoided. The output of the above code will be:
// D
// This demonstrates how using interfaces can avoid the diamond problem by enforcing a single implementation for the methods defined in the interface.