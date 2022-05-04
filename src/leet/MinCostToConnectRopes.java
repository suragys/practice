package leet;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectRopes {
    public static int minCost(int[] ropes){
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        for(int i : ropes) {
            minQ.add(i);
        }

        int minCost = 0;
        while(minQ.size() > 1) {
            int min1 = minQ.poll();
            int min2 = minQ.poll();

            int sum = min1 + min2;
            minQ.add(sum);
            minCost += sum;
        }

        return minCost;
    }

    public static void main(String args[])
    {
        int len[] = { 4, 3, 2, 6 };
        int size = len.length;
        System.out.println("Total cost for connecting"
                + " ropes is " + minCost(len));
    }
}
