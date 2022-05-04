package IK;

import java.util.Arrays;

/**
 *
 Given two arrays:

 1) arr1 of size n, which contains n positive integers sorted in the ascending order.

 2) arr2 of size (2*n) (twice the size of first), which contains n positive integers sorted in the ascending order in its first half. Second half of this array arr2 is empty. (Empty elements are marked by 0).

 Write a function that takes these two arrays, and merges the first one into second one, resulting in an increasingly sorted array of (2*n) positive integers.

 Example

 Input:

 n = 3

 arr1 = [1 3 5]

 arr2 = [2 4 6 0 0 0]

 Output: arr2 = [1 2 3 4 5 6]

 Notes

 Input Parameters: There are two arguments. First one is an integer array denoting arr1 and second one is also an integer array denoting arr2.

 Output: You don't have to return anything. You just need to modify the given array arr2.

 Constraints:

 1 <= n <= 10^5
 1 <= arr1[i] <= 2 * 10^9
 1 <= arr2[i] <= 2 * 10^9 (for the first half)
 arr2[i] = 0 (for the second half)
 You can use only constant extra space.
 0 denotes an empty space.
 */
public class MergeOneSortedArrayIntoAnother {

    /*
     * Complete the merger_first_into_second function below.
     */
    static int[] merger_first_into_second(int[] arr1, int[] arr2) {
        /*
         * Write your code here.
         *
         *   arr1 = [1 3 5]
                         a
             arr2 = [1 2 3 4 5 6]
                                i
         */


        int a = 0;
        int i = 0;
        while( i < arr2.length && a < arr1.length && arr2[i] != 0){
            if(arr1[a] <= arr2[i]) {
                // create the hole
                for(int j = arr2.length - 1; j > i; j--) {
                    arr2[j] = arr2[j-1];
                }
                // insert the arr1 element
                arr2[i] = arr1[a];
                // increment a
                a++;
            }
            i++;
        }
        System.out.println(a);
        System.out.println(i);

        System.out.println(Arrays.toString(arr2));
        while(a < arr1.length){
            arr2[i++] = arr1[a++];
        }
        return arr2;
    }


    public static void main(String[] args) {
        int[] arr1 = {11, 14, 24, 34, 44, 45, 45, 47, 61, 64, 72, 82, 103, 104, 122, 122, 131, 138, 145, 148, 150, 151, 185, 198};
        int[] arr2 = {6, 9, 17, 19, 28, 33, 35, 36, 64, 76, 87, 89, 107, 110, 112, 121, 129, 132, 139, 146, 151, 152, 154, 175, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        int[] r = merger_first_into_second(arr1, arr2);
        System.out.println(Arrays.toString(r));
    }
}
