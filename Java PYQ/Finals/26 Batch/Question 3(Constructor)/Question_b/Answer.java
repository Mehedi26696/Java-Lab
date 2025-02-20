

// (b) What is the difference between method overloading and method overriding? Explain with appropriate example codes in Java.

// Answer:

// Method Overloading: Method overloading is a feature that allows a class to have more than one method having the same name, 
                 //    if their argument lists are different. It is similar to constructor overloading in Java, that allows a class to have 
              //       more than one constructor having different argument lists.

// Method Overriding: Method overriding is a feature that allows a subclass to provide a specific implementation of a method that is already provided by its superclass. 
                  //  When a method in a subclass has the same name, same parameters or signature and same return type as a method in its super-class, then the method is 
                  //  said to override the method in the super-class.


class A{
    void display(){
        System.out.println("Class A");
    }

    // Method Overloading
    
    void display(int a){
        System.out.println("Class A with int");
    }

}

class B extends A{

    // Method Overriding
    void display(){
        System.out.println("Class B");
    }
    // Method Overloading
    void display(int a, int b){
        System.out.println("Class B with 2 int");
    }
}

public class Answer {
    public static void main(String[] args) {
        A obj1 = new A();
        obj1.display();
        obj1.display(5);

        B obj2 = new B();
        obj2.display();
        obj2.display(5, 6);
    }
}