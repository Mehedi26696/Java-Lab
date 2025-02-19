

// (b) Explain the two main benefits of nested classes. Give an example code that demonstrates these benefits.

// Answer:

// The two main benefits of nested classes are:
// 1. Encapsulation: Nested classes can encapsulate the implementation details of the outer class. This means that the nested class can be hidden
// from the outside world and only used by the outer class. This helps to keep the code clean and organized.

// 2. Code Organization: Nested classes can help to organize the code by grouping related classes together. This makes it easier to understand the code and maintain it.

// Example code:

class Outer {
    private int x;

    public Outer(int x) {
        this.x = x;
    }

    // Nested class
    class Inner {
        public void display() {
            System.out.println("Value of x: " + x);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer(10);
        Outer.Inner inner = outer.new Inner();
        inner.display();
    }
}