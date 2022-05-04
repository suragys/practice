package leet;

import java.util.*;

public class GenerateParenthesis {

    int num = 0;

    public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();

//        allCombinations("", n, result);
//        return new ArrayList<String>(result);
//        result.add("");
//        Set<String> result2 = combinations(result,n);
//        return new ArrayList<String>(result2);

        return find_all_well_formed_brackets(n);
    }

    void allCombinations(String s, int n, Set<String> brackets) {
        if (n == 0) {
            brackets.add(s);
            System.out.println(++num);
            System.out.println(s);
        } else {
            // add front
            String fs = "()" + s;
            // add back
            String bs = s + "()";
            // surround
            String ss = "(" + s + ")";
            n--;
            allCombinations(fs, n, brackets);
            allCombinations(bs, n, brackets);
            allCombinations(ss, n, brackets);
        }


    }

    Set<String> combinations(Set<String> combinations, int n) {
        System.out.println(combinations);
        System.out.println(n);
        if(n == 0) {
            System.out.println(++num);
            return combinations;
        }
        Set<String> set = new HashSet<>();
        for(String s: combinations){
            String ls = "()" + s;
            String rs = s + "()";
            String ss = "(" + s + ")";
            set.add(ls);
            set.add(rs);
            set.add(ss);
        }
        return combinations(set, --n);
    }

    static ArrayList<String> find_all_well_formed_brackets(int n) {
        Set<String> p  = new HashSet<String>();
        p.add("");
        Set<String> res = helper(p, n);
        return new ArrayList<String>(res);
//        return res.toArray(new String[0]);
    }

    static Set<String> helper(Set<String> p, int n){
        // base case
        if(n == 0){
            return p;
        }
        Set<String> temp = new HashSet<String>();

        for(String s : p){
            // add front
            String fs = "()" + s;
            // add back
            String bs = s + "()";
            // surround
            String ss = "(" + s + ")";
            n--;
            temp.add(fs);
            temp.add(bs);
            temp.add(ss);
        }
        return helper(temp, n);
    }

    /*
     * Complete the function below.
     */
    static boolean check_if_sum_possible(long[] arr, long k) {

        return helper(arr, 0, k, new ArrayList<Long>());

    }

    static boolean helper(long[] arr, int s, long k, ArrayList<Long> p) {
        if(s == arr.length){
            long sum = findSum(p);
            if(sum == k);
            return true;
        }

        // recursion
        // exclude
        boolean res1 = helper(arr, s + 1, k, p);

        // include
        p.add(arr[s]);
        boolean res2 = helper(arr,s + 1, k, p);
        p.remove(p.size()-1);
        return res1 || res2;
    }


    static long findSum(ArrayList<Long> p){
        long s = 0;
        for(long l : p){
            s += l;
        }
        return s;
    }



    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> r = gp.generateParenthesis(4);
        Collections.sort(r);
        System.out.println(r);
        System.out.println(r.size());
        for (String s :
                r) {
            System.out.println(s);
        }



    }

    /*
    ["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
    [(((()))),   ((()())),  ((())()),  ((()))(),  (()(())),  (()()()),  (()())(),             (())()(),  ()((())),  ()(()()),  ()(())(),  ()()(()),  ()()()()]
     */


    /*
     private List<String> res = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    private void genComb(int n, int left, int right) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append('(');
            genComb(n, left + 1, right);
            sb.setLength(sb.length() - 1);
        }

        if (right < left) {
            sb.append(')');
            genComb(n, left, right + 1);
            sb.setLength(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        res.clear();

        if (n == 0) {
            return res;
        }

        genComb(n, 0, 0);
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.generateParenthesis(3);

    }



    void backtrack(List<String> p,StringBuilder cand,int n,int i,int o,int c){
        if(i>n*2){
            if(o==c)p.add(cand.toString());
            return;
        }

        if(o<n){
            cand.append("(");
            backtrack(p,cand,n,i+1,o+1,c);
            cand.deleteCharAt(cand.length()-1);
        }
        if(o>c){
            cand.append(")");
            backtrack(p,cand,n,i+1,o,c+1);
            cand.deleteCharAt(cand.length()-1);
        }
    }
     */
}
