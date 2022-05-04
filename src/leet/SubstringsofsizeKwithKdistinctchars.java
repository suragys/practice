package leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringsofsizeKwithKdistinctchars {
    public List<String> Count(String S, int k){
        int distinct=0,i=0;
        int [] memo=new int[26];
        Set<String> set=new HashSet<>();
        for (;i<k;i++){
            if (memo[S.charAt(i)-'a']==0)
                distinct+=1;
            memo[S.charAt(i)-'a']+=1;
        }
        if (distinct==k) {
            set.add(S.substring(i-k,i));
        }
        while (i<S.length()){
            if (memo[S.charAt(i)-'a']==0)
                distinct+=1;
            memo[S.charAt(i)-'a']+=1;
            memo[S.charAt(i-k)-'a']-=1;
            if (memo[S.charAt(i-k)-'a']==0)
                distinct-=1;
            if (distinct==k)
                set.add(S.substring(i-k+1,i+1));
            i+=1;
        }

        return new ArrayList<>(set);
    }
}
