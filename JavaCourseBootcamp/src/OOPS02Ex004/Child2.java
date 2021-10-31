package OOPS02Ex004;

public class Child2 extends Family{

    //Properties
    String siblingName;

    public Child2(String familyName, String siblingName){
        super(familyName);
        this.siblingName = siblingName;
    }

    public void printData(){
        System.out.println(this.familyName + " " + this.siblingName);
    }
}
