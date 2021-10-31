package Statements;

public class Ex04 {
    public static void main(String[] args) {
        String[] arr = {"Austria", "Germany", "Canada", "Peru", "Israel"};

        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i] + " ");

        for(int i = 0; i < arr.length ; i++)
            if(arr[i].equals("Israel"))
                System.out.println(arr[i] + " ");
    }
}

