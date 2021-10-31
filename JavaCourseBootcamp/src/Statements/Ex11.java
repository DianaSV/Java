package Statements;

public class Ex11 {
    public static void main(String[] args) {
        int[] arr = {15, 2, 36, 20, 7};
        int temp = arr[0], sum = arr[0];
        if(arr[0] > arr[1])
            if(arr[0]>arr[2])
                System.out.println(arr[0]);
            else
                System.out.println(arr[2]);
        else if(arr[1] > arr[2])
                System.out.println(arr[1]);
            else
                System.out.println(arr[2]);

            for(int i=1; i<arr.length; i++){
                if(arr[i]>temp)
                    temp = arr[i];
                sum += arr[i];
            }
        System.out.println(temp + " AVG: " + sum );

    }
}
