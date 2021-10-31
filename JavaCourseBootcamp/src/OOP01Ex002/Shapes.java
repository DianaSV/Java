package OOP01Ex002;

public class Shapes {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Rectangle rect1 = new Rectangle();
        Triangle tri = new Triangle();

        circle1.radius = 3;
        circle1.pi = 4;
        rect1.width= 34;
        rect1.height = 2;
        tri.height = 3;
        tri.width = 1;

        circle1.printArea();
        rect1.printArea();
        tri.printArea();
    }
}
