package RowanExercises;

public class Loops {

    public static boolean isPowerOfTwo(int num)
    {
        if (num == 0)
            return false;

        while (num != 1) {
            if (num % 2 != 0)
                return false;
            num = num / 2;
        }
        return true;
    }

    public static long Factorial(int num){

        long factorial = 1;

        for(int i = 1; i <= num; ++i)
            factorial *= i;
        return factorial;
    }

    public static boolean Mersenn(int num)
    {
        if (num == 0)
            return false;

        while (num != 1) {
            if ((num % 2)  != 0)
                return false;
            num = num / 2;
        }
        return true;
    }

    public static boolean isMersenn(int num)
    {
        if(num <= 0 || num == 1 )
            return false;

        if (num == 0)
            return false;

        while (num != 1) {
            if (num % 2 != 0)
                return false;
            num = num / 2;
        }
        return true;
    }

    public static void main(String[] args) {

//        כתבו תוכנית אשר מקבלת מערך של מספרים שלמים והשתמשו בלולאות. הניחו כי המערך גדול מ 0 וקטן מ 100.
//        המספרים נעים בין מינוס 256 עד פלוס 256.
//        הדפיסו את כל המספרים בשורה אחת.
//        הדפיסו כל מספר בשורה נפרדת
//        הדפיסו את המספרים מהסוף להתחלה.
//        הדפיסו את סכום כל המספרים עם אינדקס אי-זוגי במערך.
//        בדקו האם קיימים איברים במערך שערכם שווה לאינדקס שלהם, במידה וכן, הדפיסו את המספר, במידה ולא, הדפיסו מינוס 1.

        int[] numbers = {152, 9, 1, 3, 13, 246, 67, 10, 66, 0, 7, 6, 31};
        int sum = 0;
        boolean flag = false;

        // 1. Print all the numbers in one line
        System.out.println("Print in one line:");
        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");

        System.out.println("\n");

        // 2. Print each number in a different line
        System.out.println("Every line separately:");
        for (int i = 0; i < numbers.length; i++)
            System.out.println(numbers[i] + " ");

        // 3. Print from end of array to beginning
        System.out.println("\nFrom end to start:");
        for (int i = numbers.length - 1; i >= 0; i--)
            System.out.print(numbers[i] + " ");
        System.out.println("\n");

        // 4. Summarize the values in odd index
        for (int i = 1; i < numbers.length; i += 2)
            sum += numbers[i];
        System.out.println("Sum off odd index values: " + sum + "\n");

        // 5. Print the numbers that equal to their index, if there are none then print "-1"
        System.out.println("Numbers that are even to their index");
        for (int i = 0; i < numbers.length; i++)
            if (i == numbers[i]) {
                System.out.print(numbers[i] + " ");
                flag = true;
            }
        if (!flag)
            System.out.print("-1");

        System.out.println("\n");

//        בדקו האם קיימים איברים במערך שהינם חזקה של 2, במידה וכן, הדפיסו את המספר, במידה ולא, הדפיסו מינוס 1.
//        הדפיסו את העצרת (Factorial) של כל מספר חיובי במערך.
//        בדקו האם קיימים איברים במערך שאם נחלק את המספר בסכום הספרות שלו נקבל מספר שלם,
//        במידה וכן, הדפיסו את המספר, במידה ולא, הדפיסו מינוס 1.

        // 6. Print numbers that are power of 2, if there are none, print "-1"
        System.out.println("Numbers that are power of 2:");
        flag = false;
        for (int i = 0; i < numbers.length; i++)
            if (isPowerOfTwo(numbers[i])) {
                System.out.print(numbers[i] + " ");
                flag = true;
            }
        if (!flag)
            System.out.print("-1");

        // 7. Print factorial of all even numbers
        System.out.println("\n\nFactorial of the numbers:");
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] <= 10 && numbers[i] > 0 )
                System.out.print(Factorial(numbers[i]) + " ");


        // 8. Print the numbers that can be fully divided by the count of numbers in the number
        System.out.println("\n\nNumbers that fully divide by the number's count");
        flag = false;
        int totalNums;
        double result;
        for (int i = 0; i < numbers.length; i++) {
            totalNums = String.valueOf(Math.abs(numbers[i])).length(); //value - how long is the number
            result = numbers[i] / Double.valueOf(totalNums); // result of dividing the original number by totalNums
            if(result % 1 == 0){ //check if result(double) can be converted to full integer
                System.out.print(numbers[i] + " ");
                flag = true;
            }
        }
        if(!flag)
            System.out.println("-1");


        // 9. Convert all the numbers to binary
        System.out.println("\n\nAll the numbers in binary:");
        for (int i = 0; i < numbers.length; i++)
                System.out.print(Integer.toBinaryString(numbers[i]) + " ");


        // 10. Print Mersenne numbers, if there are none, print -1.
        System.out.println("\n\nNumbers that are Mersenne number:");
        flag = false;
        for (int i = 0; i < numbers.length; i++)
            if (isMersenn(numbers[i] + 1)) {
                System.out.print(numbers[i] + " ");
                flag = true;
            }
        if (!flag)
            System.out.print("-1");
    }
}

