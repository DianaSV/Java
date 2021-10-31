package FinalExercises;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.ArrayList;

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
    public void printCalcResult(char[] toCalculate){

        switch (toCalculate[1]){
            case '+':
                System.out.println(Character.getNumericValue(toCalculate[0]) + Character.getNumericValue(toCalculate[2]));
                break;
            case '-':
                System.out.println(Character.getNumericValue(toCalculate[0]) - Character.getNumericValue(toCalculate[2]));
                break;
            case '/':
                if(Character.getNumericValue(toCalculate[2]) == 0){
                    System.out.println("Cannot divide by 0.");
                    break;
                }
                System.out.println(Character.getNumericValue(toCalculate[0]) / Double.valueOf(Character.getNumericValue(toCalculate[2])));
                break;
            case '*':
                System.out.println(Character.getNumericValue(toCalculate[0]) * Character.getNumericValue(toCalculate[2]));
                break;
        }

    }

    // Ex 6
    public void newListEvenandDevidedBy4(int[] nums){
        ArrayList newArr = new ArrayList();

        for(int i = 0; i<nums.length; i++){
            if(nums[i] % 2 == 0 && nums[i] % 4 == 0)
                newArr.add(nums[i]);
        }
        System.out.println("The even numbers and can be divided by 4 are: " + newArr);
    }

    // Ex 7
    public void getMedian(int[] nums){
        if (nums.length % 2 == 1)
            System.out.println("The median of the array is: " + nums[nums.length / 2 ]);
        else
            System.out.println("The median of the array is: " + (nums[nums.length / 2 - 1] + nums[nums.length / 2 ]) / 2);
    }

    // Ex 8
    public void printSongWordsRandomized(String song){
        String[] songWords = song.split(" ");
        int randomNum = ThreadLocalRandom.current().nextInt(0, songWords.length);

        for(int i=0; i<songWords.length; i++){
            System.out.print(songWords[randomNum] + " ");
            randomNum = ThreadLocalRandom.current().nextInt(0, songWords.length);
        }
    }

    // Ex 9
    public String getLongestString(String[] words){
        String longestStr = "";

        for(int i=0; i< words.length; i++){
            if(words[i].length() > longestStr.length())
                longestStr = words[i];
        }
        return longestStr;
    }

    public ArrayList getStringsThatContainASmallerString(String[] words, String strToSearch){

        ArrayList wordsThatContainTheStr = new ArrayList();

        for(int i = 0; i< words.length; i++){
            if(words[i].contains(strToSearch))
                wordsThatContainTheStr.add(words[i]);
        }
        return wordsThatContainTheStr;
    }

    // Ex 10
    public void getNameAndGrade(String[][] nameGrade){
        int maxGrade = 0, indexOfMax = 0;
        for (int i= 0; i< nameGrade[1].length; i++){
            if(Integer.valueOf(nameGrade[0][i]) > maxGrade) {
                maxGrade = Integer.valueOf(nameGrade[0][i]);
                indexOfMax = i;
            }
        }
        if(maxGrade == 0)
            System.out.println("No data");
        else
            System.out.println(nameGrade[1][indexOfMax] + " " + nameGrade[0][indexOfMax]);
    }
}

