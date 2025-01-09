interface IntStack {
    void push(int item); // Abstract push method to be implemented by subclasses
    int pop(); // Pop method to be shared by subclasses
}

// Abstract class to enforce code reuse
abstract class AbstractStack implements IntStack {
    protected int[] stack; // Shared stack array
    protected int tos; // Top of stack indicator

    AbstractStack(int size) {
        stack = new int[size];
        tos = -1;
    }
    public int pop() {
        if (tos < 0) {
            System.out.println("Stack is empty.");
            return 0;
        } else {
            return stack[tos--];
        }
    }
}

// Fixed-size stack implementation
class FixedStack extends AbstractStack {
    FixedStack(int size) {
        super(size);
    }
    public void push(int item) {
        if (tos == stack.length - 1) {
            System.out.println("Stack is full.");
        } else {
            stack[++tos] = item;
        }
    }
}

// Dynamic (growable) stack implementation
class DynStack extends AbstractStack {
    DynStack(int size) {
        super(size);
    }
    public void push(int item) {
        // If the stack is full, allocate a larger stack
        if (tos == stack.length - 1) {
            int[] temp = new int[stack.length * 2];
            System.arraycopy(stack, 0, temp, 0, stack.length);
            stack = temp;
        }
        stack[++tos] = item;
    }
}

// Test class
public class UpdateCode {
    public static void main(String[] args) {
        IntStack mystack1 = new FixedStack(5);
        IntStack mystack2 = new DynStack(5);

        // Push some numbers onto the stack
        for (int i = 0; i < 5; i++) mystack1.push(i);
        for (int i = 0; i < 10; i++) mystack2.push(i);

        // Pop numbers off the stack
        System.out.println("Stack in mystack1:");
        for (int i = 0; i < 5; i++) System.out.println(mystack1.pop());

        System.out.println("Stack in mystack2:");
        for (int i = 0; i < 8; i++) System.out.println(mystack2.pop());
    }
}

