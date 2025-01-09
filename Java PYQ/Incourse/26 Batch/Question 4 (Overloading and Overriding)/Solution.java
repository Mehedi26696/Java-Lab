
class Myclass{
      public void method_1(int i){
            System.out.println("public void method_1() in Myclass");
      }

      public static void method_2(int i){
            System.out.println("public static void method_2() in Myclass");
      }
      public static void method_3(int i){
            System.out.println("public static void method_2() in Myclass");
      }

}

class YourClass extends Myclass{
      // Overriding method_1
      public void method_1(int i){
            System.out.println("public void method_1() in YourClass");
      }
      public static void method_2(int i){
            System.out.println("public static void method_2() in YourClass");
      }
      public static void method_3(int i){
            System.out.println("public static void method_2() in YourClass");
      }
}
public class Solution {
    public static void main(String[] args) {
            Myclass obj = new YourClass();
            obj.method_1(1);

            Myclass.method_2(2);
            Myclass.method_3(3);

            YourClass.method_2(4);
            YourClass.method_3(5);
            
            // we can't override static method 
    }
}

//Briefly explain, for each of the three methods, whether overriding occurs or not and why.

// method_1: Overriding occurs because it is an instance method and the subclass has the same method signature.
// method_2: Overriding does not occur because it is a static method.
// method_3: Overriding does not occur because it is a static method.