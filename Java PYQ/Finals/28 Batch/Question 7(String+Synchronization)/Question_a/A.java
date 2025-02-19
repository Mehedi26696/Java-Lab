
// (a) You are given a string S. You need to implement the following functions by incorporating them within a class to manipulate S based on Java-supported syntax.
//     i.void putFront(char a): Will put a character a at the beginning of S
//     ii.void putBehind(char a): Will put a character a at the end of the S 
//     ii.void pop(int idx): Will remove the character from the Idx position of S

import java.util.Scanner;

class manipulateString {
    String s;

    manipulateString(String s) {
        this.s = s;
    }

    void putFront(char a) {
        s = a + s;
    }

    void putBehind(char a) {
        s = s + a;
    }

    void pop(int idx) {

        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (i != idx) {
                temp += s.charAt(i);
            } else {
                continue;
            }
        }
        s = temp;
    }
}

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String s = sc.next();

        manipulateString obj = new manipulateString(s);

        System.out.println("Enter a character to put at the front: ");

        char a = sc.next().charAt(0);
        obj.putFront(a);

        System.out.println("New string: ");

        System.out.println(obj.s);

        System.out.println("Enter a character to put at the end: ");

        char b = sc.next().charAt(0);
        obj.putBehind(b);

        System.out.println("New string: ");

        System.out.println(obj.s);

        System.out.println("Enter the index to remove the character: ");

        int idx = sc.nextInt();
        obj.pop(idx);

        System.out.println("New string: ");

        System.out.println(obj.s);
        sc.close();
    }
}