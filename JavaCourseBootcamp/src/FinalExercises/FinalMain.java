package FinalExercises;

public class FinalMain {
    public static void main(String[] args) {

        FinalFunctions Ex = new FinalFunctions();
        int[] arr = {4, 21, 5, -3, 16, 2};
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
        Ex.printBetween1and10AfterDuplicate(arr);
        // Ex 4
        Ex.printAVG(arr);
        // Ex 5
        Ex.printCalcResult(toCalculate);
        //Ex 6
        Ex.newListEvenandDevidedBy4(arr);
        // Ex 7
        Ex.getMedian(arr);
        // Ex 8 - After some reading I got to a conclusion seed wise, ThreadLocalRandom is better to use then Random
        Ex.printSongWordsRandomized(song);
        System.out.println();
        // Ex 9
        System.out.println("Longest string is: " + Ex.getLongestString(listOfWords));
        System.out.println("String that contain the desirable string is: " + Ex.getStringsThatContainASmallerString(listOfWords, "CK"));
        // Ex 10
        Ex.getNameAndGrade(namesGrades);
    }
}
