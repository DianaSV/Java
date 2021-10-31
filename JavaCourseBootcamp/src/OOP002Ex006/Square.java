package OOP002Ex006;

public class Square extends Shape{

    double getArea(double side){
        return side * side;
    }

    double getPerimeter(double side){
        return side * 4;
    }
}
