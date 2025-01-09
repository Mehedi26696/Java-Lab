
class Box{
    int width;
    int height;
    int area(){
        return width * height;
    }
}
public class Solution {
    public static void main(String[] args) {
        Box mybox = new Box();
        mybox.width = 10;
        mybox.height = 20;
        System.out.println("Area of the box is: " + mybox.area());
    }
}   