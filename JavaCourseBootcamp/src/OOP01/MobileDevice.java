package OOP01;

public class MobileDevice {

    //Properties
    String model;
    char os;
    double version;
    boolean hasFlash;
    int price;
    int screenWidth;
    int screenHeight;

    public MobileDevice(String model, char os, double version, boolean hasFlash,
                        int price, int screenWidth,int screenHeight){
        this.model = model;
        this.os = os;
        this.version = version;
        this.hasFlash = hasFlash;
        this.price = price;

        if(screenWidth > 0)
            this.screenWidth = screenWidth;
        else
            throw new RuntimeException(("Wrong width."));

        if(screenHeight > 0)
            this.screenHeight = screenHeight;
        else
            throw new RuntimeException(("Wrong height."));
    }

    //Methods
    void printParameters(){
        System.out.println(model + " " + os + " " + version + " " + hasFlash + " " + price);
    }

    int calculateArea(){
        return screenHeight * screenWidth;
    }

    void pictureQuality(){
        if(hasFlash == true)
            System.out.println("Good Quality");
        else
            System.out.println("Bad Quality");
    }
}
