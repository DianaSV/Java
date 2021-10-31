package RowanExercises;

public class EvenToFront {
    public static void main(String[] args) {

        /*Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
        Example 1:

        Input: nums = [3,1,2,4]
        Output: [2,4,3,1]
        Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
*/
        int[] arr = {3,1,2,4};
        int  temp;
        for(int i = 0, j = 0 ; i < arr.length; i++){
            if(arr[i] % 2 == 0){
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }

        for(int i = 0; i< arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
