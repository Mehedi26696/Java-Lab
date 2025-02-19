package p1;

import p2.B;
// import p2.D;

class C extends B{

   public void temp() {
          x = 11;
          y = 12;
          a = 13; 
     }
}


public class A{

      public static void main (String[] args) {

              B b = new B();
              b.a = 10;
              b.x = 20;
              b.y = 30;
              b.z = 70;
      }
}