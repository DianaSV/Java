package RowanExercises;

public class doubleZero {

    /*
        Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.

Example 1:

Input: arr = [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
*/
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0)
            {
                for(int j = arr.length - 1; j > i; j--)
                    arr[j] = arr[j - 1];
                i++;
            }
        }

        for(int i=0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
