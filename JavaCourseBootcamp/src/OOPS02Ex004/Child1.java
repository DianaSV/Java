package OOPS02Ex004;

public class Child1 extends Family{

    //Properties
    String firstName;


    public Child1(String familyName, String firstName){
        super(familyName);
        this.firstName = firstName;
    }
    public void printData(){
        System.out.println(this.familyName + " " + this.firstName);
    }

}
