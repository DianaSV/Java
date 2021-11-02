package FinalExercises;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.ArrayList;

public class FinalFunctions {

    final String[] oneDigitNumbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    final String[] teenNumbers = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    final String[] twoDigitNumbers = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    final String hundredInWord = " hundred ";

    public void selectionSortArray(int[] numbers){

        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numbers.length; j++)
                if (numbers[j] < numbers[minIndex])
                    minIndex = j;

            int temp = numbers[minIndex];
            numbers[minIndex] = numbers[i];
            numbers[i] = temp;
        }
    }

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

    // Ex 11
    public void printSecondHighestNumber(int[] numbers){
        selectionSortArray(numbers);
        System.out.println("Secong highest number is: " + numbers[1]);
    }

    // Ex 12
    public boolean compare2ArraysForEquality(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length)
            return false;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i = 0; i < arr1.length; i++)
            if(arr1[i] != arr2[i])
                return false;

        return true;
    }

    // Ex 13
    public void printPrimeNumbers(int[] arr){

        boolean isPrime = true;

        System.out.print("The prime numbers are: ");

        for(int i = 0; i < arr.length; i++) {
            for (int j = 2; j < arr[i] / 2; j++) {
                if (arr[i] % j == 0)
                    isPrime = false;
            }
            if(isPrime)
                System.out.print(arr[i] + ", ");

            isPrime = true;
        }
    }

    // Ex 14
    public String numberToWords(int num){

        String numberInWords = "";

        //Checks for special cases:
        //  number is zero \ number is negative \ number is teen number ( 10 > 19 including)
        boolean minusFlag = false;

        if(num == 0) {
            return "zero";
        }
        if(num < 0) {
            minusFlag = true;
            num = Math.abs(num);
        }
        if(num >=10 && num <20) {
            numberInWords = teenNumbers[num % 10];
            if(minusFlag)
                numberInWords = "minus " + numberInWords;
            return numberInWords;
        }

        // if the number is between 10-19 we extract accordingly
        // and divide by 100 as we dealt with both numbers at once
        if(num % 100 >= 10 && num % 100 < 20){
            numberInWords += teenNumbers[num % 10];
            num /= 10;
        }
        //the number doesn't have a special case of teen number and we need to deal with the 2 numbers separately
        else{
            if(num % 10 != 0) //if the last number is 0 we don't take into account
                numberInWords += oneDigitNumbers[num % 10];
            num /= 10;
            numberInWords = twoDigitNumbers[num % 10] + " " + numberInWords;
            num /= 10;
        }

        // deal with hundreds if we have
        if(num != 0){
            numberInWords = oneDigitNumbers[num % 10] + hundredInWord + numberInWords;
            num /= 10;
        }

        //add minus which we checked in the beginning
        if(minusFlag)
            numberInWords = "minus " + numberInWords;

        return numberInWords;
    }
}

