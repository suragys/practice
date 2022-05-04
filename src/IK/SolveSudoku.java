package IK;

import com.sun.org.apache.bcel.internal.generic.ALOAD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolveSudoku {


    static ArrayList<ArrayList<Integer>> solve_sudoku_puzzle(ArrayList<ArrayList<Integer>> board) {
        helper(0, 0, board, board.size());
        return board;
    }

    static void checkRow(Set<Integer> def, int i, ArrayList<ArrayList<Integer>> board) {
        for(int x = 0; x < board.size(); x++) {
            int v = board.get(i).get(x);
            if(def.contains(v)){
                def.remove(v);
            }
        }
    }

    static void checkCol(Set<Integer> def, int j,  ArrayList<ArrayList<Integer>> board) {
        for(int x = 0; x < board.size(); x++) {
            int v = board.get(x).get(j);
            if(def.contains(v)){
                def.remove(v);
            }
        }
    }

    static void checkQuad(Set<Integer> def, int i, int j,  ArrayList<ArrayList<Integer>> board) {
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                int v = board.get(x+i).get(y+j);
                if(def.contains(v)){
                    def.remove(v);
                }
            }
        }
    }

    static boolean helper(int i, int j, ArrayList<ArrayList<Integer>> board, int n){
        boolean result = false;
        if(i == n) {
            return true;
        }

        int temp = board.get(i).get(j);

        if(temp == 0) {
            Set<Integer> def = new HashSet<>();
            for(int k = 1; k < 10; k++) {
                def.add(k);
            }

            checkRow(def,i, board);
            checkCol(def,j, board);
            checkQuad(def, (i/3)*3, (j/3)*3, board);


            for(Integer x : def) {
                board.get(i).set(j,x);
                result = helper((j+1) % 9 == 0 ? i+1 : i, (j+1) % 9, board, board.size());
                if(!result) {
                    board.get(i).set(j,0);
                } else {
                    return true;
                }
            }
        } else {
            result = helper((j+1) % 9 == 0 ? i+1 : i, (j+1) % 9, board, board.size());
        }

        return result;
    }



    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(8, 4, 9, 0, 0, 3, 5, 7, 0));
        ArrayList<Integer> b = new ArrayList<>( Arrays.asList(0, 1, 0, 0, 0, 0, 0, 0, 0));
        ArrayList<Integer> c = new ArrayList<>( Arrays.asList(7, 0, 0, 0, 9, 0, 0, 8, 3));
        ArrayList<Integer> d = new ArrayList<>( Arrays.asList(0, 0, 0, 9, 4, 6, 7, 0, 0));
        ArrayList<Integer> e = new ArrayList<>( Arrays.asList(0, 8, 0, 0, 5, 0, 0, 4, 0));
        ArrayList<Integer> f = new ArrayList<>( Arrays.asList(0, 0, 6, 8, 7, 2, 0, 0, 0));
        ArrayList<Integer> g = new ArrayList<>( Arrays.asList(5, 7, 8, 6, 1, 9, 2, 3, 4));
        ArrayList<Integer> h = new ArrayList<>( Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1, 0));
        ArrayList<Integer> i = new ArrayList<>( Arrays.asList(0, 2, 1, 7, 0, 0, 8, 6, 5));
        
        ArrayList<ArrayList<Integer>> s = new ArrayList<>();
        s.add(a);
        s.add(b);
        s.add(c);
        s.add(d);
        s.add(e);
        s.add(f);
        s.add(g);
        s.add(h);
        s.add(i);

        System.out.println(s.toString());
        solve_sudoku_puzzle(s);
        System.out.println(s.toString());


        /*
        [8, 4, 9, 0, 0, 3, 5, 7, 0],
[0, 1, 0, 0, 0, 0, 0, 0, 0],
[7, 0, 0, 0, 9, 0, 0, 8, 3],
[0, 0, 0, 9, 4, 6, 7, 0, 0],
[0, 8, 0, 0, 5, 0, 0, 4, 0],
[0, 0, 6, 8, 7, 2, 0, 0, 0],
[5, 7, 0, 0, 1, 0, 0, 0, 4],
[0, 0, 0, 0, 0, 0, 0, 1, 0],
[0, 2, 1, 7, 0, 0, 8, 6, 5]
         */

    }
}
