
// What are the ways to desstroy object in java....i.e. release memory of an Object?

// Nullifying the reference: 
// Reassigning the reference:

class Test {

    int x;
    int y;

    Test() {
        x = 10;
        y = 20;
    }

    // finalize method is called on object once
    public void finalize() {
        System.out.println("Object is garbage collected");
    }
}

public class Solution {
    public static void main(String[] args) {

        // Nullifying the reference:

        Test t = new Test();
        System.out.println(t.x);
        System.out.println(t.y);
        t = null;
        System.gc();

        // System.out.println(t.x);
        // System.out.println(t.y);

        // Reassigning the reference:

        Test t1 = new Test();
        System.out.println(t1.x);
        System.out.println(t1.y);
        t1 = new Test();
        System.gc();

        System.out.println(t1.x);
        System.out.println(t1.y);

    }
}
