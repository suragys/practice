package leet;

public class _59SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];

        int sr = 0;
        int sc = 0;

        int er = n - 1;
        int ec = n - 1;
        int c = 1;
        while (c <= n * n) {
            System.out.println(c);
            int i = sr;
            int j = sc;
            // move right
            while (j <= ec) {
                // if(c == 9) System.out.println(c+","+i+","+j);
                m[i][j] = c;
                c++;
                j++;
            }
            sr++;
            j--;
            i++;
            // move down
            while (i <= er) {
                // if(c == 9) System.out.println(c+","+i+","+j);
                m[i][j] = c;
                c++;
                i++;
            }
            ec--;
            i--;
            j--;
            //move left
            while (j >= sc) {
                // if(c == 9) System.out.println(c+","+i+","+j);
                m[i][j] = c;
                c++;
                j--;
            }
            er--;
            j++;
            i--;
            while (i >= sr) {
                // if(c == 9) System.out.println(c+","+i+","+j);
                m[i][j] = c;
                c++;
                i--;
            }
            sc++;
            // System.out.println(sr+","+sc+","+er+","+ec);
        }
        return m;
    }
}
