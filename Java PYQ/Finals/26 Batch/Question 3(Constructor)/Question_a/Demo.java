
// (a) Consider the following code. Rewrite the code using inheritance and the keyword super. You must write optimal code in terms of OOP principles. 
// You should not use more classes than A, B, C and Demo.

// class C {

//     int a, b, c;

//     C(int a, int b, int c) {

//     this.a=a; 
//     this.b=b; 
//     this.c=c;
//    }
// }

// class B {

//     int a, b, c, d, e;

//    B(int a, int b, int c, int d, int e) {

//    this.a=a; 
//    this.b=b; 
//    this.c=c; 
//    this.d=d; 
//    this.e=e;
//    }
// }

// class A {

//     int a, b, c, d, e, f;

//    A(int a, int b, int c, int d, int e, int f) {

//      this.a=a; 
//      this.b=b; 
//      this.c=c;
//      this.d= d; 
//      this.e=e; 
//      this.f=f;
//    }
// }

// class Demo {
//     public static void main(String[] args) {

//         A a = new A(3, 4, 5, 6, 7, 8);
//         B b = new B(2, 1, 2, 3, 4);
//         C C = new C(4, 5, 2);
//     }
// }

// Answer

class C {
    int a;
    int b;
    int c;

    C(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

class B extends C {
    int d;
    int e;

    B(int a, int b, int c, int d, int e) {
        super(a, b, c);
        this.d = d;
        this.e = e;
    }
}

class A extends B {
    int f;

    A(int a, int b, int c, int d, int e, int f) {
        super(a, b, c, d, e);
        this.f = f;
    }
}

class Demo{
    public static void main(String[] args) {
        A a = new A(3, 4, 5, 6, 7, 8);
        B b = new B(2, 1, 2, 3, 4);
        C c = new C(4, 5, 2);
    }
}
