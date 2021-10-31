package Statements;

public class Ex08 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, -8, -3, 11};

        for(int i=0; i<arr.length; i++)
            if(arr[i] % 2 == 0)
                System.out.print(arr[i] + " ");
    }
}
