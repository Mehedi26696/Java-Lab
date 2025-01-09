
// Explain 4 principles of OOP with example

// 1. Encapsulation
// Encapsulation is the mechanism that binds together code and the data it manipulates, and keeps both safe from outside interference and misuse.
// One way to think about encapsulation is as a protective wrapper that prevents code and data from being arbitrarily accessed by other code defined outside the wrapper.

// Example:
// class EncapsulationExample {
//     private int number;
//     private String name;
//    private boolean isTrue;
//     public void setNumber(int number) {
//         this.number = number;
//     }
//     public int getNumber() {
//         return number;
//     }
//     public void setName(String name) {
//         this.name = name;
//     }
//     public String getName() {
//         return name;
//     }
//     public void setIsTrue(boolean isTrue) {
//         this.isTrue = isTrue;
//     }
//     public boolean getIsTrue() {
//         return isTrue;
//     }
// }

// In the above example, the EncapsulationExample class has three private fields: number, name, and isTrue.






// 2. Inheritance
// Inheritance is a mechanism in which one class acquires the properties and behavior of another class. It represents the IS-A relationship which is also known as a parent-child relationship.

// Example:
// class Animal {
//     void eat() {
//         System.out.println("eating...");
//     }
// }
// class Dog extends Animal {
//     void bark() {
//         System.out.println("barking...");
//     }
// }

// In the above example, the Dog class inherits the eat() method from the Animal class. The Dog class can also have its own methods and properties in addition to the inherited ones.




// 3. Polymorphism
// Polymorphism is the ability of a single function or method to operate on multiple data types. It allows methods to do different things based on the object that it is acting upon.
// There are two types of polymorphism in Java: compile-time polymorphism and runtime polymorphism.
// Compile-time polymorphism is method overloading.
// Runtime polymorphism is method overriding.

// Example:
// class Animal {
//     void sound() {
//         System.out.println("Animal is making a sound");
//     }
//     void sound(String sound) {
//         System.out.println("Animal is making a sound: " + sound);
//     }
// }
// class Dog extends Animal {
//     void sound() {
//         System.out.println("Dog is barking");
//     }
//     void sound(String sound) {
//         System.out.println("Dog is barking: " + sound);
//     }
// }

// In the above example, the Animal class has two sound() methods, one without any parameters and one with a parameter. 
//The Dog class extends the Animal class and overrides both sound() methods.






// 4. Abstraction
// Abstraction is a process of hiding the implementation details and showing only functionality to the user.
// In Java, abstraction is achieved using abstract classes and interfaces.

// Example:
// abstract class Animal {
//     abstract void sound();
// }
// class Dog extends Animal {
//     void sound() {
//         System.out.println("Dog is barking");
//     }
// }

// In the above example, Animal is an abstract class with an abstract method sound(). Dog is a subclass of Animal and it provides an implementation for the sound() method. 
//The user does not need to know how the sound() method is implemented in the Dog class, they only need to know that the Dog class can make a sound.


