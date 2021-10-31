package FinalExercises;

public class FinalMain {
    public static void main(String[] args) {

        FinalFunctions Ex = new FinalFunctions();
        int[] arrOfNumbers1 = {4, 21, 5, -3, 16, 2}, arrOfNumbers2 = {4, 21, 7, -3, 16, 2};
        char[] toCalculate = {'3', '/', '2'};
        String song = "It might seem crazy what I am 'bout to say";
        String[] listOfWords = {"ABC", "AAAAA", "BBB", "kjhdsfkjo", "JDSDFHKJH", "FGH", "LXCVKJ", "XLCKVJL",
                            "VCKJLK", "VLK;LK", "VLKL"};
        String[][] namesGrades = {{"85", "76", "45", "91", "82"},
                                    {"David", "Moshe", "Ilana", "Shlomo", "Hanna"}};

        // Ex 1
        System.out.println(Ex.reverseNumber(12345));
        // Ex 2
        System.out.print("The reverse number of " + 123.45 + " is: ");
        System.out.println(Ex.reverseDoubleNumber(123.45));
        // Ex 3
        Ex.printBetween1and10AfterDuplicate(arrOfNumbers1);
        // Ex 4
        Ex.printAVG(arrOfNumbers1);
        // Ex 5
        Ex.printCalcResult(toCalculate);
        //Ex 6
        Ex.newListEvenandDevidedBy4(arrOfNumbers1);
        // Ex 7
        Ex.getMedian(arrOfNumbers1);
        // Ex 8 - After some reading I got to a conclusion seed wise, ThreadLocalRandom is better to use then Random
        Ex.printSongWordsRandomized(song);
        System.out.println();
        // Ex 9
        System.out.println("Longest string is: " + Ex.getLongestString(listOfWords));
        System.out.println("String that contain the desirable string is: " + Ex.getStringsThatContainASmallerString(listOfWords, "CK"));
        // Ex 10
        Ex.getNameAndGrade(namesGrades);
        // Ex 11
        Ex.printSecondHighestNumber(arrOfNumbers1);
        // Ex 12
        if(Ex.compare2ArraysForEquality(arrOfNumbers1, arrOfNumbers2))
            System.out.println("The arrays are equal");
        else
            System.out.println("The arrays are NOT equal");
        // Ex 13
        int[] arrOfPositiveNumbers = {1,6,9,3,11};
        Ex.printPrimeNumbers(arrOfPositiveNumbers);
        //Ex 14
        System.out.println();
        System.out.println(Ex.numberToWords(-78));
    }
}
