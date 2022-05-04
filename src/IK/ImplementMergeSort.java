package IK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Given a list of numbers, your task is to sort it using Merge Sort algorithm.
 *
 * Example:
 *
 * Input: [ 5, 8, 3, 9, 4, 1, 7 ]
 *
 * Output: [ 1, 3, 4, 5, 7, 8, 9 ]
 *
 * Notes:
 *
 * Constraints:
 *
 * 1 <= Length of the array <= 4*105.
 * -109 <= Any number in the array <= 109.
 */
public class ImplementMergeSort {
    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        // Write your code here.
        return mergeSort( arr);
    }

    private static ArrayList<Integer> mergeSort( ArrayList<Integer> integers) {
        if(integers.size() < 2) {
         return new ArrayList<>(integers);
        }

        int m = integers.size()/2;
        ArrayList<Integer> l = new ArrayList<>();
        l.addAll(integers.subList(0,m));

        ArrayList<Integer> r = new ArrayList<>();
        r.addAll(integers.subList(m,integers.size()));

        l = mergeSort(l);
        r = (mergeSort(r));
        ArrayList<Integer> res = new ArrayList<>();
        if(l!=null) {
            res.addAll(l);
        }
        if(r != null) {
            res.addAll(r);
        }
        Collections.sort(res);
        return res;
    }


    public static void main(String[] args) {
        Integer[] arr = {5, 8, 3, 9, 4, 1, 7}; // {2,2,2};//{1,1,1,1}; //{1,2,3,4}; //{1,2,3,4,5};
        ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(arr));
        ArrayList<Integer> res = merge_sort(al);

        for (int i :
                res) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
