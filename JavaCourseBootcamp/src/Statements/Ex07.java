package Statements;

public class Ex07 {
    public static void main(String[] args) {
        String[][] arr = {{"Moshe", "22", "Jerusalem"},
                            {"Joseph", "45", "London"}};

        for(int i=0; i< arr.length; i++)
            for(int j = 0; j < arr[i].length; j++)
                System.out.println(arr[i][j]);
    }
}
