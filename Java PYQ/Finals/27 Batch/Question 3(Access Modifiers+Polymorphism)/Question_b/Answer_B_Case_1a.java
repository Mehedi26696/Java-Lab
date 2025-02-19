
interface MyInterface {
    void display();  // Same method signature as in Superclass
}

class SuperClass {
    public void display() {  // Inherited by SubClass
        System.out.println("SuperClass display method");
    }
}

class SubClass extends SuperClass implements MyInterface {
    // No need to override display() because it is already inherited from SuperClass
}

public class  Answer_B_Case_1a {
    public static void main(String[] args) {
        SubClass obj = new SubClass();
        obj.display();  // Calls inherited method from SuperClass
    }
}
