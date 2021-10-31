package OOP2Ex008;

public class iOS extends Mobile{
    String osVersion;
    int price;

    public iOS(String osVersion, int price){
        this.osVersion = osVersion;
        this.price = price;
    }

    public void callPrint(){
        System.out.println(osVersion + " " + price);
        Details();
    }
}
