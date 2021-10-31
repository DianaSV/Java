package Statements;

public class Ex09 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, -8, -3, 11, 15};

        for(int i=0; i< arr.length; i++)
            if(arr[i] % 3 == 0 && arr[i] % 5 == 0)
                System.out.println(arr[i] + " ");
    }
}
