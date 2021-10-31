package Lesson02;

public class Car {

    //Properties
    String manufacturer, model;
    int year;
    double price;
    boolean hasABS;

    //Constructor
    public Car(String manufacturer, String model, int year, double price, boolean hasABS){
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.price = price;
        this.hasABS = hasABS;
    }

    //Methods
    void print(){
        System.out.println(manufacturer + " " + model +' ' + year + " " + price + " " + printABS());

    }

    String printABS(){
        if(hasABS)
            return "Has ABS";
        else
            return "Doesn't have ABS";
    }
}
