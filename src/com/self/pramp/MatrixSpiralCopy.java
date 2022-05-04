package com.self.pramp;

import java.util.Arrays;

public class MatrixSpiralCopy {

    static int[] spiralCopy(int[][] inputMatrix) {
        int[][] im = inputMatrix;
        //if(inputMatrix == null || inputMatrix.length == 0 || inputMatrix[0].length == 0) return null;
        int[] m = new int[inputMatrix.length*inputMatrix[0].length];
        int sri = 0;
        int sci = 0;
        int eri = inputMatrix.length;
        int eci = inputMatrix[0].length ;

        int mi = 0;
        while(sri < eri && sci < eci) {
            int i = sri;
            int j = sci;
            // move right
            while(j < eci) {
                m[mi++] = im[i][j++];
            }
            j--;
            i++;
            sri++;
            // move down
            while(i < eri ) {
                m[mi++] = im[i++][j];
            }
            i--;
            j--;
            eci--;
            // move left
            while(j > sci) {
                m[mi++] = im[i][j--];
            }
            eri--;
            // move up
            while(i >= sri) {
                m[mi++] = im[i--][j];
            }
            sci++;
        }
        return m;
    }

    static int[] spiralCopy1(int[][] im){
        int[] m = new int[im.length * im[0].length];
        int sri = 0;
        int sci = 0;
        int eri = im.length - 1;
        int eci = im[0].length - 1;

        int mi = 0;
        while(sri < eri && sci < eci) {
            int j = sci;
            int i = sri;
            // move right
            while (j <= eci) {
                m[mi++] = im[i][j++];
            }
            j--;
            i++;
            sri++;
            // move down
            while(i <= eri) {
                m[mi++] = im[i++][j];
            }
            i--;
            j--;
            eci--;
            // move left
            while(j >= sci){
                m[mi++] = im[i][j--];
            }
            j++;
            i--;
            eri--;
            //move up
            while(i >= sri) {
                m[mi++] = im[i--][j];
            }
            sci++;
        }
        return m;
    }
    public static void main(String[] args) {
        int[][] inputMatrix = null;


        inputMatrix  = new int[][]{{1,    2,   3,  4,    5},
                {6,    7,   8,  9,   10},
                {11,  12,  13,  14,  15},
                {16,  17,  18,  19,  20}};



        System.out.println("Hello");
        System.out.println(Arrays.toString(spiralCopy1(inputMatrix)));
        int[] o =  {1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12};
        System.out.println(Arrays.toString(o));
    }
}
