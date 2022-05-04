package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _763PartitionLabels {
    public List<Integer> partitionLabels(String S) {
      /*

      1. take the fist element of the String  x
      2. Get the last occurance of the element x
      3. within the first occurance to last occurance check each letters last occurance
            3.a if any letter's last occurance is greater than that of the last occurance of x then the partition should grow till the last occurance of letter repeat 3

            3.b else we got the partition now move to next letter and repeat from 1.

      */

        int[] l = new int[26];
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < S.length(); i++){
            l[S.charAt(i)- 'a'] = i;
        }

        List<Integer> sd = Arrays.stream(l)
                .boxed()
                .collect(Collectors.toList());

        // System.out.println(Arrays.toString(l));

        int i = 0;
        while(i < S.length()) {
            int lastOccurance = l[S.charAt(i) - 'a'];
            for(int j = i; j <= lastOccurance; j++) {
                int temp = l[S.charAt(j) - 'a'];
                if(temp > lastOccurance) {
                    lastOccurance = temp;
                }
            }
            // System.out.println(lastOccurance);
            // System.out.println(c[lastOccurance]);
            res.add(lastOccurance - i + 1);
            i = lastOccurance;
            i++;
        }
        return res;
    }
}
