package leet;

import java.util.ArrayList;
import java.util.List;

public class _200NumberofIslands {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j =0; j < grid[i].length; j++){
                if(grid[i][j] == '1') {
                    traverse(i,j,grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void traverse(int x, int y, char[][] m) {
        m[x][y] = 0;
        // left
        if(y - 1 >=0 && m[x][y - 1] == '1') {
            traverse(x,y - 1, m);
        }
        // right
        if(y + 1 < m[x].length && m[x][y + 1] == '1') {
            traverse(x,y + 1, m);
        }
        // up
        if(x - 1 >=0 && m[x - 1][y] == '1') {
            traverse(x - 1,y, m);
        }
        // down
        if(x + 1 < m.length && m[x + 1][y] == '1') {
            traverse(x + 1,y, m);
        }
    }
}
