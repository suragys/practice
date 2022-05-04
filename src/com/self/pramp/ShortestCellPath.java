package com.self.pramp;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ShortestCellPath {
    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        // q to to BFS
        Queue<Node> q = new ConcurrentLinkedDeque<>();
        // distance variable to find the shortest distance
        int distance = Integer.MAX_VALUE;

        // find adjacent nodes with value 1 and add to the q
        addQ(grid, q, sr, sc, 0);

        while (q.size() != 0) {
            // dequeue node
            Node n = q.poll();


            // if the node is the destination. Then calculate the shortest distance
            if (n.x == tr && n.y == tc) {
                if (distance > n.d) {
                    distance = n.d;
                }
                continue;
            }

            addQ(grid, q, n.x, n.y, n.d);
        }

        return distance == Integer.MAX_VALUE ? -1 : distance;
    }

    static class Node {
        int x;
        int y;
        int d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static void addQ(int[][] m, Queue<Node> q, int i, int j, int d) {
        // check right
        d++;
        int l = j - 1, r = j + 1, t = i - 1, b = i + 1;

        if (r < m[i].length && m[i][r] == 1) {
            m[i][r] = 0;
            q.add(new Node(i, r, d));
        }
        if (b < m.length && m[b][j] == 1) {
            m[b][j] = 0;
            q.add(new Node(b, j, d));
        }
        if (l >= 0 && m[i][l] == 1) {
            m[i][l] = 0;
            q.add(new Node(i, l, d));
        }
        if (t >= 0 && m[t][j] == 1) {
            m[t][j] = 0;
            q.add(new Node(t, j, d));
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1}, {0, 1, 0, 1}, {1, 1, 1, 1}};
        int sr = 0;
        int sc = 0;
        int tr = 2;
        int tc = 0;

//        grid = new int[][]{{1, 1, 1, 1}, {0, 0, 0, 1}, {1, 0, 1, 1}};

        System.out.println(shortestCellPath(grid, sr, sc, tr, tc));
    }
}
