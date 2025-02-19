
interface MyInterface {
    String display();  // Same method signature as in Superclass
}

class SuperClass {
    public void display() {  // Inherited by SubClass
        System.out.println("SuperClass display method");
    }
}

class SubClass extends SuperClass implements MyInterface {
     // Compilation Error: Cannot have conflicting return types
}

public class  Answer_B_Case_1b {
    public static void main(String[] args) {
        SubClass obj = new SubClass();
        obj.display();  // Calls inherited method from SuperClass
    }
}
