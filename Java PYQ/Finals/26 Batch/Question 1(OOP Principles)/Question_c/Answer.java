
// (c) The following is a typical implementation of stack data structure written in procedural language (C in this case):


// void push (int st[], int tos, int num) {
//      st[tos] = num;
// }

// int pop(int st[], int tos){

//     return st[tos];

// }

// main() {

//    int stack[5];
//    int tos=0;
//    push (stack, tos, 45);
//    tos++;
//    push(stack, tos, 4);
//    tos++;
//    tos--;
//    int item = pop (stack, tos); 
//    printf("%d", item);
//    tos--;
//    int item = pop (stack, tos);
//    printf("%d", item);

// }

// Rewrite the above code in Java so that the OOP principles are enforced as much as
// possible.

// Answer:


class Stack {
    private int[] stack;
    private int tos;

    Stack(int size) {
        stack = new int[size];
        tos = 0;
    }

    void push(int num) {
        stack[tos] = num;
        tos++;
    }

    int pop() {
        tos--;
        return stack[tos];
    }
}

public class Answer {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(45);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}   

