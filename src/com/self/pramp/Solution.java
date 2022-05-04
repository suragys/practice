package com.self.pramp;

import java.io.*;
import java.util.*;

class Solution {

    static int[] findDuplicates(int[] arr1, int[] arr2) {
        // your code goes here
        Stack<Integer> dups = new Stack<>();
//        int i1 = 0;
//        int i2 = 0;
//
//        // Base case handling like null or empty array
//        // finding duplicates
//        // iterate till one of array is exhausted
//        while(i1 < arr1.length && i2 < arr2.length) {
//            System.out.println(i1 + ":" + i2);
//            // If value at indices are same add it to dups and increment both indices
//            if(arr1[i1] == arr2[i2]) {
//                dups.add(arr1[i1]);
//                i1++;
//                i2++;
//            }
//            // else if the arr1[i1] < arr2[i2]. Then increment i1
//            else if(arr1[i1] < arr2[i2]) {
//                i1++;
//            }
//            // else increment i2
//            else {
//                i2++;
//            }
//        }

        int[] big, small;
        if (arr1.length > arr2.length) {
            big = arr1;
            small = arr2;
        } else {
            big = arr2;
            small = arr1;
        }

        for (int i = 0; i < small.length; i++) {
            if (binarySearch(big, small[i]) != -1) {
                dups.add(small[i]);
            }
        }

        int[] result = dups.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    static int binarySearch(int[] a, int v) {
        int b = 0;
        int e = a.length - 1;
        while (b <= e) {
            int m = b + ((e - b) / 2);
            if (a[m] < v) {
                b = m + 1;
            } else if (a[m] > v) {
                e = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 6, 7}, arr2 = {3, 6, 7, 8, 20};

        System.out.println(Arrays.toString(findDuplicates(arr1, arr2)));

    }

}