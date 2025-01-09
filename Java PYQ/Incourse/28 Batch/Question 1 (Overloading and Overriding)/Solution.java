
class Parent{
    int x;
    void func1(){
        System.out.println("Called HERE 0");
    }
   // Overloading
    void func1(int x){
        System.out.println("Called HERE 1");
    }
   // Overloading
    void func1(int x, int y){
        System.out.println("Called HERE 2");
    }
}

class Child extends Parent{
    
    // Overriding
    void func1(int u, int v){
        x = u;
        System.out.println("Called HERE 3");
    }
}

public class Solution {
    public static void main(String[] args) {
        Child c = new Child();
        c.func1(); // Calls Parent's func1
        c.func1(10); // Calls Parent's func1 Overloading
        c.func1(10, 20); // Calls Child's func1 Overriding
        c.func1(10, 20); // Calls Child's func1 Overriding
    }
}