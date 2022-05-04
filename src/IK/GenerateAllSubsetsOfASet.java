package IK;

import java.util.ArrayList;
import java.util.Arrays;

/*
Generate ALL possible subsets of a given set. The set is given in the form of a string s containing distinct lowercase characters 'a' - 'z'.

Example

Input: "xy"

Output: ["", "x", "y", "xy"]

Notes

Input Parameters: There is only one argument denoting string s.

Output: Return array of strings res, containing ALL possible subsets of given string. You need not to worry about order of strings in your output array. E.g. s = "a", arrays ["", "a"] and ["a", ""]  both will be accepted.

Order of characters in any subset must be same as in the input string. For s = "xy", array ["", "x", "y", "xy"] will be accepted, but ["", "x", "y", "yx"] will not be accepted.

Constraints:

0 <= |s| <= 19
s only contains distinct lowercase alphabetical letters ('a' - 'z').
Empty set is a subset of any set.

Any set is a subset of itself.
 */
public class GenerateAllSubsetsOfASet {

    static String[] generate_all_subsets(String s) {

        ArrayList<String> r = new ArrayList<String>();

        StringBuilder sb = new StringBuilder();
        helper(s, 0, sb, r);

        s.substring(0, 1);
        String result[] = r.toArray(new String[r.size()]);

        r.remove(r.size() - 1);
        return result;
    }

    private static void helper(String s, int i, StringBuilder sb, ArrayList<String> r) {
        if (i == s.length()) {
            r.add(sb.toString());
            return;
        }

        helper(s, i + 1, sb, r);

        helper(s, i + 1, sb.append(s.charAt(i)), r);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        String[] ans = generate_all_subsets("abc");
//        System.out.println(Arrays.toString(ans));

        System.out.println(isPalindrome("abc"));
    }

//    static void helper(String s, int i, String sp, ArrayList<String> r) {
//        if(i == s.length()) {
//            // System.out.println("res=" + sp);
//            r.add(sp);
//            return;
//        }
//        // recursion
//        // choose to add the char at index to sp
//        helper(s, i+1, sp + s.charAt(i), r);
//
//        // choose not to add the char at index to the sp
//        helper(s, i+1, sp, r);
//    }

    static boolean isPalindrome(String p) {
        /*
        "a"
        i = 0
        j = 0
        t

        "aa"
        i = 0 ; 1
        j = 1 ; 0
        t

        "aba"
        i = 0; 1 ; 2
        j = 2; 1 ; 0
        t

        abc
        f

        */
        char[] c = p.toCharArray();
        int i = 0;
        int j = c.length - 1;

        while (i < j) {
            System.out.println("i=" + i + "j=" + j);
            if (c[i] != c[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
