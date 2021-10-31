package Statements;

public class Ex06 {
    public static void main(String[] args) {
        String proffesion = "Average Salary";

        switch (proffesion){
            case "QA":
                System.out.println("15,000");
                break;
            case "Bank Teller":
                System.out.println("10,000");
                break;
            case "Teacher":
                System.out.println("5,000");
                break;
            case "Average Salary":
                System.out.println("9,100");
                break;
            default:
                System.out.println("No data");
        }
    }
}
