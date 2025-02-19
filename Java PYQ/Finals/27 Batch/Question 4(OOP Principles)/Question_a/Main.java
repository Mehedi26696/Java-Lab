
// (a)Consider the following facts:

//           Humans breath, eat, move(walk), talk 
//           Birds breath, eat, move(fly), chirp 
//           Fishes breath, eat, move(swim)
//           Dogs breath, eat, move(run), bark
//    Design the class/interface hierarchy and then write Java code that reflects the OOP principles.

//    Hint: You may create separate classes/interfaces for humans, birds, fishes, dogs, and possibly some more as per your needs. The actions of an animal may be represented by a 
//    single-statement method, for example, to implement human's breathing action, you may write the statement:

//     System.out.println("Breathing...");
//     or
//     System.out.println("Human is breathing...") ;

// In your code, you should practice OOP principles as much as possible.



import java.util.Scanner;

interface Animal {
    void eat();
    void move();
    void breath();
    
}

class Moving{
    String m;
    Moving(String m){
        this.m = m;
    }
}
class Human extends Moving implements Animal {
    Human(){
        super("walk");
    }
    public void eat() {
        System.out.println("Human is eating...");
    }

    public void move() {
        System.out.println("Human is moving by " + m+"ing");
    }

    public void breath() {
        System.out.println("Human is breathing...");
    }

    public void talk() {
        System.out.println("Human is talking...");
    }
}

class Bird extends Moving implements Animal {
    Bird(){
        super("fly");
    }
    public void eat() {
        System.out.println("Bird is eating...");
    }

    public void move() {
        System.out.println("Bird is moving by " + m+"ing");
    }

    public void breath() {
        System.out.println("Bird is breathing...");
    }

    public void chirp() {
        System.out.println("Bird is chirping...");
    }   
}

class Fish implements Animal {
    public void eat() {
        System.out.println("Fish is eating...");
    }

    public void move() {
        System.out.println("Fish is swimming...");
    }

    public void breath() {
        System.out.println("Fish is breathing...");
    }
}

class Dog  extends Moving implements Animal {
    Dog(){
        super("run");
    }
    public void eat() {
        System.out.println("Dog is eating...");
    }

    public void move() {
        System.out.println("Dog is moving by " + m+"ing");
    }

    public void breath() {
        System.out.println("Dog is breathing...");
    }

    public void bark() {
        System.out.println("Dog is barking...");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the type of animal: ");
        String type = sc.next();
        if(type.equals("Human")){
            Human h = new Human();
            h.eat();
            h.move();
            h.breath();
            h.talk();
        }
        else if(type.equals("Bird")){
            Bird b = new Bird();
            b.eat();
            b.move();
            b.breath();
            b.chirp();
        }
        else if(type.equals("Fish")){
            Fish f = new Fish();
            f.eat();
            f.move();
            f.breath();
        }
        else if(type.equals("Dog")){
            Dog d = new Dog();
            d.eat();
            d.move();
            d.breath();
            d.bark();
        }
        else{
            System.out.println("Invalid input");
        }

        sc.close();
    }
}