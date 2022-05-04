package leet;

public class _240Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
     /*
        binary search on colum

        binary search on row,

        return binary search on colum || binary search on row;
     */

        for(int i = 0, j = 0; i < matrix.length && j < matrix[i].length; i++,j++) {
            // System.out.println("cal search" + i);
            boolean colResult = binarySearch(matrix, i, 0, matrix[0].length - 1, true, target);
            // System.out.println("row search" + j);
            boolean rowResult = binarySearch(matrix, j, 0, matrix.length - 1, false, target);
            if(colResult || rowResult) return true;
        }
        return false;
    }

    public boolean binarySearch(int[][] m, int index, int l, int r, boolean isColSearch, int t) {
        if( l <= r) {
            int mid = (l + r) / 2;
            // System.out.println(mid);
            int val;
            if(isColSearch) {
                val = m[index][mid];
            } else {
                val = m[mid][index];
            }
            if (val == t) return true;
            if(val < t){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            return binarySearch(m, index, l , r, isColSearch, t);
        }
        return false;

    }
}
