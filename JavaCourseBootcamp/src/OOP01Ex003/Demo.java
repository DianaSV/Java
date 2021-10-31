package OOP01Ex003;

public class Demo {

    public int lowestNumber(int[] arr){
        int minNum = arr[0];
        for(int i=1; i<arr.length; i++)
            if(arr[i] < minNum)
                minNum = arr[i];

        return minNum;
    }

    public int highestNumber(int[] arr){
        int maxNum = arr[0];
        for(int i=1; i<arr.length; i++)
            if(arr[i] > maxNum)
                maxNum = arr[i];

        return maxNum;
    }

    public double avgOfNumbers(int[] arr){
        double avg = arr[0];
        for(int i=1; i<arr.length; i++)
            avg += arr[i];

        return avg / arr.length;
    }

    public void handleNumbers(int[] arr){
        System.out.print(lowestNumber(arr) + " ");
        System.out.print(highestNumber(arr) + " ");
        System.out.print(avgOfNumbers(arr) + " ");
    }
}
