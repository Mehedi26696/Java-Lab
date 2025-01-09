


interface IntStack {  
    void push(int item);  
    int pop();  
}
// An implementation of IntStack that uses fixed storage.  
class FixedStack implements IntStack {  
    private int[] stack;  
    private int tos;  
    // Other members and methods
    FixedStack(int size) {
        stack = new int[size];
        tos = -1;
    }
    
    public void push(int item) {
        if (tos == stack.length - 1)
            System.out.println("Stack is full.");
        else
            stack[++tos] = item;
    } // push() ends.
    
    public int pop() {
        if (tos < 0) {
            System.out.println("Stack is empty.");
            return 0;
        } else
            return stack[tos--];
    } // pop() ends.
    } // FixedStack class ends.
    
    // An implementation of "growable" stack that uses IntStack
    class DynStack implements IntStack {
        private int[] stack;
        private int tos;
    
        DynStack(int size) {
            stack = new int[size];
            tos = -1;
        }
    
        public void push(int item) {
            // if the stack is full, allocate a larger stack
            if (tos == stack.length - 1) {
                int[] tmp = new int[stack.length * 2];
                for (int i = 0; i < stack.length; i++) tmp[i] = stack[i];
                stack = tmp;
            }
            stack[++tos] = item;
        } // push() ends.
    
        public int pop() {
            if (tos < 0) {
                System.out.println("Stack is empty.");
                return 0;
            } else
                return stack[tos--];
        } // pop() ends.
    } // DynStack class ends.
    
    public class Solution {
        public static void main(String[] args) {
            FixedStack mystack1 = new FixedStack(5);
            FixedStack mystack2 = new FixedStack(8);
    
            // push some numbers onto the stack
            for (int i = 0; i < 5; i++) mystack1.push(i);
            for (int i = 0; i < 8; i++) mystack2.push(i);
    
            // pop those numbers off the stack
            System.out.println("Stack in mystack1:");
            for (int i = 0; i < 5; i++) System.out.println(mystack1.pop());
    
            System.out.println("Stack in mystack2:");
            for (int i = 0; i < 8; i++) System.out.println(mystack2.pop());
        } // main() ends.
    } // IFTest class ends.


    // A.Draw the class hierarchy for this code. Each class should contain the names of data members and actions.

    // B.Probably you have already noticed that there is still room for code-reuse in the above code. 
    //  Modify the code so that further code reuse is enforced. In addition to the above class hierarchy,
    //  you should use only one more construct: a (concrete/abstract) class or an interface. Note that the private nature of the data should be kept unchanged.