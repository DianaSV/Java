package FinalExercises;

public class FinalFunctions {

    // Ex 1
    public int reverseNumber(int num){
        int temp = 0;

        while(num != 0)
        {
            int remainder = num % 10;
            temp = temp * 10 + remainder;
            num = num/10;
        }
        return temp;
    }

    // Ex 2
    public double reverseDoubleNumber(double num){
        String str = num + "";
        String[] newNum = str.split("[.]");

        return Double.valueOf(newNum[1] + "." + newNum[0]);
    }

    // Ex 3
    public void printBetween1and10AfterDuplicate(int[] arr){
        for(int i=0; i<arr.length; i++)
            if(arr[i] >= 1 && arr[i] <= 10)
                System.out.print(arr[i] * 2 + " ");
        System.out.println();
    }

    // Ex 4
    public void printAVG(int[] arr){
        int sum = 0;

        for(int i=0; i<arr.length; i++)
                sum += arr[i];

        System.out.println("Sum is: " + sum);
    }

    // Ex 5

}

