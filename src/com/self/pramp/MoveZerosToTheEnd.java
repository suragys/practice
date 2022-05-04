package com.self.pramp;

import java.util.Arrays;

public class MoveZerosToTheEnd {
    static int[] moveZerosToEnd(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int j = i + 1;
                for (; j < arr.length - 1; j++) {
                    if (arr[j] != 0) break;
                }
                swap(arr, i, j);
            }
        }
        return arr;
    }

    static int[] moveZerosToEnd2(int[] arr) {
        int i = 0;
        int j = 0;
        while (i < arr.length) {
            if (arr[i] != 0) {
                arr[j++] = arr[i];
            }
            i++;
        }
        while (j < arr.length) {
            arr[j++] = 0;
        }


        return arr;
    }

    private static int[] swap(int[] a, int i, int j) {
        a[i] = a[j];
        a[j] = 0;
        return a;
    }

    private static int findNZ(int[] a, int i) {
        while (i < a.length) {
            if (a[i] != 0) {
                return i;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 0, 2, 8, 3, 0, 0, 6, 4, 0, 5, 7, 0};
        int[] arr2 = {6, 1, 3, 0, 0, -1, 2, 7, 8, 9};


        System.out.println(Arrays.toString(moveZerosToEnd2(arr2)));
    }


}
