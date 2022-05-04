package leet;

import java.util.LinkedList;
import java.util.Queue;

public class _994RottingOranges {
    public int orangesRotting(int[][] grid) {
        /*
             0 = empty
             1 = fresh Orange
             2 = rotten Orange

             1 min = fresh Orange next to rotten Orange gets rottens

             How many mins ? to completly rot all the oranges?

             iterate the matrix
                get count of fresh
                get all the cells that have rotten oranges

            take a minute counter
            do level order traversal for each rotten orange until all the oranges or rotten or the traversal completes

            increment minute counter when you traverse each level

             return minute counter or -1;

        */
        // iterate the matrix
        //         get count of fresh
        //         get all the cells that have rotten oranges

        Queue<Point> q = new LinkedList<>();
        int freshOranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    q.add(new Point(i, j));
                }
            }
        }

        if (freshOranges == 0) return 0;

        // level order traversal
        int mins = 0;
        while (!q.isEmpty()) {
            mins++;
            //System.out.println(mins);
            int size = q.size();

            for (int i = 0; i < size; i++) {
                // Check all four directions and look for fresh Oranges keeping grid bounds in mind
                // left
                Point p = q.poll();
                if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == 1) {
                    grid[p.x][(p.y) - 1] = 2;
                    q.offer(new Point(p.x, p.y - 1));
                    freshOranges--;
                }
                // right
                if (p.y + 1 < grid[p.x].length && grid[p.x][p.y + 1] == 1) {
                    grid[p.x][p.y + 1] = 2;
                    q.offer(new Point(p.x, p.y + 1));
                    freshOranges--;
                }
                // top
                if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == 1) {
                    grid[p.x - 1][p.y] = 2;
                    q.offer(new Point(p.x - 1, p.y));
                    freshOranges--;
                }
                // down
                if (p.x + 1 < grid.length && grid[p.x + 1][p.y] == 1) {
                    grid[p.x + 1][p.y] = 2;
                    q.offer(new Point(p.x + 1, p.y));
                    freshOranges--;
                }


            }
            //System.out.println("fo = " + freshOranges);
            if (freshOranges <= 0) break;
        }

        int res = freshOranges > 0 ? -1 : mins;
        return res;

    }

    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " : " + y;
        }
    }
}
