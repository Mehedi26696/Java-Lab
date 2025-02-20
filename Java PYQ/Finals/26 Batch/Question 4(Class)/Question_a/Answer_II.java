

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

class D implements A {
    public void display() {
        System.out.println("D");
    }

    public static void main(String[] args) {
        D obj = new D();
        obj.display();
    }
}

// In the above code, the interface A defines the display() method. The classes B, C, and D implement the interface A and provide their own implementation for the display() method.
// This ensures that there is no ambiguity in method resolution, and the code will compile and run without any issues.