package Exceptions;

public class Ex01 {
    public static void main(String[] args) {
        int[] arr = {4, 0};

        try{
            System.out.println(arr[4]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: " + e);
        }
    }
}
