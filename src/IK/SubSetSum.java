package IK;

import java.util.ArrayList;

/*
Given a set of integers and a target value k, find a non-empty subset that sums up to k.



Example One

Input: [2 4 8], k = 6

Output: True

Because 2+4=6.



Example Two

Input: [2 4 6], k = 5

Output: False

Because no subset of numbers from the input sums up to 5.



Notes

Input Parameters: Function has two arguments: an array of integers (their order doesn’t matter) and the target value  k.



Output: Function must return a boolean value.



Constraints:

1 <= size of the input array <= 18
-10^12 <= elements of the array, k <= 10^12
 */
public class SubSetSum {

    /*
     * Complete the function below.
     */
    static boolean check_if_sum_possible(long[] arr, long k) {

        return helper(arr, 0, k, new ArrayList<Long>());

    }

    static boolean helper(long[] arr, int s, long k, ArrayList<Long> p) {
        if(s == arr.length){
            long sum = findSum(p);
            return sum == k;
        }

        // recursion
        // exclude
        boolean res1 = helper(arr, s + 1, k, p);

        // include
        p.add(arr[s]);
        boolean res2 = helper(arr,s + 1, k, p);
        p.remove(p.size()-1);
        return res1 || res2;
    }

    static long findSum(ArrayList<Long> p){
        long s = 0;
        for(long l : p){
            s += l;
        }
        return s;
    }

    public static void main(String[] args) {
        long[] arr = {2,4,6};

        long k = 6;
        System.out.println(check_if_sum_possible(arr, k));
        System.out.println(check_if_sum_possible(arr, 5));

    }
}
