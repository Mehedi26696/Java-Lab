

// Anonymous class is a class without a name. It is used to create an object of a class that implements an interface or extends an abstract class. 
// It is defined and instantiated in a single step. It is used when you need to use a class only once. It is used to override a method of a class or an interface. 
// It is used to create a class that should be used only once. It is used to create a class that should be used only once.


abstract class Greeting {
    abstract void sayHello();
}

public class Answer_I {
    public static void main(String[] args) {
        Greeting obj = new Greeting() {  // Anonymous class
            @Override
            void sayHello() {
                System.out.println("Hello from Anonymous Class!");
            }
        };
        obj.sayHello();
    }
}
