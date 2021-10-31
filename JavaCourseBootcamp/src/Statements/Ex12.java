package Statements;

public class Ex12 {
    public static void main(String[] args) {
        int num = 27;
        boolean isPrime = true;

        for(int i= 2; i<num/2; i++)
            if(num % i == 0){
                isPrime = false;
                break;
            }
        if(isPrime)
            System.out.println("Prime number");
        else
            System.out.println("Not a prime number");
    }
}
