interface MyInterface {
    void display(String message);  // Different parameter type
}

class SuperClass {
    public void display() {  // Inherited method
        System.out.println("SuperClass display method");
    }
}

class SubClass extends SuperClass implements MyInterface {
    // Must implement the display(String) method separately
    public void display(String message) {
        System.out.println("Interface method: " + message);
    }
}

public class Answer_B_Case_2 {
    public static void main(String[] args) {
        SubClass obj = new SubClass();
        obj.display();  // Calls SuperClass method
        obj.display("Hello Interface!");  // Calls Interface method
    }
}
