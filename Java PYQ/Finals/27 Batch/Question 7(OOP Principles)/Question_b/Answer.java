

// (b) Create a Shape interface with two methods, draw and area(). Implement two classes (Rectangle and Circle) those implement the Shape class. 
//     The first method exhibits a print statement to show a certain figure is drawn, and the other method calculates the area. Each class (Rectangle and Circle) 
//     should take enough input to calculate the area for a certain shape. Your task is to design the classes based on the given scenario.


interface Shape {
    void draw();
    void area();
}

class Rectangle implements Shape {
    int length;
    int breadth;

    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void draw() {
        System.out.println("Rectangle is drawn");
    }

    public void area() {
        System.out.println("Area of Rectangle: " + length * breadth);
    }
}

class Circle implements Shape {
    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("Circle is drawn");
    }

    public void area() {
        System.out.println("Area of Circle: " + 3.14 * radius * radius);
    }
}

public class Answer {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 20);
        rectangle.draw();
        rectangle.area();

        Circle circle = new Circle(5);
        circle.draw();
        circle.area();
    }
}