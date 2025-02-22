

// (II) Explain in the light of your example given in your answer to (I) as to how using the interface avoids the problem.

// Answer:


// (II) Using an interface avoids the diamond problem because interfaces do not contain any implementation.
//        When a class implements an interface, it must provide an implementation for all the methods defined in the interface.
//        This ensures that there is no ambiguity in method resolution. The above code can be modified to use interfaces as follows:

interface A {
    void display();
}


interface B{

    void display();
     
}

class C implements A, B {
    public void display() {
        System.out.println("Hello");
    }
}

public class Answer_II {
    public static void main(String[] args) {
        C ob = new C();
        ob.display();
    }
}


// In the above code, the class C implements both interfaces A and B. The display() method is defined in both interfaces.
//        The class C must provide an implementation for the display() method. This ensures that there is no ambiguity in method resolution.
//        Using interfaces in this way avoids the diamond problem and ensures that the code is unambiguous and easy to understand.
//        The output of the above code will be:
//        Hello
//        This demonstrates how using interfaces can avoid the diamond problem and ensure that the code is clear and unambiguous.
//        This is one of the key benefits of using interfaces in Java.
