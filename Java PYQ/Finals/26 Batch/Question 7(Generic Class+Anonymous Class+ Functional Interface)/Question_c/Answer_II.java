

//A functional interface is an interface that has exactly one abstract method. It is used in lambda expressions and functional programming in Java.
//It is used to provide the implementation of the method of a functional interface. It can have any number of default, static, and private methods.




@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class Answer_II {
    public static void main(String[] args) {
        MathOperation addition = (a, b) -> a + b; // Lambda expression
        System.out.println("Sum: " + addition.operate(5, 3));
    }
}
