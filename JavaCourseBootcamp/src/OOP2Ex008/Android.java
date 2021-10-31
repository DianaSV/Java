package OOP2Ex008;



public class Android extends Mobile{
    String osVersion;
    int price;

    public Android(String osVersion, int price){
        this.osVersion = osVersion;
        this.price = price;
    }

    public void callPrint(){
        System.out.println("Version is: " + osVersion + ", price is: " + price);
        Details();
    }
}
