package RowanExercises;

public class HighestDivide {
    public static void main(String[] args) {

        int num1 = 18, num2 = 6, temp=1, highestNumber;

        if(num1 > num2)
            highestNumber = num1;
        else
            highestNumber = num2;

        for(int i=1; i <=highestNumber; i++)
            if(num1 % i == 0 && num2 % i == 0)
                temp = i;

        System.out.println(temp);
    }
}
