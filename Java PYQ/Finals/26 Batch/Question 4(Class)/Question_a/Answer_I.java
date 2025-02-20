

// (a) (I) Why does Java not allow two classes to be inherited by the same class? Explain the problem (with appropriate example code)
//      that may ensue if one class inherits two classes.


//Answer:

//  (I) Java does not allow two classes to be inherited by the same class because of the diamond problem. The diamond problem occurs when 
//        a class inherits two classes that have a common ancestor. This results in ambiguity as to which method to call when a method is called from the common ancestor. 
//        This is because the common ancestor's method is inherited twice by the derived class. This can be illustrated with the following code:

class A {
    void display() {
        System.out.println("A");
    }
}

class B extends A {
    void display() {
        System.out.println("B");
    }
}

class C extends A {
    void display() {
        System.out.println("C");
    }
}

// class D extends B, C {
//     public static void main(String[] args) {
//         D obj = new D();
//         obj.display();
//     }
// }




// The above code will result in a compile-time error because the class D inherits the display() method from both B and C, which in turn inherit it from A.
// This results in ambiguity as to which display() method to call when obj.display() is called.


