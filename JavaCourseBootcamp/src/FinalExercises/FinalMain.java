package FinalExercises;

public class FinalMain {
    public static void main(String[] args) {

        FinalFunctions Ex = new FinalFunctions();
        int[] arr = {4, 21, 5, -3};

        // Ex 1
        System.out.println(Ex.reverseNumber(12345));
        // Ex 2
        System.out.print("The reverse number of " + 123.45 + " is: ");
        System.out.println(Ex.reverseDoubleNumber(123.45));
        // Ex 3
        Ex.printBetween1and10AfterDuplicate(arr);
        // Ex 4
        Ex.printAVG(arr);

    }
}
