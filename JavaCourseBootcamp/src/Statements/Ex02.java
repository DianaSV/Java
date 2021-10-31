package Statements;

public class Ex02 {
    public static void main(String[] args) {
        int[] arr = {8, 5, 9};

        if(arr[0] > arr[1])
            System.out.println("First one is bigger.");
        else if (arr[0] < arr[1])
            System.out.println("Second one is bigger");
        else
            System.out.println("Both are equal");
    }
}
