package com.self.pramp;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int time = 1;
        int ppl = 2;
        int isEnter = 1 == 1 ? ppl : -ppl;

        System.out.printf("time = %d: ppl = %d", time, ppl*isEnter);
        System.out.println();
    }
}
