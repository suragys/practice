package com.self.pramp;

import java.util.Stack;

public class IndexEqualsValueSearch {
    static int indexEqualsValueSearch(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {

            // find mid
            int m = (e + s) / 2;
            if (arr[m] < m) {
                s = m + 1;
            } else if (arr[m] == m && (m == 0 || arr[m - 1] != m - 1)) {
                return m;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }


//    static int indexEqualsValueSearchw(int[] arr) {
//
//        binary(arr, 0, arr.length-1);
//
//        return -1;
//    }
    //{4, 5, 7, 8}

    // [................ a[mid] ..........]
    //                     4(3) num>4
    // a[mid] = mid
    // a[mid] > mid  4>3

//    private static int binary(int arr[], int l, int r) {
//        if(r>=l) {
//            int mid = r-l/2;
//
//            if(arr[mid] == mid) {
//                return mid;
//            } else if(arr[mid] > t) {
//                retrun binary(arr, l, mid-1);
//            } else if(arr[mid] < t) {
//                retrun binary(arr, mid+1, r);
//            }
//        }
//        return -1;
//    }


    public static void main(String[] args) {
        int[] arr = {0-1, 1-1, 2 - 1, 3};
        int r = indexEqualsValueSearch(arr);
        System.out.println(r);


    }
}
