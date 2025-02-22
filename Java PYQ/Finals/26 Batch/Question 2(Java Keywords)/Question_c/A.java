
// (c) When is a static block of code executed? Write down the output of the following code segment:

// Answer: The static block of code is executed when the class is loaded.

class A {
    static int a;
    static int b;
    static {
        System.out.println("a: " + a + ", b: " + b);
    }
    {

        b++;
        System.out.println("b in block: " + b);
    }

    public A() {

        System.out.println("constructor");
    }

    public static void main(String[] args) {

        System.out.println("Some text.");
        A ob = new A();
        A ob2 = new A();

    }

}

// Output:
// a: 0, b: 0
// Some text.
// b in block: 1
// constructor
// b in block: 2
// constructor
