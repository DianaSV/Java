package Statements;

public class Ex03 {
    public static void main(String[] args) {

        int i;

        for(i = 1; i<=10; i++)
            System.out.print(i + " ");
        System.out.println();

        i=1;
        while(i <= 10){
            System.out.print(i + " ");
            i++;
        }
        System.out.println();

        for(i = 30; i <= 50; i++)
            if(i % 2 == 0)
                System.out.print(i + " ");
        System.out.println();

        for(i = 20; i <= 40; i++)
            if(i % 2 == 1)
                System.out.print(i + " ");
    }
}
