package Statements;

public class Ex10 {
    public static void main(String[] args) {
        String[] arrStr = {"a", "n", "a", "i", "D"};
        int fromStart = 0, fromEnd = arrStr.length - 1;
        String temp;

        do{
            temp = arrStr[fromStart];
            arrStr[fromStart] = arrStr[fromEnd];
            arrStr[fromEnd] = temp;
            fromStart++;
            fromEnd--;
        }while(fromStart < arrStr.length/2);

        fromStart = 0;
        do{
            System.out.print(arrStr[fromStart]);
            fromStart++;
        }while(fromStart < arrStr.length);
    }



}
