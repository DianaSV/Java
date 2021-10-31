package Statements;

public class Ex05 {
    public static void main(String[] args) {
        int number = 8;

        if(number > 0 && number <= 6)
            System.out.println("Go to KinderGarten");
        else if(number > 7 && number <= 18)
            System.out.println("Go to School");
        else if(number > 19 && number <= 67)
            System.out.println("Go to Work");
        else if(number > 68 && number <= 120)
            System.out.println("Collecting Pension");
    }
}
