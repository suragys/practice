package leet;

import java.util.PriorityQueue;
import java.util.Queue;

public class _973KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        Queue<Point> q = new PriorityQueue<Point>((o1, o2) -> {
            return o1.d - o2.d;
        });
        for(int[] point: points) {

        }
        return null;
    }

    public class Point {
        int x;
        int y;
        int d;

        public Point(int a, int b) {
            x = a;
            y = b;
            d = (x*x) + (y*y);
        }
    }
}
