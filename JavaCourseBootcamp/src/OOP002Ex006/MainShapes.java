package OOP002Ex006;

public class MainShapes {
    public static void main(String[] args) {
        Circle circ = new Circle();
        Square squar = new Square();

        System.out.println(circ.getArea(3));
        System.out.println(squar.getArea(4));

        circ.printShapeDefinition();
        squar.printShapeDefinition();
    }
}
