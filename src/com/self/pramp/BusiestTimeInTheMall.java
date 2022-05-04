package com.self.pramp;

import java.util.Arrays;

public class BusiestTimeInTheMall {

    static int findBusiestPeriod(int[][] data) {
        // your code goes here
        int c = 0;
        int b[] = new int[2];
        b[0] = Integer.MIN_VALUE;
        b[1] = Integer.MIN_VALUE;
        int ntime;
        for(int i = 0; i < data.length; i++){
            int time = data[i][0];
            if(i < data.length -1){
                ntime = data[i+1][0];
            } else {
                ntime = 0;
            }
            int ppl = data[i][2] == 1 ? data[i][1] : -data[i][1];
            c = c + ppl;
            if(ntime == time) {
                continue;
            } else {
                if(c > b[0]) {
                    b[0] = c;
                    b[1] = time;
                }
            }
        }
        return b[1];
    }


    static int findBusiestPeriod_cleaned(int[][] data) {
        // your code goes here
        int count = 0;
        int bTime = Integer.MIN_VALUE;
        int bCount = Integer.MIN_VALUE;
        int ntime;
        for(int i = 0; i < data.length; i++){
            int time = data[i][0];
            count = count + (data[i][2] == 1 ? data[i][1] : -data[i][1]);
            if(i < data.length - 1 && data[i+1][0] == time) {
                continue;
            } else {
                if(count > bCount) {
                    bCount = count;
                    bTime = time;
                }
            }
        }
        return bTime;
    }

    public static void main(String[] args) {
        int[][] data = { {1487799425, 14, 1},
                {1487799425, 4,  1},
                {1487799425, 2,  1},
                {1487800378, 10, 1},
                {1487801478, 18, 1},
                {1487801478, 18, 1},
                {1487901013, 1,  1},
                {1487901211, 7,  1},
                {1487901211, 7,  1} };

        System.out.println(findBusiestPeriod(data));
    }
}
