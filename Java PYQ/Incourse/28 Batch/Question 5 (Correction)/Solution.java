
//public abstract class TestClass {  // This is wrong because we can't have public abstract class in a file with name Solution.java 
abstract class TestClass {
    int x; // This is default access modifier
    // private int varY; // This is wrong
    int varY;
    // static void test() {
    //     System.out.println("Going to print " + x);
    // }
    void test() {
        System.out.println("Going to print " + x);
    }
    abstract void funnyMethod();
}

class ChildClass extends TestClass {
    // this is wrong
    // void newfunnyMethod() {
    // System.out.println("implemented new funny method");
    // }

    // correct way
    void funnyMethod() {
        System.out.println("implemented new funny method");
    }
}

public class Solution {
    public static void main(String[] args) {
        // TestClass t = new TestClass(); // This is wrong
        TestClass t = new ChildClass();
        t.varY = 70;
        TestClass arr[] = new TestClass[10];
        // this have to write to create object ather wise it will give null pointer exception
        // for (int i = 0; i < 10; i++) {
        //     arr[i] = new ChildClass();
        // }
        for (int i = 0; i < 10; i++) {
            arr[i].x = i*70; // This is wrong because we are trying to access static variable using object reference
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i].x);
            
        }

    }
}