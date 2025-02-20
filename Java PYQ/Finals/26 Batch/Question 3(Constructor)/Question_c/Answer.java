

// (c) The same class may create different objects in different ways and under different conditions. OOP languages allow different 
//     constructors in a class to create different objects of the same class. Differentiate between the default constructor and explicit constructor of a class. 
//     What happens to the default constructor in Java if we write an explicit constructor in a class?

// Answer:

// Default Constructor:
// 1. A default constructor is a constructor that is automatically created by the compiler if no constructor is defined in the class.
// 2. The default constructor is used to provide the default values to the objects. 

// Explicit Constructor:
// 1. An explicit constructor is a constructor that is defined by the programmer in the class.
// 2. The explicit constructor is used to provide the values to the objects as per the requirement of the programmer.

// If we write an explicit constructor in a class, then the default constructor is not created by the compiler.

// Example:


class school{

    String name;
    String location;

    // Default Constructor

    // school(){
    //     name = "ABC School";
    //     location = "XYZ";
    // }

    // Explicit Constructor

    // school(String n, String l){
    //     name = n;
    //     location = l;
    // }

    void display(){
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
    }
}


public class Answer{
    public static void main(String[] args) {
        school s1 = new school();
       // school s2 = new school("PQR School", "LMN");

        s1.display();
        //s2.display();
    }
}

