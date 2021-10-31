package OOP002Ex006;

public abstract class Shape {

    abstract double getArea(double length);
    abstract double getPerimeter(double length);

    public void printShapeDefinition(){
        System.out.println("A shape or figure is the form of an object or its external boundary," +
                " outline, or external surface," +
                " as opposed to other properties such as color, texture, or material type.");
    }
}
